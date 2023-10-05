package com.example.visualprog

import java.lang.Exception
import java.lang.NumberFormatException

class Library {

}

fun main() {
    perpus()
}

fun perpus() {

    val perpustakaan = Perpustakaan()

    perpustakaan.tambahkanBuku(

            namaBuku = "Bulan",
            penulis = "Tere Liye",
            kategori = "Fiksi",
        )

    perpustakaan.pinjamBuku(judulBuku = "Bulan", namaPeminjam = "Rudi")
    perpustakaan.pinjamBuku(judulBuku = "Bulan", namaPeminjam = "Amel")

    perpustakaan.tambahkanBuku(

            namaBuku = "Matahari",
            penulis = "Tere Liye",
            kategori = "Petualangan",

        )

    perpustakaan.pinjamBuku(judulBuku = "Matahari", namaPeminjam = "Cici")
    perpustakaan.pinjamBuku(judulBuku = "Matahari", namaPeminjam = "Nael")
    perpustakaan.pinjamBuku(judulBuku = "Matahari", namaPeminjam = "Putri")

    perpustakaan.tambahkanBuku(

            namaBuku = "Atomic Habits",
            penulis = "James Clear",
            kategori = "Self Improvement",

        )

    perpustakaan.pinjamBuku(judulBuku = "Atomic Habits", namaPeminjam = "Putri")
    perpustakaan.pinjamBuku(judulBuku = "Atomic Habits", namaPeminjam = "Ari")

    perpustakaan.tambahkanBuku(

            namaBuku = "Dr. Slump 01",
            penulis = "Akira Toriyama",
            kategori = "Fiksi",

        )
    perpustakaan.pinjamBuku(judulBuku = "Dr. Slump 01", namaPeminjam = "Ari")
    perpustakaan.pinjamBuku(judulBuku = "Dr. Slump 01", namaPeminjam = "Cici")
    perpustakaan.pinjamBuku(judulBuku = "Dr. Slump 01", namaPeminjam = "Rudi")

    perpustakaan.tambahkanBuku(

            namaBuku = "Dr. Slump 04",
            penulis = "Akira Toriyama",
            kategori = "Fiksi",

        )

    perpustakaan.pinjamBuku(judulBuku = "Dr. Slump 04", namaPeminjam = "Nael")
    perpustakaan.pinjamBuku(judulBuku = "Dr. Slump 04", namaPeminjam = "Hana")

    var pilih = 100

    do {

        println("==================================")
        println("Program Administrasi Perpustakaan")
        println("==================================")
        println("Pilih Aktivitas")
        println("====================")
        println("1. Lihat Semua Buku")
        println("2. Tambah Buku")
        println("3. Cari Buku")
        println("4. Pinjam Buku")
        println()
        println("0. Keluar")
        println()


        try {
            print("Pilih : ")
            pilih = readLine()?.toInt() ?: 0
            println("====================")
            when (pilih) {

                0 -> {
                    // Keluar dari program
                    println("Terima kasih telah menggunakan program ini.")
                }

                1 -> {
                    println("Daftar Buku")
                    println("====================")
                    perpustakaan.tampilkanKoleksiBuku()
                    println("====================")
                    println()
                }

                2 -> {
                    print("Judul Buku : ")
                    val judulBuku = readln()
                    print("Penulis : ")
                    val penulis = readln()
                    print("Kategori : ")
                    val kategori = readln()
                    perpustakaan.tambahkanBuku(judulBuku, penulis, kategori)
                }

                3 -> {
                    println("1. Cari berdasarkan judul")
                    println("2. Cari berdasarkan penulis")
                    println("3. Cari berdasarkan kategori")
                    println("====================")
                    print("Pilih : ")

                    when (readln().toInt()) {

                        1 -> {
                            print("Masukkan kata kunci : ")
                            val kataKunciJudul = readln()
                            println("====================")
                            println("Daftar Buku")
                            println("====================")
                            val bukuDitemukan = perpustakaan.cariJudul(kataKunciJudul)
                            if (bukuDitemukan.isEmpty()) {
                                println("Buku dengan judul $kataKunciJudul tidak ditemukan")
                            } else {
                                for (buku in bukuDitemukan) {
                                    buku.tampilkanInfoBuku()
                                    println()
                                }
                            }
                        }

                        2 -> {
                            print("Masukkan kata kunci : ")
                            val kataKunciPenulis = readln()
                            println("====================")
                            println("Daftar Buku")
                            println("====================")
                            val bukuDitemukan = perpustakaan.cariPenulis(kataKunciPenulis)
                            if (bukuDitemukan.isEmpty()) {
                                println("Buku dengan penulis $kataKunciPenulis tidak ditemukan")
                            } else {
                                for (buku in bukuDitemukan) {
                                    buku.tampilkanInfoBuku()
                                    println()
                                }
                            }
                        }

                        3 -> {
                            print("Masukkan kata kunci : ")
                            val kataKunciKategori = readln()
                            println("====================")
                            println("Daftar Buku")
                            println("====================")
                            val bukuDitemukan = perpustakaan.cariKategori(kataKunciKategori)
                            if (bukuDitemukan.isEmpty()) {
                                println("Buku dengan kategori $kataKunciKategori tidak ditemukan")
                            } else {
                                for (buku in bukuDitemukan) {
                                    buku.tampilkanInfoBuku()
                                    println()
                                }
                            }

                        }
                    }
                }

                4 -> {
                    print("Masukkan namamu : ")
                    val peminjam = readln()
                    print("Judul buku yang ingin dipinjam : ")
                    val JudulBukuDipinjam = readln()
                    perpustakaan.pinjamBuku(JudulBukuDipinjam, peminjam)
                }

                else -> {
                    println("Pilihan tidak valid.")
                }
            }
        } catch (e: NumberFormatException) {
            println("Masukkan input yang valid")
        } catch (e: Exception) {
            println("Masukkan input yang valid")
        }


    } while (pilih != 0)
}

