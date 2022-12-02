package day01

import readInput

@OptIn(ExperimentalUnsignedTypes::class)
fun main() {

    /**
     * This is the first part
     */
    val input = readInput("day01/input")

    val calories = input.map { it.toUShortOrNull() }

    var sum: UInt = 0u
    var sumArray: UIntArray = uintArrayOf()

    /**
     * If the current value is a number, add it to the sum
     * Else push the sum to the sum array and reset the sum value to null
     */
    for (cal in calories) {
        if (cal is UShort) {
            sum += cal
        } else {
            sumArray += sum
            sum = 0u
        }
    }
    println(sumArray.max())


    /**
     * And this is the second part
     */
    val sortedCals = sumArray.sorted().reversed()
    val topCalsSum = sortedCals[0] + sortedCals[1] + sortedCals[2]
    println(topCalsSum)
}
