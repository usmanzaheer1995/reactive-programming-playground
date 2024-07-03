package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.sec02.client.ExternalServiceClient
import com.usmanzaheer.com.usmanzaheer.shared.Util
import org.slf4j.LoggerFactory

fun main() {
    NonBlockingIO()
}

class NonBlockingIO {
    init {
        val client = ExternalServiceClient()

        logger.info("starting")

        for (i in 0 until 5) {
            client.getProductName(i)
                .subscribe(Util.subscriber())
        }

        Util.sleepSeconds(2)
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}