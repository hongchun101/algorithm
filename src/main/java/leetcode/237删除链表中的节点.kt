package leetcode

fun deleteNode(node: ListNode?) {
    var cur = node ?: return
    while (cur.next != null) {
        var next = cur.next!!
        cur.`val` = next.`val`
        if (next.next == null) {
            cur.next = null
        } else {
            cur = next
        }
    }
}
