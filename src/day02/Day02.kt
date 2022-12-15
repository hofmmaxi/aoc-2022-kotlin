package day02

import utils.println
import utils.readInput
import java.text.ParseException

fun main() {
    /**
     * A = Rock => 1
     * B = Paper => 2
     * C = Scissors => 3
     *
     * X = lose => 0
     * Y = draw => 3
     * Z = win => 6
     */

    val input = readInput("day02/input")

    fun part1(input: List<String>): UInt {


        var score: UInt = 0u
        for ((index, strategy) in input.withIndex()) {
            score += when (strategy.uppercase()) {
                "A X" -> 4u
                "A Y" -> 8u
                "A Z" -> 3u
                "B X" -> 1u
                "B Y" -> 5u
                "B Z" -> 9u
                "C X" -> 7u
                "C Y" -> 2u
                "C Z" -> 6u
                else -> throw ParseException(
                    "There was an unknown strategy combination in the input list at line ${index + 1}", index
                )
            }
        }
        return score
    }

    fun part2(input: List<String>): UInt {
        var score: UInt = 0u
        for ((index, strategy) in input.withIndex()) {
            /**
             * TODO("This can probably be improved")
             */
            score += when (strategy) {
                "A X" -> 3u
                "A Y" -> 4u
                "A Z" -> 8u
                "B X" -> 1u
                "B Y" -> 5u
                "B Z" -> 9u
                "C X" -> 2u
                "C Y" -> 6u
                "C Z" -> 7u
                else -> throw ParseException(
                    "There was an unknown strategy combination in the input list at line ${index + 1}", index
                )
            }
        }
        return score
    }


    check(part1(input) == 13009u)
    check(part2(input) == 10398u)
    part1(input).println()
    part2(input).println()
}