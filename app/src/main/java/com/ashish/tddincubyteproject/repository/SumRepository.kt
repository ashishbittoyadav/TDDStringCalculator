package com.ashish.tddincubyteproject.repository

class SumRepository {
    fun add(arguments: String): Int {
        if (arguments.isBlank()) return 0
        val numbers = extractNumbers(arguments,)

        validateNegatives(numbers)

        return numbers.sum()
    }

    private fun extractNumbers(input: String): List<Int> {

        return input
            .split(',')
            .mapNotNull { it.toIntOrNull() }
    }

    private fun validateNegatives(numbers: List<Int>) {
        val negatives = numbers.filter { it < 0 }
        if (negatives.isNotEmpty()) {
            throw NumberFormatException(
                "negative numbers not allowed ${negatives.joinToString(",")}"
            )
        }
    }

}
