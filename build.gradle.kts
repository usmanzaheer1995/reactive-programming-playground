plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.usmanzaheer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.projectreactor:reactor-core:3.6.7")
    implementation("io.projectreactor.netty:reactor-netty-core:1.1.20")
    implementation("io.projectreactor.netty:reactor-netty-http:1.1.20")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.2.2")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0-M2")
    testImplementation("io.projectreactor:reactor-test:3.6.7")
    testImplementation(kotlin("test"))
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}