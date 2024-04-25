package leetcode

fun main() {
    var head = ListNode(1).apply {
        next = ListNode(2).apply {
        }
    }
    removeNthFromEnd(head, 2)
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var tem = ListNode(0).apply { next = head }
    var f: ListNode? = tem
    var s: ListNode? = tem
    for (i in 0..<n) {
        f = f?.next
    }
    while (f?.next != null) {
        f = f.next
        s = s?.next
    }

    val next = s?.next
    if (next == head) {
        return head?.next
    }
    s?.next = next?.next
    next?.next = null
    return head
}
