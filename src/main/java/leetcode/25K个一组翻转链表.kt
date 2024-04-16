package leetcode

fun main() {
    val apply = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    var reverseKGroup = reverseKGroup(apply, 2)
}

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null

    var start: ListNode = head
    var end = teamEnd(start, k)
    if (end == null) {
        return head
    }
    var h: ListNode? = end

    reverse(start, end)
    var lastTeamNode = start
    while (lastTeamNode.next != null) {
        start = (lastTeamNode.next ?: return null)
        end = teamEnd(start, k)
        if (end != null) {
            reverse(start, end)
            lastTeamNode.next = end
            lastTeamNode = start
        } else {
            break
        }
    }

    return h
}

fun reverse(start: ListNode, end: ListNode) {
    var e = end.next
    var cur: ListNode? = start
    var next = cur?.next
    while (cur != end) {
        val tmp = next?.next
        next?.next = cur
        cur = next
        next = tmp
    }
    start.next = e
}

fun teamEnd(head: ListNode, k: Int): ListNode? {
    var n = k
    var node: ListNode? = head
    while (--n != 0 && node != null) {
        node = node.next
    }
    return node
}
