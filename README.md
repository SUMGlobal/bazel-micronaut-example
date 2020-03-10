# Bazel Micronaut Example
- To build the "fat" jar run `bazel build //:bazel-micronaut-example_deploy.jar`
- To run the service `java -jar bazel-bin/bazel-micronaut-example_deploy.jar`
- To say hello, in a browser go to `http://localhost:9980/bazel-mn/hello`
- To say goodbye, in a browser go to `http://localhost:9980/bazel-mn/goodbye`

## Description
This is a Kotlin project, utilizing Micronaut, has a single REST endpoint. Your basic `Hello Micronaut/Bazel` project.
This is only interesting in that it does not use the standard generated Gradle build files from the Micronaut CLI, but instead utilizes
Bazel. For more on the WHY behind this check out (http://sumglobal.com/2020/03/10/bazel-and-micronaut/(opens in a new tab))

