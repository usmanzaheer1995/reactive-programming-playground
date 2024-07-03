package com.usmanzaheer.com.usmanzaheer.sec02.client

import com.usmanzaheer.com.usmanzaheer.shared.AbstractHttpClient
import reactor.core.publisher.Mono

class ExternalServiceClient : AbstractHttpClient() {

    fun  getProductName(productId: Int): Mono<String> {
        return this.httpClient.get()
            .uri("/demo01/product/$productId")
            .responseContent()
            .asString()
            .next()
    }
}