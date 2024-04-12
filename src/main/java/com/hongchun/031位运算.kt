package com.hongchun


fun fun1(l: Int, r: Int): Int {
    var p = r
    while (l < p) {
        p -= (p and (p).inv())
    }
    return p
}
