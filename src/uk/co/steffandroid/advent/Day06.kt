package uk.co.steffandroid.advent

import java.io.File
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class Day06 : Puzzle {
    val input: File = File("src/uk/co/steffandroid/advent/input/day06.input")
    var lights: MutableMap<Pair<Int, Int>, Boolean> = HashMap();
    var secondLights: MutableMap<Pair<Int, Int>, Int> = HashMap();

    override fun part1(): String {
        input.forEachLine { line ->
            val matcher: Matcher = Pattern.compile("(\\d)\\w*").matcher(line)
            var coordinates: MutableList<String> = ArrayList()
            while (matcher.find()) {
                coordinates.add(matcher.group())
            }
            val start: Pair<Int, Int> = Pair(coordinates[0].toInt(), coordinates[1].toInt())
            val end: Pair<Int, Int> = Pair(coordinates[2].toInt(), coordinates[3].toInt())
            if (line.startsWith("turn on")) {
                for (i in start.first..end.first) {
                    for (j in start.second..end.second) {
                        lights.put(Pair(i, j), true)
                    }
                }
            } else if (line.startsWith("turn off")) {
                for (i in start.first..end.first) {
                    for (j in start.second..end.second) {
                        lights.put(Pair(i, j), false)
                    }
                }
            } else if (line.startsWith("toggle")) {
                for (i in start.first..end.first) {
                    for (j in start.second..end.second) {
                        val isOn: Boolean = lights[Pair(i, j)] ?: false
                        lights.put(Pair(i, j), !isOn)
                    }
                }
            }
        }
        return lights.filter { light -> light.value == true }.count().toString()
    }

    override fun part2(): String {
        input.forEachLine { line ->
            val matcher: Matcher = Pattern.compile("(\\d)\\w*").matcher(line)
            var coordinates: MutableList<String> = ArrayList()
            while (matcher.find()) {
                coordinates.add(matcher.group())
            }
            val start: Pair<Int, Int> = Pair(coordinates[0].toInt(), coordinates[1].toInt())
            val end: Pair<Int, Int> = Pair(coordinates[2].toInt(), coordinates[3].toInt())
            if (line.startsWith("turn on")) {
                for (i in start.first..end.first) {
                    for (j in start.second..end.second) {
                        val currentValue: Int = secondLights[Pair(i, j)] ?: 0
                        secondLights.put(Pair(i, j), currentValue + 1)
                    }
                }
            } else if (line.startsWith("turn off")) {
                for (i in start.first..end.first) {
                    for (j in start.second..end.second) {
                        val currentValue: Int = secondLights[Pair(i, j)] ?: 0
                        if (currentValue > 0) {
                            secondLights.put(Pair(i, j), currentValue - 1)
                        }
                    }
                }
            } else if (line.startsWith("toggle")) {
                for (i in start.first..end.first) {
                    for (j in start.second..end.second) {
                        val currentValue: Int = secondLights[Pair(i, j)] ?: 0
                        secondLights.put(Pair(i, j), currentValue + 2)
                    }
                }
            }
        }
        return secondLights.map { light -> light.value }.sum().toString()
    }
}
