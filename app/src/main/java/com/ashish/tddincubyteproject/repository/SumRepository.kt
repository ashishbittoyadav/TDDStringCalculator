package com.ashish.tddincubyteproject.repository

class SumRepository {
    fun add(arguments: String): Int {
        if (arguments.isBlank()) return 0
        val delimiter = extractDelimiter(arguments)
        val numbers = extractNumbers(arguments,delimiter)

        validateNegatives(numbers)

        return numbers.sum()
    }

    private fun extractNumbers(input: String,delimiter: Char): List<Int> {
        val sanitizedInput = input
            .removePrefix("//$delimiter")
            .replace("\n", delimiter.toString())


        return sanitizedInput
            .split(delimiter)
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

    fun extractDelimiter(input: String): Char {
        return if (input.startsWith("//")) {
            input[2]
        } else {
            ','
        }
    }

}
