package com.example.filmein

/**
 * if This is true execute block, otherwise return null
 *
 * Used in
 * val value = isResult()
 * value ifTrue { code executed if value == true } ?: { code executed if value == false }
 */
fun <T>Boolean.ifTrue(block: () -> T): T? {
    return if (this) {
        block.invoke()
    } else {
        null
    }
}