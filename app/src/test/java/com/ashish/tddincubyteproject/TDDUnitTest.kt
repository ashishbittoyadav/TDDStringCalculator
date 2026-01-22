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

    @Test
    fun validate_for_negative_number_in_the_string(){
        try {
            val result = sumRepository.add("1,-2,3")
            assert(result==4)
        }catch (e: Exception){
            assert(e.toString().contains("negative numbers not allowed"))
        }
    }
}