package com.usmanzaheer.com.usmanzaheer.shared

import com.github.javafaker.Faker
import org.reactivestreams.Subscriber
import java.time.Duration

class Util {
    companion object {
        @JvmStatic
        private val faker = Faker.instance()

        @JvmStatic
        fun <T>subscriber(): Subscriber<T> {
            return DefaultSubscriber("")
        }

        @JvmStatic
        fun <T>subscriber(name: String): Subscriber<T> {
            return DefaultSubscriber(name)
        }

        @JvmStatic
        fun faker(): Faker {
            return faker
        }

        @JvmStatic
        fun sleepSeconds(seconds: Int) {
            try {
                Thread.sleep(Duration.ofSeconds(seconds.toLong()))
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }
        }
    }
}