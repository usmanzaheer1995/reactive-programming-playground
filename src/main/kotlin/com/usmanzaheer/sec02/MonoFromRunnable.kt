package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.shared.Util
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

fun main() {
    MonoFromRunnable()
}

class MonoFromRunnable {
    init {
        getProductName(2)
            .subscribe(Util.subscriber())
    }

    private fun getProductName(productId: Int): Mono<String> {
        if (productId == 1) {
            return Mono.fromSupplier{ Util.faker().commerce().productName() }
        }
        return Mono.fromRunnable { notifyBusiness(productId) }
    }

    private fun notifyBusiness(productId: Int) {
        logger.info("notifying business on unavailable product $productId")
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}