package com.usmanzaheer.com.usmanzaheer.sec01.publisher

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber

class PublisherImpl : Publisher<String> {
    override fun subscribe(subscriber: Subscriber<in String>) {
        val subscription = SubscriptionImpl(subscriber)
        subscriber.onSubscribe(subscription)
    }
}
