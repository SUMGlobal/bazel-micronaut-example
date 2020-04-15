package com.sumglobal.main

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue
import javax.inject.Inject


@MicronautTest()
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class HelloBazelMicronautControllerTest {
    @Inject
    lateinit var embeddedServer: EmbeddedServer
    lateinit var client: HttpClient
    @Inject
    lateinit var ctx: ApplicationContext

    @BeforeAll
    fun beforeAll() {
        client = HttpClient.create(embeddedServer.url)
    }

    /**
     * This is a contract test for the "hello" endpoint
     */
    @Test
    fun hello() {
        val request = HttpRequest.GET<Any>("/bazel-mn/hello")
        val rsp = client.toBlocking().exchange(request, String::class.java)
        assertTrue(rsp.body.isPresent)
        val root = rsp.body.get()
        print("Message received is $root")
        Assertions.assertEquals("Hello from Bazel/Micronaut example!", root)
    }

    /**
     * This is a contract test for the "goodbye" endpoint
     */
    @Test
    fun goodbye() {
        val request = HttpRequest.GET<Any>("/bazel-mn/goodbye")
        val rsp = client.toBlocking().exchange(request, String::class.java)
        assertTrue(rsp.body.isPresent)
        val root = rsp.body.get()
        print("Message received is $root")
        Assertions.assertEquals("Goodbye from Bazel/Micronaut example.", root)
    }

    @AfterAll
    fun cleanup() {
        client.close()
    }
}