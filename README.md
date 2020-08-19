# Bazel Micronaut Example
- To build the "fat" jar run `bazel build //:bazel-micronaut-example_deploy.jar`
- To run the service `java -jar bazel-bin/bazel-micronaut-example_deploy.jar`
    - You can also just use the `bazel run //:bazel-micronaut-example`
- To say hello, in a browser go to `http://localhost:9980/bazel-mn/hello`
- To say goodbye, in a browser go to `http://localhost:9980/bazel-mn/goodbye`
- Execute the tests: `bazel build //:micronaut_tests`

## Description
This is a Kotlin project, utilizing Micronaut, has a single REST endpoint. Your basic `Hello Micronaut/Bazel` project.
This is interesting in that it does not use the standard generated Gradle build files from the Micronaut CLI, but instead utilizes
Bazel. The BUILD.bazel file shows how to set up the necessary Annotation processors needed for Micronaut to do its magic.

For more on the WHY behind this check out the first post in the series 
[Bazel and Micronaut – An unlikely beautiful match](http://sumglobal.com/2020/03/10/bazel-and-micronaut)

In the second post in the series we discuss how to get your Micronaut Tests to work. In the BUILD.bazel file, this is located at the
end of the file in the section `kt_jvm_test` section. To get the testing ease from your Micronaut project, there are a few "tricks" to
making it work. To run the tests: `bazel test //:micronaut_tests`. For more of the details of making the tests work, you can check out the second post in the series [Bazel Test, JUnit5 and Micronaut -Growing the relationship](https://sumglobal.com/2020/04/15/bazel-test-with-micronaut/)

## Updates
- Updated bazel, dependencies and kotlin rule to the latest as of 8/19/2020