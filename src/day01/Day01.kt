package day01

import readInput

@OptIn(ExperimentalUnsignedTypes::class)
fun main() {

    val input = readInput("day01/input")

    var sumArray: UIntArray = uintArrayOf()

    fun part1(input: List<String>): UInt {
        val calories = input.map { it.toUShortOrNull() }

        var sum: UInt = 0u


        /**
         * If the current value is a number, add it to the sum
         * Else push the sum to the sum array and reset the sum value to null
         */
        for (cal in calories)
            if (cal is UShort) {
                sum += cal
            } else {
                sumArray += sum
                sum = 0u
            }
        return sumArray.max()
    }

    fun part2(): UInt {
        val sortedCals = sumArray.sortedArrayDescending()
        return sortedCals[0] + sortedCals[1] + sortedCals[2]
    }

    println(part1(input))
    println(part2())
}
