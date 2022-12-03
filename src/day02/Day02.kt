package day02

import readInput
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
            when {
                strategy.startsWith("A") && strategy.endsWith("X") -> score += 3u

                strategy.startsWith("A") && strategy.endsWith("Y") -> score += 4u // this

                strategy.startsWith("A") && strategy.endsWith("Z") -> score += 8u

                strategy.startsWith("B") && strategy.endsWith("X") -> score += 1u // this

                strategy.startsWith("B") && strategy.endsWith("Y") -> score += 5u

                strategy.startsWith("B") && strategy.endsWith("Z") -> score += 9u

                strategy.startsWith("C") && strategy.endsWith("X") -> score += 2u

                strategy.startsWith("C") && strategy.endsWith("Y") -> score += 6u

                strategy.startsWith("C") && strategy.endsWith("Z") -> score += 7u

                else -> throw ParseException(
                    "There was an unknown strategy combination in the input list at line ${index + 1}", index
                )
            }
        }
        return score
    }

    println(part1(input))
    println(part2(input))
}