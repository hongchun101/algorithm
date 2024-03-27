package leetcode

class `2两数相加` {

}

fun main() {
    val node1 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(5).apply {
                next = ListNode(9).apply {
                    next = null
                }
            }
        }
    }
    val node2 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(8).apply {
                next = ListNode(9).apply {
                    next = null
                }
            }
        }
    }
    var addTwoNumbers = addTwoNumbers(node1, node2)
    while (addTwoNumbers != null) {
        println(addTwoNumbers.`val`)
        addTwoNumbers = addTwoNumbers.next
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) {
        return l1 ?: l2
    }

    var c1 = l1
    var c2 = l2

    var carry = 0
    var ans: ListNode? = null
    var cur: ListNode? = null
    while (c1 != null || c2 != null) {
        val i = (c1?.`val` ?: 0) + (c2?.`val` ?: 0) + carry

        carry = i / 10
        val value = i % 10
        if (ans == null) {
            ans = ListNode(value)
            cur = ans
        } else {
            cur!!.next = ListNode(value)
            cur = cur.next
        }
        if (c1 != null) {
            c1 = c1.next
        }
        if (c2 != null) {
            c2 = c2.next
        }
    }
    if (carry == 1) {
        cur!!.next = ListNode(1)
    }
    return ans
}

