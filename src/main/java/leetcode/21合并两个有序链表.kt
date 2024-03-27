package leetcode

class `21合并两个有序链表` {
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
    var mergeTwoLists = mergeTwoLists(node1, node2)
    while (mergeTwoLists != null) {
        println(mergeTwoLists.`val`)
        mergeTwoLists = mergeTwoLists.next
    }
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null || list2 == null) {
        return list1 ?: list2
    }

    val ans: ListNode
    var c1: ListNode?
    var c2: ListNode?

    if (list1.`val` <= list2.`val`) {
        ans = list1
        c1 = list1.next
        c2 = list2
    } else {
        ans = list2
        c1 = list2.next
        c2 = list1
    }
    var pre: ListNode? = ans
    while (c1 != null && c2 != null) {
        if (c1.`val` <= c2.`val`) {
            pre!!.next = c1
            c1 = c1.next
        } else {
            pre!!.next = c2
            c2 = c2.next
        }
        pre = pre.next
    }
    pre!!.next = c1 ?: c2
    return ans
}

