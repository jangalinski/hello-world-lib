/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.github.jangalinski.dummy

import arrow.core.Either

class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }

    fun couldFail(fail: Boolean) : Either<String,Boolean> = Either.cond(
        fail,
        { true },
        { "we failed"}
    )
}