package leetcode

import java.util.LinkedList
import java.util.Queue

class `225用队列实现栈` {
}

class MyStack() {

    var queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.offer(x)
        val size = queue.size
        for (e in 0..<size - 1) {
            queue.add(queue.poll())
        }
    }

    fun pop(): Int {
        return queue.poll()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}
