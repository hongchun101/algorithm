package leetcode

fun main() {
    var node1 = Node(7)
    var node2 = Node(13)
    var node3 = Node(11)
    var node4 = Node(10)
    var node5 = Node(1)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    node2.random = node1
    node3.random = node5
    node4.random = node3
    node5.random = node1

    var copyRandomList = copyRandomList(node1)
    //while (copyRandomList != null) {
    //    print("${copyRandomList.`val`}::")
    //    val random = copyRandomList.random
    //    if (random != null) {
    //        print("${random.`val`}")
    //    }
    //    println()
    //    copyRandomList = copyRandomList.next
    //}
}

fun copyRandomList(node: Node?): Node? {

    var cur = node

    while (cur != null) {
        val n = Node(cur.`val`)
        val next = cur.next
        cur.next = n
        n.next = next
        cur = n.next
    }

    cur = node
    while (cur != null) {
        cur.next?.random = cur.random?.next
        cur = cur.next?.next
    }

    cur = node

    val h = cur?.next
    var copy = h
    cur = node?.next?.next
    node?.next = cur

    while (cur != null) {
        copy?.next = cur.next
        cur.next = cur.next?.next
        cur = cur.next
        copy = copy?.next
    }
    return h
}
