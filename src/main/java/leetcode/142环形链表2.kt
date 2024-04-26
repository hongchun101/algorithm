package leetcode

fun detectCycle(head: ListNode?): ListNode? {
    if (head == null || head.next == null || head.next!!.next == null) {
        return null
    }
    var s = head.next
    var f = head.next!!.next
    while (s != f) {
        s = s?.next
        f = f?.next?.next
        if (f == null) {
            return null
        }
    }
    f = head
    while (f != s) {
        f = f?.next
        s = s?.next
    }
    return f
}