package com.usmanzaheer.com.usmanzaheer.sec02

import com.usmanzaheer.com.usmanzaheer.shared.Util
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Stream

fun main() {
    FileServiceImpl()
}

class FileServiceImpl {

    init {
        write("file.txt", "hello, world!")
            .subscribe(Util.subscriber())

        read("file.txt")
            .subscribe(Util.subscriber())

        delete("file.txt")
            .subscribe(Util.subscriber())
    }

    fun read(fileName: String): Mono<String> =
        Mono.fromCallable { Files.readString(PATH.resolve(fileName)) }

    fun write(fileName: String, content: String): Mono<Void> {
        return Mono.fromRunnable {
            try {
                Files.writeString(PATH.resolve(fileName), content)
            } catch (E: Exception) {
                throw RuntimeException(E)
            }
        }
    }

    fun delete(fileName: String): Mono<Void> {
        return Mono.fromRunnable {
            try {
                Files.delete(PATH.resolve(fileName))
            } catch (E: Exception) {
                throw RuntimeException(E)
            }
        }
    }


    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val logger = LoggerFactory.getLogger(javaClass.enclosingClass)

        val PATH = Path.of("src/main/resources/sec02/")
    }
}
