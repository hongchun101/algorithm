package com.hongchun

import kotlin.random.Random

fun main() {
    val arrayOf = arrayOf(1, 7, 6, 5, 4, 5, 5, 9, 3, 7, 10)
    val random = random(arrayOf, 2)
    println(random)
}

fun random(arr: Array<Int>, index: Int): Int {

    fun swap(a: Int, i: Int) {
        val tmp = arr[a]
        arr[a] = arr[i]
        arr[i] = tmp
    }

    fun partition(l: Int, r: Int, x: Int): Pair<Int, Int> {
        var a = l
        var b = r
        var i = l
        while (i <= b) {
            if (arr[i] < x) {
                swap(a++, i++)
            } else if (arr[i] > x) {
                swap(b--, i)
            } else {
                i++
            }
        }
        return Pair(a, b)
    }

    fun quick(l: Int, r: Int): Int {
        val random = arr[Random.nextInt(l, r)]
        val pair = partition(0, arr.size - 1, random)
        return if (index in pair.first..pair.second) {
            random
        } else if (index < pair.first) {
            quick(l, pair.first)
        } else {
            quick(pair.second, r)
        }
    }

    return quick(0, arr.size - 1)
}
