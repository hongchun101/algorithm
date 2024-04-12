package leetcode

fun main() {
    println(hammingDistance(1, 3))
}

fun hammingDistance(x: Int, y: Int): Int {
    var ans = x xor y
    var count = 0
    for (i in 0..31) {
        count += (ans and 1)
        ans = ans shr 1
    }
    return count
}
