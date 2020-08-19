workspace(name = "bazelmicronautexample")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "3.3"
RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

http_archive(
    name = "bazel_common",
    strip_prefix = "bazel-common-f1115e0f777f08c3cdb115526c4e663005bec69b",
    url = "https://github.com/google/bazel-common/archive/f1115e0f777f08c3cdb115526c4e663005bec69b.zip",
)

#load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_file")

load("@rules_jvm_external//:defs.bzl", "artifact", "maven_install",)
load("//:dependencies.bzl", "ALL_DEPS")


maven_install(
    #default name= "maven" which is referenced in the BUILD files
    artifacts = ALL_DEPS, #defined in dependencies.bzl
    version_conflict_policy = "pinned",
    repositories = [
        # Private repositories are supported through HTTP Basic auth
        #"https://username:password@localhost:8081/artifactory/my-repository",
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2",
        "https://repo.maven.apache.org/maven2",
        "https://maven.wso2.org/nexus/content/repositories/releases/",
    ],
    fetch_sources = True, # Want this to work happily with our IDE
    generate_compat_repositories = False, # Change to True use alt form alias
    # Want to be sure we pin our versions for better speed, helps to share artifacts across workspaces as well
    maven_install_json = "//:maven_install.json",
)
#loads up the pinned_maven_install and calls it so we use our pinned versions
load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

# List all artifacts retrieved. Each artifact have both a versioned and unversioned alias
#bazel query @maven//:all | sort

#rules_kotlin_version = "legacy-1.3.0"
#rules_kotlin_sha = "4fd769fb0db5d3c6240df8a9500515775101964eebdf85a3f9f0511130885fde"
#http_archive(
#    name = "io_bazel_rules_kotlin",
#    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
#    type = "zip",
#    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version,
#    sha256 = rules_kotlin_sha,
#)

rules_kotlin_version = "legacy-1.4.0-rc3"
rules_kotlin_sha = "da0e6e1543fcc79e93d4d93c3333378f3bd5d29e82c1bc2518de0dbe048e6598"#"<release sha>"
http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/%s/rules_kotlin_release.tgz" % rules_kotlin_version],
    sha256 = rules_kotlin_sha,
)


load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below
register_toolchains("//:kotlin_toolchain") # Defined in BUILD.bazel

