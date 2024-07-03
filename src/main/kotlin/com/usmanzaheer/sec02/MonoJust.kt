package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.sec01.subscriber.SubscriberImpl
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

fun main() {
    MonoJust()
}

class MonoJust {
    init {
        val mono = Mono.just("hello")
        val subscriber = SubscriberImpl()
        mono.subscribe(subscriber)

        subscriber.subscription.request(10)
        subscriber.subscription.request(10)
        subscriber.subscription.cancel()
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}