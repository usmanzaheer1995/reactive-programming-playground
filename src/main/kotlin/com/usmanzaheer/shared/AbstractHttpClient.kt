package com.usmanzaheer.com.usmanzaheer.shared

import reactor.netty.http.client.HttpClient
import reactor.netty.resources.LoopResources

abstract class AbstractHttpClient {
    private val BASE_URL = "http://localhost:7070"
    protected val httpClient: HttpClient

    init {
        val loopResources = LoopResources.create("threads", 1, true)
        this.httpClient = HttpClient.create().runOn(loopResources).baseUrl(BASE_URL)
    }
}
