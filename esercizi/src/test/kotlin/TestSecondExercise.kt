import exceptions.WrongArrayTypeException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

class TestSecondExercise {

    @Test
    fun testNoNestingCases () {
        val t1 : Array<Any> = arrayOf(1)
        val expectedT1 = intArrayOf(1)
        val t2 : Array<Any> = arrayOf(1,2,3,4)
        val expectedT2 = intArrayOf(1,2,3,4)
        val t3 : Array<Any> = arrayOf(1,2,3,4,5,6,7,8,9,10,11)
        val expectedT3 = intArrayOf(1,2,3,4,5,6,7,8,9,10,11)
        val t4 : Array<Any> = arrayOf(4,3,2,1)
        val expectedT4 = intArrayOf(4,3,2,1)
        val t5 : Array<Any> = arrayOf(1,1,1,1,1,1,1,1,1)
        val expectedT5 = intArrayOf(1,1,1,1,1,1,1,1,1)

        assertAll(
            {assertTrue { expectedT1 contentEquals SecondExercise().flatten(t1) }},
            {assertTrue { expectedT2 contentEquals SecondExercise().flatten(t2) }},
            {assertTrue { expectedT3 contentEquals SecondExercise().flatten(t3) }},
            {assertTrue { expectedT4 contentEquals SecondExercise().flatten(t4) }},
            {assertTrue { expectedT5 contentEquals SecondExercise().flatten(t5) }}
        )
    }

    @Test
    fun testOneLevelNestingCases () {
        val expected = intArrayOf(1,2,3,4)
        val t1 : Array<Any> = arrayOf(arrayOf(1,2,3,4))
        val t2 : Array<Any> = arrayOf(1,2,3, arrayOf(4))
        val t3 : Array<Any> = arrayOf(1,2, arrayOf(3,4))
        val t4 : Array<Any> = arrayOf(arrayOf(1,2), 3,4)
        val t5 : Array<Any> = arrayOf(1,arrayOf(2,3),4)

        assertAll(
            {assertTrue { expected contentEquals SecondExercise().flatten(t1) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t2) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t3) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t4) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t5) }}
        )
    }

    @Test
    fun testMultipleNestingCases () {
        val expected = intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        val t1 : Array<Any> = arrayOf(1,2,3,4, arrayOf(5,6,7, arrayOf(8,9)),10,11,12, arrayOf(13, arrayOf(14)),15)
        val t2 : Array<Any> = arrayOf(arrayOf(arrayOf(arrayOf(arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)))))
        val t3 : Array<Any> = arrayOf(arrayOf(1,2,3,4,5,6,7,8,9), arrayOf(10, arrayOf(11, arrayOf(12, arrayOf(13),14,15))))
        val t4 : Array<Any> = arrayOf(arrayOf(arrayOf(arrayOf(arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14)),15)))
        val t5 : Array<Any> = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,arrayOf(arrayOf(arrayOf(arrayOf(arrayOf(15))))))

        assertAll(
            {assertTrue { expected contentEquals SecondExercise().flatten(t1) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t2) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t3) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t4) }},
            {assertTrue { expected contentEquals SecondExercise().flatten(t5) }}
        )
    }

    @Test
    fun testExceptions () {

        val t1 : Array<Any> = arrayOf()
        val t2 : Array<Any> = arrayOf("a","b","c")
        val t3 : Array<Any> = arrayOf(true,false)
        val t4 : Array<Any> = arrayOf(1,2, arrayOf('c'))

        assertAll(
            { assertTrue { SecondExercise().flatten(t1).isEmpty() } },
            { assertThrows<WrongArrayTypeException> {SecondExercise().flatten(t2) } },
            { assertThrows<WrongArrayTypeException> {SecondExercise().flatten(t3) } },
            { assertThrows<WrongArrayTypeException> {SecondExercise().flatten(t4) } }
        )
    }

}