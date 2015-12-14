package uk.co.steffandroid.advent

import java.io.File
import kotlin.text.Regex

class Day05 : Puzzle {
    val input: File = File("src/uk/co/steffandroid/advent/input/day05.input")

    override fun part1(): String {
        return input.readLines().filter { Name(it).isNice1() }.size.toString()
    }

    override fun part2(): String {
        return input.readLines().filter { Name(it).isNice2() }.size.toString()
    }

    class Name(val name: String) {
        fun isNice1(): Boolean {
            return hasThreeVowels() && hasDoubleLetter() && hasNoBadStrings()
        }

        fun isNice2(): Boolean {
            return hasTwoPairs() && hasRepeatingLetterWithGap()
        }

        fun hasTwoPairs(): Boolean {
            return Regex("([a-z]{2}).*\\1").containsMatchIn(name)
        }

        fun hasRepeatingLetterWithGap(): Boolean {
            return Regex("([a-z]).(\\1)").containsMatchIn(name)
        }

        fun hasThreeVowels(): Boolean {
            return name.asSequence().filter { char -> char.isVowel() }.count() >= 3
        }

        fun Char.isVowel(): Boolean {
            return this.equals('a') || this.equals('e') || this.equals('i') || this.equals('o') || this.equals('u')
        }

        fun hasDoubleLetter(): Boolean {
            return Regex("(\\w)\\1+").containsMatchIn(name)
        }

        fun hasNoBadStrings(): Boolean {
            return !name.contains("ab") && !name.contains("cd") && !name.contains("pq") && !name.contains("xy")
        }
    }
}
