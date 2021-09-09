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
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun timeConversion(s: String): String {
    
    if(isAM(s)) {
        return handleForAm(s)
    }
    
    return handleForPm(s)   
}

fun handleForAm(s: String): String {
    val times = stripAmPm(s).split(":")
    var hour = times[0].toInt()
    var hourString = ""
    if(hour == 12) {
        hour = 0
    }
    if (hour in 0..9) { // needs testing
        hourString = "0$hour"
    } else {
        hourString = "$hour"
    }
    
    return hourString + ":" + times[1] + ":" + times[2]
}

fun handleForPm(s: String): String {
    val times = stripAmPm(s).split(":")
    var hour = times[0].toInt()
    var hourString = ""
    if(hour != 12) {
        hour += 12
    }
    if (hour in 0..9) { // needs testing
        hourString = "0$hour"
    } else {
        hourString = "$hour"
    }
    
    return hourString + ":" + times[1] + ":" + times[2]
}

fun stripAmPm(s: String): String {
    return s.substring(0, s.length - 2)
}

fun isAM(s: String): Boolean {
    return s.contains("AM")
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
