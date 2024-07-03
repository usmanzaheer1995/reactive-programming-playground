package com.usmanzaheer.com.usmanzaheer.sec02

import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

fun main() {
    MonoSubscribe()
}

class MonoSubscribe {
    init {
        val mono = Mono
            .just(1)
            .map { it / 0 }

        mono.subscribe(
            { next -> logger.info("received: $next") },
            { err -> logger.error("error: ${err.message}") },
            { logger.info("completed!") },
            { subscription -> subscription.request(1) }
        )
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}