package leetcode

fun singleNumber(nums: IntArray): Int {
    var ans = 0
    nums.forEach { ans = ans xor it }
    return ans
}
