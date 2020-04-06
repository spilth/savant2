package org.spilth.savant;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class InitializeService {
    public InitializeService(InitializeCommand command) {
        String projectPath = "./" + command.artifactId;
        String pomPath = projectPath + "/pom.xml";
        String[] packageDirectories = command.groupId.split("\\.");
        String packagePath = String.format("%s/%s", String.join("/", packageDirectories), command.artifactId);
        String mainPath = projectPath + "/src/main/java/" + packagePath;
        String testPath = projectPath + "/src/test/java/" + packagePath;
        String resourcesPath = projectPath + "/src/main/resources";

        System.out.println("Creating project directory `" + command.artifactId + "`");
        new File(projectPath).mkdir();

        System.out.println("Generating source directories...");
        new File(mainPath).mkdirs();
        new File(testPath).mkdirs();
        new File(resourcesPath).mkdirs();

        System.out.println("Creating pom.xml...");
        Model model = getModel(command.jdkVersion, command.groupId, command.artifactId);

        try {
            FileWriter pomWriter = new FileWriter(pomPath);
            MavenXpp3Writer mavenXpp3Writer = new MavenXpp3Writer();
            mavenXpp3Writer.write(pomWriter, model);
            pomWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finished!");
        System.out.println();
        System.out.println("Now run the following commands:");
        System.out.println("  cd " + command.artifactId);
        System.out.println("  mvn package");
    }

    private Model getModel(String jdkVersion, String groupId, String artifactId) {
        Properties properties = new Properties();
        properties.put("project.build.sourceEncoding", "UTF-8");
        properties.put("maven.compiler.source", jdkVersion);
        properties.put("maven.compiler.target", jdkVersion);

        Model model = new Model();
        model.setModelVersion("4.0.0");
        model.setGroupId(groupId);
        model.setArtifactId(artifactId);
        model.setPackaging("jar");
        model.setVersion("1.0.0-SNAPSHOT");
        model.setName(artifactId);
        model.setProperties(properties);

        return model;
    }
}
