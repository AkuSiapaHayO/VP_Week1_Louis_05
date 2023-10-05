package com.example.visualprog

import java.lang.NumberFormatException
import java.util.*

class Spotify {

}

fun main(args: Array<String>) {
    music()
}

data class Songs(val title: String, val singer: String, val genre: String, val releaseYear: Int) {

}

fun music() {
    val listSongs = mutableListOf<Songs>()
    val queueSongs = LinkedList<Songs>()

    var nowPlaying: Songs? = null

    while (true) {
        println("==================")
        println("Welcome to Spotify")
        println("==================")
        println()
        if (nowPlaying != null) {
            println("==== Playing ${nowPlaying.title} by ${nowPlaying.singer} ====")
        } else if (queueSongs.isNotEmpty()){
            nowPlaying = queueSongs.poll()
            println("==== Playing ${nowPlaying.title} by ${nowPlaying.singer} ====")
        } else {
            println("No Song Played Right Now")
        }
        println()
        println("1. Check Song List")
        println("2. Add Song List")
        println("3. Check Queue")
        println("4. Skip Song Played")
        println("0. Exit")
        print("Pilih : ")

        when (readln()) {
            "1" -> {

                println()
                println("===================")
                println("==== SONG LIST ====")
                println("===================")

                for ((i, song) in listSongs.withIndex()) {
                    println("${i+1}. ${song.title} - ${song.singer} - ${song.genre} - ${song.releaseYear}")
                }

                println("Please select any song or press 0 to go back")
                val pilihSong = readln()
                println()

                if (pilihSong == "0") {
                    continue
                }

                val pilihSongIndex = pilihSong.toIntOrNull()

                if (pilihSongIndex != null && pilihSongIndex >= 0 && pilihSongIndex <= listSongs.size) {
                    val songSelected = listSongs[pilihSongIndex - 1]
                    println("You are selecting ${songSelected.title}")
                    println("1. Play Now")
                    println("2. Add to Queue")
                    println("3. Back")
                    print("Pilih : ")

                    when (readln()) {
                        "1" -> {
                            nowPlaying = songSelected
                        }

                        "2" -> {
                            queueSongs.offer(songSelected)
                            println("${songSelected.title} - ${songSelected.singer} Added to Queue")
                        }

                        "3" -> {
                            continue
                        }

                        else -> {
                            println("Invalid Option. Going back to main menu")
                        }
                    }

                } else {
                    println("Invalid Song Number. Going back to main menu")
                }

                println()
            }

            "2" -> {

                println()
                println("Title of the song:")
                val title = readln()
                println("Singer of the song:")
                val singer = readln()
                println("Genre of the song:")
                val genre = readln()
                var releaseYear = 0
                while (releaseYear <= 0) {
                    try {
                        println("Year of the song:")
                        releaseYear = readln().toInt()
                        if (releaseYear <= 0) {
                            println("Invalid Year")
                        }
                    } catch (e: NumberFormatException) {
                        println("Invalid Year Format")
                    }
                }

                val song = Songs(title, singer, genre, releaseYear)
                listSongs.add(song)
                println("Song Added Successfully!")
                println()

            }

            "3" -> {

                println()

                println("====================")
                println("==== Song Queue ====")
                println("====================")
                for ((i, song) in queueSongs.withIndex()) {
                    println("${i+1}. ${song.title} - ${song.singer} - ${song.genre} - ${song.releaseYear}")
                }

                println()

            }

            "4" -> {

                println()

                if (nowPlaying != null) {
                    val skippedSong = nowPlaying
                    println("${skippedSong.title} is Skipped!!")
                    nowPlaying = null
                } else {
                    println("No song is played. Please add a song to the queue first!")
                }

                println()

            }

            "0" -> {
                println()
                println("Exiting Program. Thank you!!!")
                println()
                return
            }

            else -> {
                println()
                println("Invalid menu option!")
                println()
            }
        }
    }
}