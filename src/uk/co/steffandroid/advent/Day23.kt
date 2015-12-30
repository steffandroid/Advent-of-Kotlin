package uk.co.steffandroid.advent

import java.io.File

class Day23 : Puzzle {
    val instructions = File("src/uk/co/steffandroid/advent/input/day23.input").readLines()
    
    var a = 0
    var b = 0

    fun execute(position: Int, instruction: String): Int {
        when {
            instruction.startsWith("inc") ->
                when (instruction[4]) {
                    'a' -> a++
                    'b' -> b++
                }
            instruction.startsWith("tpl") ->
                when (instruction[4]) {
                    'a' -> a *= 3
                    'b' -> b *= 3
                }
            instruction.startsWith("hlf") ->
                when (instruction[4]) {
                    'a' -> a /= 2
                    'b' -> b /= 2
                }
            instruction.startsWith("jmp") -> return position + instruction.substring(4, instruction.length).toInt()
            instruction.startsWith("jio") ->
                when (instruction[4]) {
                    'a' -> if (a == 1) return position + instruction.substring(7, instruction.length).toInt()
                    'b' -> if (b == 1) return position + instruction.substring(7, instruction.length).toInt()
                }
            instruction.startsWith("jie") ->
                when (instruction[4]) {
                    'a' -> if (a % 2 == 0) return position + instruction.substring(7, instruction.length).toInt()
                    'b' -> if (b % 2 == 0) return position + instruction.substring(7, instruction.length).toInt()
                }
        }
        return position + 1
    }

    override fun part1(): String {
        var position = 0
        do {
            position = execute(position, instructions[position])
        } while (position < instructions.size)
        return b.toString()
    }

    override fun part2(): String {
        a = 1
        b = 0
        var position = 0
        do {
            position = execute(position, instructions[position])
        } while (position < instructions.size)
        return b.toString()
    }
}
