package com.hongchun

fun main() {
    //val arrayOf = arrayOf(7, 7, 6, 2, 6, 5, 4, 9)
    val arr = arrayOf(7, 7, 6, 2, 6, 5, 4, 9)
    val merge = merge(arr)
    println(merge)
}

fun merge(nums: Array<Int>): Int {
    val size = nums.size

    val help = Array(size) { 0 }

    fun merge(l: Int, m: Int, r: Int): Int {
        var ans = 0
        for (j in m + 1..r) {
            var i = l
            var sum = 0
            while (i <= m && nums[i] <= nums[j]) {
                sum += nums[i++]
            }
            ans += sum
        }
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
        return ans
    }

    fun smallSum(l: Int, r: Int): Int {
        if (l == r) return 0
        val m = (l + r) / 2
        return smallSum(l, m) + smallSum(m + 1, r) + merge(l, m, r)
    }

    return smallSum(0, size - 1)
}
