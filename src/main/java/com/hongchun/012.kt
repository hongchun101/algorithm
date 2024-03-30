package com.hongchun

import leetcode.ListNode

class `012` {
}

fun main() {
    val node1 = ListNode(1).apply {
        next = ListNode(5).apply {
            next = ListNode(3).apply {
                next = ListNode(9).apply {
                    next = null
                }
            }
        }
    }

    var divideLinkedList = divideLinkedList(node1, 4)
    while (divideLinkedList != null) {
        println(divideLinkedList.`val`)
        divideLinkedList = divideLinkedList.next
    }
}

fun divideLinkedList(head: ListNode, n: Int): ListNode? {
    if (head == null) {
        return null;
    }
    var h1: ListNode? = null
    var t1: ListNode? = null
    var h2: ListNode? = null
    var t2: ListNode? = null
    var next: ListNode? = head
    while (next != null) {
        if (next.`val` < n) {
            if (h1 == null) {
                h1 = next
            } else {
                t1!!.next = next
            }
            t1 = next
        } else {
            if (h2 == null) {
                h2 = next
            } else {
                t2!!.next = next
            }
            t2 = next
        }
        next = next.next
    }
    if (h1 == null || h2 == null) {
        return h1 ?: h2
    }
    t1!!.next = h2
    return h1
}
