package com.usmanzaheer.com.usmanzaheer.sec01.subscriber

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import org.slf4j.LoggerFactory

class SubscriberImpl(
) : Subscriber<String> {

    lateinit var subscription: Subscription
        private set

    override fun onSubscribe(subscription: Subscription) {
        this.subscription = subscription
    }

    override fun onError(p0: Throwable) {
        logger.error("throwable $p0")
    }

    override fun onComplete() {
        logger.info("completed!")
    }

    override fun onNext(email: String) {
        logger.info("received $email")
    }


    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)
    }
}