package com.hongchun

import kotlin.math.min

fun main() {
    val arrayOf = arrayOf(1, 6, 5, 6, 9, 10, 7)
    println(peakValue(arrayOf))
}

fun exist(arr: Array<Int>, num: Int): Boolean {
    if (arr.isEmpty()) return false
    var l = 0
    var r = arr.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (arr[mid] == num) {
            return true
        } else if (arr[mid] > num) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    return false
}

fun existGe(arr: Array<Int>, num: Int): Int {
    var ans = -1
    var l = 0
    var r = arr.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
//        val mid1 = l + ((r - l) shl 1)
        if (arr[mid] >= num) {
            ans = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    return ans
}

fun existLe(arr: Array<Int>, num: Int): Int {
    var ans = -1
    var l = 0
    var r = arr.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
//        val mid1 = l + ((r - l) shl 1)
        if (arr[mid] <= num) {
            ans = mid
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return ans
}

// 相邻元素互不相同的列表 找出任意一个峰值点
fun peakValue(arr: Array<Int>): Int {
    if (arr.size == 1) return 0

    if (arr[0] > arr[1]) return 1

    if (arr[arr.size - 1] > arr[arr.size - 2]) return arr.size - 1

    var l = 1
    var r = arr.size - 2

    var ans = -1
    while (l <= r) {
        val mid = (l + r) / 2
        if (arr[mid - 1] > arr[mid]) {
            r = mid - 1
        } else if (arr[mid + 1] > arr[mid]) {
            l = mid + 1
        } else {
            ans = mid
            break
        }
    }
    return ans
}







