package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.shared.Util
import reactor.core.publisher.Mono

fun main() {
    getUserName(3)
        .subscribe(Util.subscriber())
}

fun getUserName(userId: Int): Mono<String> {
    return when(userId) {
        1 -> Mono.just("sam")
        2 -> Mono.empty()
        else -> Mono.error(RuntimeException("invalid input"))
    }
}
