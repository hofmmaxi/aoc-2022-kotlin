package day03

import utils.println
import utils.readInput

fun main() {

    val input = readInput("day03/input")

    fun part1(input: List<String>): Int {
        return input.map {
            /**
             * Split the string in half
             */
            val halfSize = it.length / 2
            val compartment1 = it.subSequence(0, halfSize)
            val compartment2 = it.subSequence(halfSize, it.length)

            /**
             * Check if those parts share a character
             */
            compartment1.toSet().intersect(compartment2.toSet()).first()
        }.sumOf {
            /**
             * Get the Char code of each char and add it to the sum
             */
            it.code - if (it.isLowerCase()) 96 else 38
        }
    }

    /**
     * @see part1 The explanations are basically the same
     */
    fun part2(input: List<String>): Int {
        return input.chunked(3).map {
            val (firstElf, secondElf, thirdElf) = it


            firstElf.toSet().intersect(secondElf.toSet()).intersect(thirdElf.toSet()).first()
        }.sumOf {
            it.code - if (it.isLowerCase()) 96 else 38
        }
    }

    check(part1(input) == 7581)
    check(part2(input) == 2525)
    part1(input).println()
    part2(input).println()
}