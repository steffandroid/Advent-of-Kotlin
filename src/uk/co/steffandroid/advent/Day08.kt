package uk.co.steffandroid.advent

import java.io.File
import kotlin.text.Regex

class Day08 : Puzzle {
    val input = File("src/uk/co/steffandroid/advent/input/day08.input")
    val totalChars = input.readLines().map { line -> line.length }.sum()
    val totalStringLength = input.readLines().map { line ->
        line.substring(1, line.length - 1)
                .replace("\\\\", "\\")
                .replace("\\\"", "\"")
                .replace(Regex("\\\\x[a-f0-9]{2}"), "x")
                .length
    }.sum()

    val totalEscapedStringLength = input.readLines().map { line ->
        line.replace("\\", "\\\\").replace("\"", "\\\"").length + 2
    }.sum()

    override fun part1(): String {
        return (totalChars - totalStringLength).toString()
    }

    override fun part2(): String {
        return (totalEscapedStringLength - totalChars).toString()
    }
}
