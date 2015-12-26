package uk.co.steffandroid.advent

import java.util.*

class Day20 : Puzzle {
    val input = 29000000

    fun primeFactorSum(house: Int) : Int {
        var factors = HashSet<Int>()
        for (i in 2..house) {
            if (house % i == 0) {
                factors.add(i)
                if (i != house / i) {
                    factors.add(house / i)
                }
            }
        }
        return factors.sum()
    }

    override fun part1(): String {
        var house = 0
        do {
            house++
            val presents = primeFactorSum(house) * 10
        } while (presents < input)
        return house.toString()
    }

    fun primeFactorSum2(house: Int) : Int {
        var factors = HashSet<Int>()
        for (i in 2..house) {
            if (house % i == 0 && i * 50 >= house) {
                factors.add(i)
                if (i != house / i) {
                    factors.add(house / i)
                }
            }
        }
        return factors.sum()
    }

    override fun part2(): String {
        var house = 0
        do {
            house++
            val presents = primeFactorSum2(house) * 11
        } while (presents < input)
        return house.toString()
    }
}
