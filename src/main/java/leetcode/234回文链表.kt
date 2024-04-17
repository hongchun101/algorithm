package leetcode

fun main() {
    var head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(2).apply {
                    next = ListNode(1)
                }
            }
        }
    }
    isPalindrome(head)
}

fun isPalindrome(head: ListNode?): Boolean {

    if (head?.next == null) {
        return true
    }
    var h = head
    var s = head
    var f = head

    var e: ListNode?
    while (true) {
        val snext = s?.next
        val fnext = f?.next?.next
        if (fnext == null) {
            e = if (f?.next == null) f else f.next
            break
        }
        s = snext
        f = fnext
    }
    reverse(s)
    while (h != null && e != null) {
        if (h.`val` != e.`val`) {
            return false
        }
        h = h.next
        e = e.next
    }
    return true
}

fun reverse(start: ListNode?) {
    var cur = start
    var pre: ListNode? = null
    while (cur != null) {
        val tem = cur.next
        cur.next = pre
        pre = cur
        cur = tem
    }
}
