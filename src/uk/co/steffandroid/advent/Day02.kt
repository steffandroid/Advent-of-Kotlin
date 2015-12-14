package uk.co.steffandroid.advent

import java.io.File

class Day02 : Puzzle {
    val input = File("src/uk/co/steffandroid/advent/input/day02.input")

    override fun part1(): String {
        return input.readLines().sumBy { parseLineToPresent(it).totalWrapping() }.toString()
    }

    override fun part2(): String {
        return input.readLines().sumBy { parseLineToPresent(it).totalRibbon() }.toString()
    }

    private fun parseLineToPresent(line: String): Present {
        val dimensions = line.split("x")
        return Present(dimensions[0].toInt(), dimensions[1].toInt(), dimensions[2].toInt())
    }

    class Present(private val length: Int, private val width: Int, private val height: Int) {
        val side1 = Side(length, width)
        val side2 = Side(width, height)
        val side3 = Side(height, length)

        fun totalWrapping(): Int = (2 * side1.area()) + (2 * side2.area()) + (2 * side3.area()) + smallestSide().area()

        fun totalRibbon(): Int = (length * width * height) + (2 * smallestSide().x) + (2 * smallestSide().y)

        private fun smallestSide(): Side {
            if (side1.area() <= side2.area() && side1.area() <= side3.area()) {
                return side1
            } else if (side2.area() <= side3.area()) {
                return side2
            } else {
                return side3
            }
        }

        class Side(val x: Int, val y: Int) {
            fun area(): Int = x * y
        }
    }
}
