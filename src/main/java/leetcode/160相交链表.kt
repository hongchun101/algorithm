package leetcode

import kotlin.math.abs

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    var nodeA = headA
    var nodeB = headB
    var diff = 0
    while ((nodeA ?: return null).next != null) {
        nodeA = nodeA.next
        diff++
    }

    while ((nodeB ?: return null).next != null) {
        nodeB = nodeB.next
        diff--
    }
    if (nodeA !== nodeB) {
        return null
    }
    if (diff > 0) {
        nodeA = headA
        nodeB = headB
    } else {
        nodeB = headA
        nodeA = headB
    }

    for (i in 0 until abs(diff)) {
        nodeA = nodeA?.next
    }

    while (nodeA !== nodeB) {
        nodeA = nodeA?.next
        nodeB = nodeB?.next
    }
    return nodeA
}
