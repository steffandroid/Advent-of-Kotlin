package uk.co.steffandroid.advent

import java.io.File
import java.util.*

class Day07 : Puzzle {
    val input = File("src/uk/co/steffandroid/advent/input/day07.input")
    val wires = input.readLines().map { line ->
        val pair = line.split(" -> ")
        Pair(pair[1], pair[0])
    }.toMap()

    var memo = HashMap<String, Int>()

    fun get(key: String): Int {
        return memo.getOrElse(key, {
            val result: Int
            if (key[0].isDigit()) {
                result = key.toInt()
            } else {
                val split = wires[key]!!.split(" ")
                result = when (split.count()) {
                    1 -> get(split[0])
                    2 -> get(split[1]).inv()
                    3 -> when (split[1]) {
                        "AND" -> get(split[0]) and get(split[2])
                        "OR" -> get(split[0]) or get(split[2])
                        "RSHIFT" -> get(split[0]) shr get(split[2])
                        "LSHIFT" -> get(split[0]) shl get(split[2])
                        else -> {
                            throw IllegalArgumentException("Incorrect gate")
                        }
                    }
                    else -> {
                        throw IllegalArgumentException("Incorrect gate")
                    }
                }
            }
            memo.putIfAbsent(key, result)
            result
        })
    }

    override fun part1(): String {
        return get("a").toString()
    }

    override fun part2(): String {
        val a = get("a")
        memo.clear()
        memo.put("b", a)
        return get("a").toString()
    }
}
