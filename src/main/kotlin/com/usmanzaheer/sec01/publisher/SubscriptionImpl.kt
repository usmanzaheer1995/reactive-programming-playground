package com.usmanzaheer.com.usmanzaheer.sec01.publisher

import com.github.javafaker.Faker
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import org.slf4j.LoggerFactory

class SubscriptionImpl(
    private val subscriber: Subscriber<in String>,
    private val faker: Faker = Faker.instance(),
    private var isCancelled: Boolean = false,
    private var count: Int = 0,
) : Subscription {
    override fun request(requested: Long) {
        if (isCancelled) {
            return
        }

        logger.info("subscriber has requested $requested items")

        if (requested > MAX_ITEMS) {
            subscriber.onError(IllegalArgumentException("cannot request more than $MAX_ITEMS items"))
            this.isCancelled = true
            return
        }

        for (i in 0 until requested) {
            if (count >= MAX_ITEMS) {
                subscriber.onComplete()
                this.isCancelled = true
                break
            }

            subscriber.onNext(faker.internet().emailAddress())
            count++
        }

    }

    override fun cancel() {
        logger.info("subscriber has cancelled")
        this.isCancelled = true
    }

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)

        @JvmStatic
        private val MAX_ITEMS = 10
    }
}
