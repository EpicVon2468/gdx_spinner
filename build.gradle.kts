@file:OptIn(ExperimentalKotlinGradlePluginApi::class)
@file:Suppress("UnstableApiUsage")
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
	alias(libs.plugins.kotlin.jvm)
}

group = "io.github.epicvon2468.gdx_spinner"
version = libs.versions.gdx.spinner.get()

repositories {
	mavenCentral()
}

dependencies {
	api(libs.gdx)
	implementation(libs.protobuf.java)
	implementation(libs.protobuf.kotlin)
	compileOnly(libs.jetBrains.annotations)
	testImplementation(libs.kotlin.test)
	testImplementation(libs.gdx.backends.lwjgl3)
	// Can't make this work in `libs.versions.toml`...
	testImplementation("com.badlogicgames.gdx:gdx-platform:${libs.versions.gdx.asProvider().get()}:natives-desktop")
}

kotlin {
	jvmToolchain {
		// No JetBrains Runtime for Java 8 :(
		vendor = JvmVendorSpec.ADOPTIUM
		languageVersion = JavaLanguageVersion.of(8)
	}
	kotlinDaemonJvmArgs = listOf("-XX:+UseCompactObjectHeaders", "--enable-native-access=ALL-UNNAMED")
}

tasks.test {
	useJUnitPlatform()
	environment("__GL_THREADED_OPTIMIZATIONS", 0)
}