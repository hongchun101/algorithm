package com.hongchun

fun reverse(head: Node<Int>?): Node<Int>? {
    var current = head
    var pre: Node<Int>? = null
    var next: Node<Int>?
    while (current != null) {
        next = current.next
        current.next = pre
        pre = current
        current = next
    }
    return pre;
}

class Node<T>(private var data: T) {
    var next: Node<T>? = null
}

class DoubleNode<T>(private var data: T) {
    var next: DoubleNode<T>? = null
    var prev: DoubleNode<T>? = null
}
