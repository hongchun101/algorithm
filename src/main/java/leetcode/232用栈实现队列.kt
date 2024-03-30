package leetcode

import java.util.Stack

class `232用栈实现队列` {
}

class MyQueue() {

    var inStack = Stack<Int>()

    var outStack = Stack<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.pop()
    }

    fun peek(): Int {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.peek()
    }

    fun empty(): Boolean {
        return outStack.empty() && inStack.empty()
    }

}