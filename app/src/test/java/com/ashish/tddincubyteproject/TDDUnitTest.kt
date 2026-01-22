package com.ashish.tddincubyteproject

import com.ashish.tddincubyteproject.repository.SumRepository
import org.junit.Before
import org.junit.Test

class TDDUnitTest {

    lateinit var sumRepository: SumRepository

    @Before
    fun set_up_repository(){
        sumRepository = SumRepository()
    }


    @Test
    fun verify_add_of_number_separated_by_comma_work_fine(){
        val result = sumRepository.add("1,2")
        assert(result == 3)
    }
}