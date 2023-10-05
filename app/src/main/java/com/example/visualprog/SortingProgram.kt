package com.example.visualprog

import kotlin.system.exitProcess

class SortingProgram {
}

fun main (args: Array<String>){
    sorting()
}

fun sorting(){
    println("===============")
    println("Sorting Program")
    println("===============")
    print("Masukkan jumlah angka yang ingin diurutkan : ")
    val jumlahAngka = readln().toInt()
    val bilangan = IntArray(jumlahAngka)
    for (i in 0 until jumlahAngka){
        print("Masukkan angka ke-${i+1} : ")
        bilangan[i] = readln().toInt()
    }

    println("===============")
    println("1. Kecil -> Besar")
    println("2. Besar -> Kecil")
    print("Pilih jenis pengurutan : ")
    val pilihPengurutan = readln().toInt()
    when (pilihPengurutan) {
        1 -> {
            bilangan.sort()
            print("Urutan angka dari kecil ke besar : [")
            for (i in bilangan.indices) {
                if (i == bilangan.size - 1) {
                    print("${bilangan[i]}]")
                } else {
                    print("${bilangan[i]}, ")
                }
            }
            println()
            sorting()
        }

        2 -> {
            bilangan.sortDescending()
            print("Urutan angka dari besar ke kecil : [")
            for (i in bilangan.indices) {
                if (i == bilangan.size - 1) {
                    print("${bilangan[i]}]")
                } else {
                    print("${bilangan[i]}, ")
                }
            }
            println()
            sorting()
        }

        else -> {
            sorting()
        }

    }
}


