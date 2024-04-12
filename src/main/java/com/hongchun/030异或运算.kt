package com.hongchun

fun main() {
    swap()
}

fun swap() {
    var a = 1
    var b = 2
    a = a xor b
    b = a xor b
    a = a xor b
    println(a)
    println(b)
}

fun max(a: Int, b: Int): Int {
    val c = a - b
    val ra = sign(c)
    val rb = flip(ra)
    return ra * a + rb * b
}

fun sign(a: Int) = flip(a shl 31)

fun flip(a: Int) = a xor 1

fun fun1(nums: IntArray): Int {
    var ans = 0
    nums.forEach { ans = ans xor it }
    return ans
}

fun fun2(nums: IntArray) {
    // a ^ b
    var xor1 = 0
    nums.forEach { xor1 = xor1 xor it }
    // 取出xor1最右侧的1
    val rightOne = xor1 and (-xor1)

    var xor2 = 0
    nums.forEach {
        if (it and rightOne == 0) {
            xor2 = xor2 xor it
        }
    }
    val a = xor1 xor xor2
    val b = xor2 xor a
    println("$a $b")
}

fun fun3(nums: IntArray, m: Int) {
    val cnts = IntArray(32) { 0 }
    nums.forEach {
        for (i in 0..31) {
            cnts[i] += (it shr i) and 1
        }
    }
    var ans = 0
    for (i in 0..31) {
        if (cnts[i] % m != 0) {
            ans = ans or (1 shl i)
        }
    }
    println(ans)
}
