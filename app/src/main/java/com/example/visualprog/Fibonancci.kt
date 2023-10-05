package com.example.visualprog

class Fibonancci {
}

fun main(args: Array<String>) {
    angka()
}

fun angka() {
    print("Masukkan Angka Pertama : ")
    val num1 = readln().toInt()
    print("Masukkan deret keberapa(n) : ")
    val num2 = readln().toInt()

    val result = fibonacci(num2, num1)


    println("Deret($num2) dengan angka pertama $num1 = $result")
}

fun fibonacci(n: Int, u1: Int): Int {
    if (n == 1 || n == 2) {
       return u1
    } else {
        return fibonacci(n - 1, u1) + fibonacci(n-2, u1)
    }
}