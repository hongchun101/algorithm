package com.hongchun

import kotlin.math.pow

fun main() {
    val nums = intArrayOf(23,45,71,11,345,67,123,567,7,8)
    radixSort(nums, 3)
    nums.forEach {
        print("$it ")
    }
}

fun radixSort(nums: IntArray, bits: Int) {
    val help = IntArray(nums.size) { 0 }
    for (i in 0..<bits) {
        val cnts = IntArray(10) { 0 }
        val offset = 10.0.pow(i).toInt()
        nums.forEach {
            cnts[(it / offset) % 10]++
        }
        for (j in 1..<cnts.size) {
            cnts[j] = cnts[j - 1] + cnts[j]
        }

        for (j in nums.lastIndex downTo 0) {
            help[--cnts[(nums[j] / offset) % 10]] = nums[j]
        }

        help.withIndex().forEach {
            nums[it.index] = it.value
        }
    }
}
