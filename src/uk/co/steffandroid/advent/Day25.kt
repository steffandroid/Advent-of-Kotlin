package uk.co.steffandroid.advent

class Day25 : Puzzle {

    fun triangle(input: Int) = (input * (input + 1)) / 2

    fun position(row: Int, column: Int) = triangle(column + row - 1) - (row - 1)

    fun code(position: Int): Int {
        var code: Long = 20151125
        var count = 1
        while (count < position) {
            code = ((code * 252533) % 33554393)
            count++
        }
        return code.toInt()
    }

    override fun part1(): String {
        return code(position(3010, 3019)).toString()
    }

    override fun part2(): String {
        return "Not required"
    }
}
