package com.hongchun

import kotlin.random.Random

fun main() {
    quickSort(arrayOf(1, 7, 6, 5, 4, 5, 5, 9, 3, 7, 10))
        .forEach {
            println(it)
        }
}

fun quickSort(arr: Array<Int>): Array<Int> {

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
        return Pair(a - 1, b + 1)
    }

    fun quick(l: Int, r: Int) {
        if (l >= r) {
            return
        }
        val i = arr[Random.nextInt(l, r)]
        val pair = partition(l, r, i)
        if (l < pair.first) {
            quick(l, pair.first)
        }
        if (r > pair.second) {
            quick(pair.second, r)
        }
    }

    quick(0, arr.size - 1)
    return arr
}
