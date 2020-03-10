package com.sumglobal.main

import com.sumglobal.logger
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

/**
 * Listens for messages 
 */
@Controller("/bazel-mn")
open class HelloBazelMicronautController {

	companion object {
		private val logger = logger(this)
	}

	@Get("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	fun sayHello() : HttpResponse<Any> {
		logger.info("Received request to say hello")
		return HttpResponse.ok("Hello from Bazel/Micronaut example!")
	}

	@Get("/goodbye")
	@Produces(MediaType.APPLICATION_JSON)
	fun sayGoodbye() : HttpResponse<Any> {
		logger.info("Received request to say goodbye")
		return HttpResponse.ok("Goodbye from Bazel/Micronaut example.")
	}


}

