package leetcode

import java.util.Stack
import java.util.ArrayList

class `144二叉树的前序遍历` {
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    return preOrder(root)
}

fun preOrder(node: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    if (node != null) {
        list.add(node.`val`)
        list.addAll(preOrder(node.left))
        list.addAll(preOrder(node.right))
    }
    return list
}

fun preOrderNonRecursive(node: TreeNode?): List<Int> {
    var list = ArrayList<Int>()
    if (node != null) {
        var stack = Stack<TreeNode>();
        stack.push(node)
        while (!stack.isEmpty()) {
            val head = stack.pop()
            list.add(head.`val`)
            if (head.right != null) {
                stack.push(head.right)
            }
            if (head.left != null) {
                stack.push(head.left)
            }
        }
    }
    return list
}
