package leetcode

import java.util.PriorityQueue

fun main() {
    val nums = intArrayOf(3,8,20)
    println(halveArray(nums))
}

fun halveArray(nums: IntArray): Int {
    val heap = PriorityQueue<Double> { a, b -> b.compareTo(a) }
    var sum = 0L
    nums.forEach {
        heap.add(it.toDouble())
        sum += it
    }
    val half = (sum.toDouble() / 2)
    var calc = 0.0
    var count = 0
    while (half > calc) {
        val head = heap.poll()
        calc += (head / 2)
        heap.add(head / 2)
        count++
    }
    return count
}
