package com.sumglobal

import io.micronaut.runtime.Micronaut
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("UNUSED_PARAMETER")
inline fun <reified T> logger(from: T): Logger {
    return LoggerFactory.getLogger(T::class.java)
}

object Application {
    private val logger = logger(this)
    private val VERSION = "1.0.0"

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("Staring client version: {}", VERSION)
        Micronaut.run(Application.javaClass)
    }
}