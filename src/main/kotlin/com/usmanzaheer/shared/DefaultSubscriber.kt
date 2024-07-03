package com.usmanzaheer.com.usmanzaheer.shared

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import org.slf4j.LoggerFactory

class  DefaultSubscriber<T>(
    private val name: String,
) : Subscriber<T> {

    override fun onSubscribe(subscription: Subscription) {
        subscription.request(Long.MAX_VALUE)
    }

    override fun onError(p0: Throwable) {
        logger.error("$name error $p0")
    }

    override fun onComplete() {
        logger.info("$name completed!")
    }

    override fun onNext(item: T) {
        logger.info("$name received $item")
    }


    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}