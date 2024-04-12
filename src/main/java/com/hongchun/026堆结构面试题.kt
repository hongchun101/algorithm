package com.hongchun

import leetcode.ListNode
import java.util.*
import kotlin.math.max

fun main() {
    //val node1 = ListNode(1).apply {
    //    next = ListNode(3).apply {
    //        next = ListNode(5).apply {
    //            next = ListNode(9).apply {
    //                next = null
    //            }
    //        }
    //    }
    //}
    //val node2 = ListNode(1).apply {
    //    next = ListNode(2).apply {
    //        next = ListNode(8).apply {
    //            next = ListNode(9).apply {
    //                next = null
    //            }
    //        }
    //    }
    //}
    //
    //val node3 = ListNode(3).apply {
    //    next = ListNode(4).apply {
    //        next = ListNode(6).apply {
    //            next = ListNode(7).apply {
    //                next = null
    //            }
    //        }
    //    }
    //}
    //val heapLinkedList = heapLinkedList(arrayOf(node1, node2, node3))
    //var node = heapLinkedList
    //while (node != null) {
    //    println(node.`val`)
    //    node = node.next
    //}
    val line = maxCover(arrayOf(arrayOf(1, 3), arrayOf(2, 6), arrayOf(2, 10), arrayOf(1, 18), arrayOf(4, 9)))
    println(line)
}

//LCR 078. 合并 K 个升序链表
fun heapLinkedList(lists: Array<ListNode?>): ListNode? {
    val heap = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
    for (node in lists) {
        node?.apply { heap.add(this) }
    }
    if (heap.isEmpty()) {
        return null
    }

    // 获取头结点
    val h = heap.poll()
    var pre = h
    // 将头结点的next节点加入堆中
    val next = h.next
    next?.apply { heap.add(this) }

    while (!heap.isEmpty()) {
        val cur = heap.poll()
        pre.next = cur
        pre = cur
        cur.next?.apply { heap.add(this) }
    }
    return h
}

fun maxCover(lines: Array<Array<Int>>): Int {
    // 按照开始位置排序
    Arrays.sort(lines) { a, b -> a[0] - b[0] }
    val heap = PriorityQueue<Int> { a, b -> a - b }
    var max = 0
    for (i in lines.indices) {
        while (heap.isNotEmpty() && heap.peek() <= lines[i][0]) {
            heap.poll()
        }
        heap.offer(lines[i][1])
        max = max(max, heap.size)
    }
    return max
}
