package org.spilth.savant;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.spilth.savant.validators.ArtifactIdValidator;
import org.spilth.savant.validators.GroupIdValidator;
import org.spilth.savant.validators.JdkVersionValidator;

@Parameters(commandNames = "init", commandDescription = "Initialize a new Maven project")
public class InitializeCommand {
    @Parameter(description = "Artifact ID", required = true, validateWith = ArtifactIdValidator.class)
    public String artifactId;

    @Parameter(names={"--groupId", "-g"}, description = "Group ID", validateWith = GroupIdValidator.class)
    public String groupId = "com.example";

    @Parameter(names={"--jdk", "-j"}, description = "JDK Version", validateWith = JdkVersionValidator.class)
    public String jdkVersion = "1.8";
}
