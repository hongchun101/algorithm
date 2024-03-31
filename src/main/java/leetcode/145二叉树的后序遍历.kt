package leetcode

import java.util.*
import kotlin.collections.ArrayList

class `145二叉树的后序遍历` {
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    return postOrder(root)
}

fun postOrder(node: TreeNode?): List<Int> {
    var list = ArrayList<Int>()
    if (node != null) {
        list.addAll(postOrder(node.left))
        list.addAll(postOrder(node.right))
        list.add(node.`val`)
    }
    return list
}

fun postOrderNonRecursive(node: TreeNode?): List<Int> {
    var head = node
    if (node != null) {
        var stack = Stack<TreeNode>()
        var collect = Stack<TreeNode>()
        stack.push(head)
        while (stack.isNotEmpty()) {
            head = stack.pop()
            collect.push(head)
            if (head.left != null) {
                stack.push(head.left)
            }
            if (head.right != null) {
                stack.push(head.right)
            }
        }
        var list = ArrayList<Int>()
        while (collect.isNotEmpty()) {
            list.add(collect.pop().`val`)
        }
        return list
    }
    return emptyList()
}
