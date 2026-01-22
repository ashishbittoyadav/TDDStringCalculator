package com.ashish.tddincubyteproject.repository

class SumRepository {
    fun add(arguments: String): Int {
        if (arguments.isBlank()) return 0
        val numbers = extractNumbers(arguments,)

        return numbers.sum()
    }

    private fun extractNumbers(input: String): List<Int> {

        return input
            .split(',')
            .mapNotNull { it.toIntOrNull() }
    }
}
