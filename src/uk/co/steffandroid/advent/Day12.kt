package uk.co.steffandroid.advent

import java.io.File
import kotlin.text.Regex

class Day12 : Puzzle {
    val input = File("src/uk/co/steffandroid/advent/input/day12.input")

    override fun part1(): String {
        return Regex("-?\\d+").findAll(input.readText()).sumBy { it.value.toInt() }.toString()
    }

    override fun part2(): String {
        val filtered = Regex("\\{[^\\{]*:\"red\"[^\\}]*\\}").replace(input.readText(), "")
        return Regex("-?\\d+").findAll(filtered).sumBy { it.value.toInt() }.toString()
    }
}
