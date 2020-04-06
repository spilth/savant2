package org.spilth.savant;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandNames = {"init"}, commandDescription = "Initialize a new Maven project")
public class InitializeCommand {
    @Parameter(description = "Artifact ID", required = true)
    public String artifactId;

    @Parameter(names={"--groupId", "-g"}, description = "Group ID")
    public String groupId = "com.example";

    @Parameter(names={"--jdk", "-j"}, description = "JDK Version")
    public String jdkVersion = "1.8";
}
