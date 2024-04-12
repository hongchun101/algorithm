package com.hongchun

import kotlin.random.Random

fun main() {

    val set = ArrayList<Int>()
    val size = 100000
    val bit = BitSet(size)
    for (i in 0..<size) {
        val nextDouble = Random.nextDouble(0.0, 1.0)
        if (nextDouble <= 0.333) {
            bit.add(i)
            set.add(i)
        } else if (nextDouble <= 0.666) {
            bit.remove(i)
            set.remove(i)
        } else {
            bit.reverse(i)
            if (i in set) {
                set.remove(i)
            } else {
                set.add(i)
            }
        }
    }

    for (i in 0..size) {
        if (i in bit != i in set) {
            println("error")
        }
    }

}

class BitSet(size: Int) {

    var arr = IntArray((size + 31) / 32) { 0 }

    fun add(n: Int) {
        arr[n / 32] = arr[n / 32] or (1 shl (n % 32))
    }

    fun remove(n: Int) {
        arr[n / 32] = arr[n / 32] and (1 shl (n % 32)).inv()
    }

    fun reverse(n: Int) {
        arr[n / 32] = arr[n / 32] xor (1 shl (n % 32))
    }

    operator fun contains(n: Int): Boolean {
        return (arr[n / 32] shr (n % 32) and 1) == 1
    }
}
