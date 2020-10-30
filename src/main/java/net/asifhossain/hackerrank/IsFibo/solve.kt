package net.asifhossain.hackerrank.IsFibo

import java.util.*

// Complete the solve function below.
fun solve(n: Long): String {

    var a1 = 1L
    var a2 = 1L
    var c = 1L

    while(c <= n) {
        if (c == n) 
          return "IsFibo"
        
        a1 = a2
        a2 = c

        c = a1 + a2
    }

    return "IsNotFibo"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()


    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toLong()

        val result = solve(n)

        println(result)
    }
}
