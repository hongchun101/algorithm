package com.hongchun

fun add(a: Int, b: Int): Int {
    var ans = a
    var x = a
    var y = b
    while (y != 0) {
        // a b 无进位相加
        ans = x xor y
        // 进行信息
        y = (x and y) shl 1
        x = ans
    }
    return ans
}

fun minus(a: Int, b: Int): Int {
    return add(a, neg(b))
}

const val MIN = Int.MIN_VALUE
fun divide(a: Int, b: Int): Int {
    var x = a
    if (x == MIN && b == MIN) {
        // a和b都是整数最小
        return 1
    }
    if (x != MIN && b != MIN) {
        // a和b都不是整数最小，那么正常去除
        return div(x, b)
    }
    if (b == MIN) {
        // a不是整数最小，b是整数最小
        return 0
    }

    // a是整数最小，b是-1，返回整数最大，因为题目里明确这么说了
    if (b == neg(1)) {
        return Int.MAX_VALUE
    }

    // a是整数最小，b不是整数最小，b也不是-1
    x = add(x, if (b > 0) b else neg(b))
    val ans = div(x, b)
    val offset = if (b > 0) neg(1) else 1
    return add(ans, offset)
}

fun div(a: Int, b: Int): Int {
    var x = if (a < 0) neg(a) else a
    val y = if (b < 0) neg(b) else b
    var ans = 0
    var i = 30
    while (i >= 0) {
        if ((x shr i) >= y) {
            ans = ans or (1 shl i)
            x = minus(x, y shl i)
        }
        i = minus(i, 1)
    }
    return if ((a < 0) xor (b < 0)) neg(ans) else ans
}

fun multiply(a: Int, b: Int): Int {
    var x = a
    var y = b
    var ans = 0
    while (y != 0) {
        if ((y and 1) != 0) {
            ans = add(ans, x)
        }
        x = x shl 1
        y = y ushr 1
    }
    return ans
}

fun neg(a: Int): Int {
    return add(a.inv(), 1)
}
