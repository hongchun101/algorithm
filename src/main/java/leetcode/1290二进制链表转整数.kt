package leetcode

fun main() {
    println(getDecimalValue(ListNode(1).apply {
        next = ListNode(0).apply {
            next = ListNode(1)
        }
    }))
}

fun getDecimalValue(head: ListNode?): Int {
    var cur = head
    var sum = 0
    while (cur != null) {
        sum = sum shl 1
        sum += cur.`val`
        cur = cur.next
    }
    return sum
}

fun trainingPlan(head: ListNode?, cnt: Int): ListNode? {
    var s = head
    var f = head
    for (i in 1..<cnt) {
        f = f?.next
    }
    while (f?.next != null) {
        f = f.next
        s = s?.next
    }
    return s
}