package com.example.visualprog

import kotlin.random.Random
import kotlin.math.sqrt

class numbers {
}

fun main(args:  Array<String>){
    testing()
}

fun testing(){
    val randomNumbers = List(50) { Random.nextInt(1, 101) }

    val evenCount = randomNumbers.count { it % 2 == 0 }
    val oddCount = randomNumbers.count { it % 2 != 0 }
    val primeCount = randomNumbers.count { isPrime(it) }

    println("50 angka random: $randomNumbers")
    println("Jumlah angka genap: $evenCount")
    println("Jumlah angka ganjil: $oddCount")
    println("Jumlah angka prima: $primeCount")
}

fun isPrime(number: Int): Boolean {
    if (number <= 1) return false
    if (number <= 3) return true
    if (number % 2 == 0 || number % 3 == 0) return false

    var i = 5
    while (i * i <= number) {
        if (number % i == 0 || number % (i + 2) == 0) return false
        i += 6
    }
    return true
}