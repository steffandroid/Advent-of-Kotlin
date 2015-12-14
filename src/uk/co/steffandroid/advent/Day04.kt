package uk.co.steffandroid.advent

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils

class Day04 : Puzzle {
    val input: String = "yzbqklnj"
    var count: Int = -1

    override fun part1(): String {
        return lowestNumber("00000")
    }

    override fun part2(): String {
        return lowestNumber("000000")
    }

    fun lowestNumber(startWith: String): String {
        do {
            count++
            val hash = String(Hex.encodeHex(DigestUtils.md5(input + count)))
        } while (!hash.startsWith(startWith))
        return count.toString()
    }
}