class Perpustakaan {

    private val koleksiBuku = mutableListOf<Buku>()
    private val peminjam = mutableListOf<String>()

    fun tambahkanBuku(namaBuku: String, penulis: String, kategori: String) {
        val buku = Buku(namaBuku, penulis, kategori)
        koleksiBuku.add(buku)
        println("Buku berjudul $namaBuku telah berhasil ditambahkan")
        println()
    }

    fun tampilkanKoleksiBuku() {


        if (koleksiBuku.isEmpty()) {
            println("Tidak ada buku di dalam perpustakaan")
        } else {
            for (buku in koleksiBuku) {
                buku.tampilkanInfoBuku()
            }
        }
    }

    fun pinjamBuku(judulBuku: String, namaPeminjam: String) {
        val bukuDitemukan = koleksiBuku.find { it.namaBuku.equals(judulBuku, ignoreCase = true) }

        if (bukuDitemukan != null) {
            if (peminjam.contains(namaPeminjam)) {
                println("$namaPeminjam tidak boleh meminjam buku ini, dia sedang meminjam buku lain")
            } else {
                bukuDitemukan.tambahkanPeminjam(namaPeminjam)
                tambahkanPeminjam(namaPeminjam)
                println("$namaPeminjam berhasil meminjam buku $judulBuku")
            }
        } else {
            println("Buku dengan judul $judulBuku tidak ditemukan.")
        }
    }

    private fun tambahkanPeminjam(Peminjam: String) {
        peminjam.add(Peminjam)
    }

    fun cariJudul(judul: String): List<Buku> {
        return koleksiBuku.filter { it.namaBuku.contains(judul, ignoreCase = true) }
    }

    fun cariPenulis (penulis: String): List<Buku> {
        return  koleksiBuku.filter { it.penulis.contains(penulis, ignoreCase = true) }
    }

    fun cariKategori (kategori: String): List<Buku> {
        return koleksiBuku.filter { it.kategori.contains(kategori, ignoreCase = true) }
    }
}

class Buku(var namaBuku: String, var penulis: String, var kategori: String) {

    private var peminjam: MutableList<String> = mutableListOf()

    private fun tampilkanPeminjam() {
        println("Peminjam   :")
        for (namaPeminjam in peminjam) {
            println("- $namaPeminjam")
        }
    }

    fun tambahkanPeminjam(namaPeminjam: String) {
        peminjam.add(namaPeminjam)
    }

    fun tampilkanInfoBuku() {
        println("Judul Buku : $namaBuku")
        println("Penulis    : $penulis")
        println("Kategori   : $kategori")
        tampilkanPeminjam()
        println("====================")
        println()
    }
}



