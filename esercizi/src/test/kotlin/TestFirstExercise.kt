import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class TestFirstExercise {

    @Test
    fun testZeroOccurrences () {

        val expected = 0
        val t1 = arrayListOf("abc","a","cba", "abcdefghilmnopqrstuvz")
        val t2 = arrayListOf("")
        val t3 = arrayListOf("a","b","c", "d")
        val t4 = arrayListOf("123","456","78", "90")

        assertAll(
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t1)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t2)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t3)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t4)) }
        )
    }

    @Test
    fun testOneOccurrences () {

        val expected = 1
        val t1 = arrayListOf("aa")
        val t2 = arrayListOf("cc","","","")
        val t3 = arrayListOf("","cc","","")
        val t4 = arrayListOf("","","","cc")
        val t5 = arrayListOf("aabbcc")
        val t6 = arrayListOf("a","b","cc")

        assertAll(
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t1)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t2)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t3)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t4)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t5)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t6)) }
        )
    }

    @Test
    fun testTwoOccurrences () {

        val expected = 2
        val t1 = arrayListOf("aa","bb")
        val t2 = arrayListOf("aa","","","bb")
        val t3 = arrayListOf("","bb","aa","")
        val t4 = arrayListOf("cc","","","cccc")
        val t5 = arrayListOf("aabbcc","d","e","faaaaf")
        val t6 = arrayListOf("11","12345","212")

        assertAll(
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t1)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t2)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t3)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t4)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t5)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t6)) }
        )
    }

    @Test
    fun testThreeOccurrences () {

        val expected = 3
        val t1 = arrayListOf("aa","bb","cc")
        val t2 = arrayListOf("1abcdefghilm1","2abcdefghilm2","","a1234567890a")
        val t3 = arrayListOf("","","","11","22","33")
        val t4 = arrayListOf("1a1","1b1","1c1","1c2")
        val t5 = arrayListOf("11","22","33","456")
        val t6 = arrayListOf("--","--","-.-")

        assertAll(
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t1)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t2)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t3)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t4)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t5)) },
            { assertEquals(expected, FirstExercise().getNumberOfOccurrences(t6)) }
        )
    }

}