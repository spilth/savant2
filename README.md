# Savant ![Build](https://github.com/spilth/savant2/workflows/Build/badge.svg) [![codecov](https://codecov.io/gh/spilth/savant2/branch/master/graph/badge.svg)](https://codecov.io/gh/spilth/savant2)

A Maven companion tool.

## Getting Started

```bash
$ git clone git@github.com:spilth/savant2.git
$ cd savant2
$ ./mvnw package
$ alias savant="java -jar ./target/savant-2.0.0-SNAPSHOT.jar"
```

Currently, the only working command is `init` which is used to create a project.

```bash
$ savant init hello
$ cd hello
$ mvn package 
```
