package leetcode

import java.util.*

class `155最小栈` {
}

class MinStack() {

    var stack = Stack<Int>()
    var minStack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        } else {
            minStack.push(minStack.peek())
        }
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}
