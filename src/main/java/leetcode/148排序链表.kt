package leetcode

import java.util.PriorityQueue

fun main() {
    var head = ListNode(4).apply {
        next = ListNode(2).apply {
            next = ListNode(1).apply {
                next = ListNode(3)
            }
        }
    }
    sortList(head)
}

fun sortList(head: ListNode?): ListNode? {
    if (head == null) return null
    val heap = PriorityQueue<Int>()
    val map = mutableMapOf<Int, MutableList<ListNode>>()
    var h = head
    while (h != null) {
        val list = map.getOrPut(h.`val`) {
            ArrayList()
        }
        list.add(h)
        heap.offer(h.`val`)
        h = h.next
    }

    val get = map[heap.poll()]!!

    var cur: ListNode? = null
    for (g in get) {
        if (h == null) {
            h = g
            cur = h
        } else {
            cur?.next = g
            cur = g
        }
    }
    while (!heap.isEmpty()) {
        val get = map[heap.poll()]!!
        for (g in get) {
            cur?.next = g
            cur = g
            g.next = null
        }
    }
    return h

}