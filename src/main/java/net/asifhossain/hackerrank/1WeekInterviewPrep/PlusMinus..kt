import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    var countPositive = 0F
    var countNegative = 0F
    var countZero = 0F
    
    for (number in arr) {
        if (number < 0) {
            countNegative++
        } else if (number > 0) {
            countPositive++
        } else {
            countZero++
        }
    }
    
    println("%.6f".format(countPositive/arr.size))
    println("%.6f".format(countNegative/arr.size))
    println("%.6f".format(countZero/arr.size))

}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}
