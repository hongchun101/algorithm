package com.hongchun

import kotlin.math.min

fun main() {
    val arrayOf = arrayOf(4, 5, 7, 1, 4, 6, 9, 2, 0)
    val mergeSort = mergeSort2(arrayOf)
    mergeSort.forEach { println(it) }
}

fun mergeSort(nums: Array<Int>): Array<Int> {
    val help = Array(nums.size) { 0 }

    fun merge(l: Int, m: Int, r: Int) {
        var i = l
        var a = l
        var b = m + 1

        while (a <= m && b <= r) {
            help[i++] = if (nums[a] <= nums[b]) nums[a++] else nums[b++]
        }

        while (a <= m) {
            help[i++] = nums[a++]
        }

        while (b <= r) {
            help[i++] = nums[b++]
        }

        for (j in l..r) {
            nums[j] = help[j]
        }

    }

    fun mergeSort1(l: Int, r: Int) {
        if (l == r) {
            return
        }
        val m = (l + r) / 2
        mergeSort1(l, m)
        mergeSort1(m + 1, r)
        merge(l, m, r)
    }

    mergeSort1(0, nums.size - 1)
    return nums
}

fun mergeSort2(nums: Array<Int>): Array<Int> {

    val help = Array(nums.size) { 0 }
    fun merge(l: Int, m: Int, r: Int) {
        var i = l
        var a = l
        var b = m + 1

        while (a <= m && b <= r) {
            help[i++] = if (nums[a] <= nums[b]) nums[a++] else nums[b++]
        }

        while (a <= m) {
            help[i++] = nums[a++]
        }

        while (b <= r) {
            help[i++] = nums[b++]
        }

        for (j in l..r) {
            nums[j] = help[j]
        }

    }
    // 初始步长为1
    val size = nums.size
    var step = 1
    while (step < size) {
        var l = 0
        while (l < size) {
            val m = l + step - 1
            // 如果没有右侧 直接break
            if (m + 1 >= size) {
                break
            }
            val r = min(l + (step shl 1) - 1, size - 1)
            merge(l, m, r)
            l = r + 1
        }
        step *= 2
    }
    return nums
}
