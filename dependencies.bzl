_MICRONAUT_VER = "1.3.2"

_DEPS = [
    "org.jetbrains.kotlin:kotlin-stdlib:1.3.70",
    "ch.qos.logback:logback-classic:1.2.3",
    "ch.qos.logback:logback-core:1.2.3",
    "org.slf4j:slf4j-api:1.7.30",
    "javax.annotation:javax.annotation-api:1.3.1",
    "org.jetbrains.exposed:exposed:0.17.7",
    "com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2",
    "io.micronaut:micronaut-runtime:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-http-client:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-http-server-netty:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-core:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-inject-java:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-inject:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-validation:%s" % _MICRONAUT_VER,
    "io.micronaut:micronaut-aop:%s" % _MICRONAUT_VER,
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3",
    "io.reactivex.rxjava2:rxkotlin:2.4.0",
]

ALL_DEPS = _DEPS