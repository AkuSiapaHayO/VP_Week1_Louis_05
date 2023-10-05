package com.example.visualprog

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    menu()
}

fun menu(){
    println("KALKULATOR SEDERHANA")
    println("====================")
    println("1. Penjumlahan")
    println("2. Pengurangan")
    println("3. Perkalian")
    println("4. Pembagian")
    println("====================")
    println("0. Keluar")
    print("Pilih : ")
    val pilih = readln().toInt()

    when (pilih) {
        0 -> {
            println("Sampai Jumpa")
            exitProcess(0)
        }

        1 -> {
            print("Masukkan bilangan pertama : ")
            val bilangan1 = readln().toInt()
            print("Masukkan bilangan kedua : ")
            val bilangan2 = readln().toInt()
            println("====================")
            val hasil = bilangan1 + bilangan2
            println("Hasil : $hasil")
            menu()
        }

        2 -> {
            print("Masukkan bilangan pertama : ")
            val bilangan1 = readln().toInt()
            print("Masukkan bilangan kedua : ")
            val bilangan2 = readln().toInt()
            println("====================")
            val hasil = bilangan1 - bilangan2
            println(hasil)
            menu()
        }

        3 -> {
            print("Masukkan bilangan pertama : ")
            val bilangan1 = readln().toInt()
            print("Masukkan bilangan kedua : ")
            val bilangan2 = readln().toInt()
            println("====================")
            val hasil = bilangan1 * bilangan2
            println(hasil)
            menu()
        }

        4 -> {
            print("Masukkan bilangan pertama : ")
            val bilangan1 = readln().toInt()
            print("Masukkan bilangan kedua (tidak boleh angka '0') : ")
            val bilangan2 = readln().toInt()
            println("===============")
            if (bilangan2 == 0) {
                println("ERROR!")
                println("Pembagi tidak boleh bernilai '0'")
                menu()
            } else {
                val hasil = bilangan1 / bilangan2
                println(hasil)
            }
            menu()
        }



    }
}



class Test {
}