package leetcode

fun main() {
    val nums = intArrayOf(3, 0, 1)
    println(missingNumber(nums))
}

fun missingNumber(nums: IntArray): Int {
    var ans = 0
    nums.withIndex().forEach {
        ans = ans xor it.index xor it.value
    }
    return ans xor nums.size
}
