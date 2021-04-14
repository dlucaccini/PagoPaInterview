import exceptions.ArrayTooBigException
import exceptions.WrongArrayTypeException
import java.lang.Exception
import kotlin.jvm.Throws

class SecondExercise {

    @Throws(WrongArrayTypeException::class, ArrayTooBigException::class)
    fun flatten(array : Array<Any>) : IntArray {
        try {
            return flattenArray(array)
        }catch (wate : WrongArrayTypeException) {
            throw WrongArrayTypeException()
        }catch (soe : StackOverflowError) {
            throw ArrayTooBigException()
        }catch (e : Exception) {
            throw Exception()
        }
    }

    private fun flattenArray(array : Array<Any>) : IntArray {

        if(array.isNotEmpty() && array[0] !is Int && array[0] !is Array<*>) throw WrongArrayTypeException()

        if(array.size == 0) return intArrayOf()
        if(array.size == 1 && array[0] is Array<*>) return flattenArray(array[0] as Array<Any>)
        if(array.size == 1 && array[0] is Int) return intArrayOf(array[0] as Int)

        var tempArray = intArrayOf()

        array.forEach { v->
            tempArray = if(v is Int) {
                append(tempArray,v)
            } else {
                appendAll(tempArray, flattenArray(v as Array<Any>) )
            }
        }

        return tempArray
    }


    private fun append(arr: IntArray, element: Int): IntArray = arr.toMutableList().apply { add(element) }.toIntArray()
    private fun appendAll(arr: IntArray, arr2: IntArray): IntArray = arr.toMutableList().apply { addAll(arr2.toMutableList())  }.toIntArray()

}
