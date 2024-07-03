package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.shared.Util
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

fun main() {
    MonoFromFuture()
}

class MonoFromFuture {
    init {
        Mono.fromFuture { getName() }
            .subscribe(Util.subscriber())

        Util.sleepSeconds(1)
    }

    private fun getName(): CompletableFuture<String> {
        return CompletableFuture.supplyAsync {
            logger.info("generating name")
            Util.faker().name().firstName()
        }
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}