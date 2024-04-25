package leetcode

fun mergeNodes(head: ListNode?): ListNode? {
    var sum = 0
    var f = head?.next
    var h: ListNode? = null
    var c: ListNode? = null
    while (f != null) {
        if (f.`val` != 0) {
            sum += f.`val`
            f = f.next
        } else {
            val listNode = ListNode(sum)
            if (h == null) {
                h = listNode
                c = h
            } else {
                c?.next = listNode
                c = c?.next
            }

            sum = 0
            f = f.next
        }
    }
    return h
}
