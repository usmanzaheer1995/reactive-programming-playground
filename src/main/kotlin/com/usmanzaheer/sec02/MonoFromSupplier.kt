package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.shared.Util
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono


fun main() {
    MonoFromSupplier()
}

class MonoFromSupplier {

    init {
        val list = listOf(1, 2, 3)
        Mono.fromSupplier { sum(list) }
            .subscribe(Util.subscriber())
    }

    private fun sum(list: List<Int>): Int {
        logger.info("finding the sum of $list")
        return list.stream().mapToInt { it }.sum()
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}