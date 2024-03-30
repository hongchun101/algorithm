package leetcode

import java.util.Deque
import java.util.LinkedList

class `641设计循环双端队列` {
}

class MyCircularDeque(k: Int) {

    var deque = LinkedList<Int>()

    var size = 0

    var limit = k

    fun insertFront(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            deque.add(0, value)
            size++
            return true
        }
    }

    fun insertLast(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            deque.add(value)
            size++
            true
        }
    }

    fun deleteFront(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            deque.removeFirst()
            size--
            true
        }
    }

    fun deleteLast(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            deque.removeLast()
            size--
            true
        }
    }

    fun getFront(): Int {
        return if (isEmpty()) {
            -1
        } else {
            deque[0]
        }
    }

    fun getRear(): Int {
        return if (isEmpty()) {
            -1
        } else {
            deque[size - 1]
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == limit
    }

}
