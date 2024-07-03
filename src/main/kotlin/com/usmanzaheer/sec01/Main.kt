package com.usmanzaheer.com.usmanzaheer.sec01

import com.usmanzaheer.com.usmanzaheer.sec01.publisher.PublisherImpl
import com.usmanzaheer.com.usmanzaheer.sec01.subscriber.SubscriberImpl
import java.time.Duration

fun main() {
    demo4()
}

fun demo1() {
    val publisher = PublisherImpl()
    val subscriber = SubscriberImpl()
    publisher.subscribe(subscriber)
}

fun demo2() {
    val publisher = PublisherImpl()
    val subscriber = SubscriberImpl()
    publisher.subscribe(subscriber)
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
}

fun demo3() {
    val publisher = PublisherImpl()
    val subscriber = SubscriberImpl()
    publisher.subscribe(subscriber)
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.cancel()
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.request(3)
}

fun demo4() {
    val publisher = PublisherImpl()
    val subscriber = SubscriberImpl()
    publisher.subscribe(subscriber)
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.request(11)
    Thread.sleep(Duration.ofSeconds(2))
    subscriber.subscription.request(3)
    Thread.sleep(Duration.ofSeconds(2))
}
