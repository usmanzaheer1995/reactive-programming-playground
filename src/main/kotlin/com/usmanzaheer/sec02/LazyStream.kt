package com.usmanzaheer.com.usmanzaheer.sec02

import org.slf4j.LoggerFactory
import java.util.stream.Stream

fun main() {
    LazyStream()
}

class LazyStream() {

    init {
        Stream.of(1)
            .peek{ logger.info("received: $it") }
            .toList()
    }


    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)

        @JvmStatic
        private val MAX_ITEMS = 10
    }
}