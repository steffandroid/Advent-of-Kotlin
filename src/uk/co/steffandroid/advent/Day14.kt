package uk.co.steffandroid.advent

import java.io.File
import kotlin.text.Regex

class Day14 : Puzzle {
    val input = File("src/uk/co/steffandroid/advent/input/day14.input")

    override fun part1(): String {
        return input.readLines()
                .map { line ->
                    val nums = Regex("\\d+").findAll(line).map { it.value.toInt() }.toList()
                    Reindeer(nums[0], nums[1], nums[2]).distance(2503)
                }.max().toString()
    }

    override fun part2(): String {
        val reindeer = input.readLines()
                .map { line ->
                    val nums = Regex("\\d+").findAll(line).map { it.value.toInt() }.toList()
                    Reindeer(nums[0], nums[1], nums[2])
                }
        for (i in 1..2503) {
            val winning = reindeer.sortedByDescending { it.distance(i) }[0]
            reindeer.filter { it.distance(i).equals(winning.distance(i)) }
                    .forEach { it.points++ }
        }
        return reindeer.maxBy { it.points }!!.points.toString()
    }

    class Reindeer(val speed: Int, val flight: Int, val rest: Int) {
        var points: Int = 0

        fun distance(seconds: Int): Int {
            var distance = 0
            for (i in 0..seconds - 1) {
                if (i % (flight + rest) < flight) distance += speed
            }
            return distance
        }
    }
}
