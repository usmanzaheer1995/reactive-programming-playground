package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.shared.Util
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

fun main() {
    MonoDefer()
}

class MonoDefer {
    init {
        Mono.defer{ createPublisher() }
            .subscribe(Util.subscriber())
    }

    private fun createPublisher(): Mono<Int> {
        logger.info("creating publisher")
        val list = listOf(1, 2, 3)

        Util.sleepSeconds(1)

        return Mono.fromSupplier { sum(list) }
    }

    private fun sum(list: List<Int>): Int {
        logger.info("finding the sum of $list")

        Util.sleepSeconds(3)

        return list.stream().mapToInt { it }.sum()
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}