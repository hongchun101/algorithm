package leetcode

fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    var gcd: (Int, Int) -> Int = { a, b ->
        var a = a
        var b = b
        while (b != 0) { // 当b为0时，a即为最大公约数
            val temp = b
            b = a % b
            a = temp
        }
        a
    }
    if (head == null) {
        return null
    }
    var pre = head!!
    var cur = head?.next
    while (cur != null) {
        var node = ListNode(gcd(pre.`val`, cur.`val`))
        pre.next = node
        node.next = cur
        pre = cur
        cur = cur.next
    }
    return head
}
