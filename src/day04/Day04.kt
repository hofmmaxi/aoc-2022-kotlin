package day04

import utils.println
import utils.readInput

fun main() {

    val input = readInput("day04/input")

    /**
     * Put all assignment pairs into a list
     */
    val ranges = input.map { elves ->
        elves.split(",")
            .map { range ->
                val (a, b) = range.split("-").map { it.toInt() }
                a..b
            }
    }

    fun part1(): Int {
        /**
         * Calculate how many assignment pairs fully contain the other
         */
        return ranges.count { (assignment1, assignment2) ->
            (assignment1.first in assignment2 && assignment1.last in assignment2) || (assignment2.first in assignment1 && assignment2.last in assignment1)
        }
    }

    /**
     * Calculate how many ranges in the assignment pairs overlap
     */
    fun part2(): Int {
        return ranges.count { (assignment1, assignment2) ->
            assignment1.first in assignment2 || assignment1.last in assignment2 || assignment2.first in assignment1 || assignment2.last in assignment1
        }
    }

    check(part1() == 459)
    check(part2() == 779)
    part1().println()
    part2().println()
}