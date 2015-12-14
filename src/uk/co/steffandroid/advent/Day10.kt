package uk.co.steffandroid.advent

import kotlin.text.Regex

class Day10 : Puzzle {
    val input = "3113322113"

    fun describe(input: String): String {
        return Regex("(\\d)\\1*").findAll(input).joinToString(separator = "") { str ->
            str.value.length.toString().plus(str.value[0])
        }
    }

    override fun part1(): String {
        var result = input
        for (i in 1..40) {
            result = describe(result)
        }
        return result.length.toString()
    }

    override fun part2(): String {
        var result = input
        for (i in 1..50) {
            result = describe(result)
        }
        return result.length.toString()
    }
}
