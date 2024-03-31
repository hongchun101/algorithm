package leetcode

import com.sun.source.tree.Tree
import java.util.*
import kotlin.collections.ArrayList

class `94二叉树的中序遍历` {
}


fun inorderTraversal(root: TreeNode?): List<Int> {
    return inOrder(root)
}

fun inOrder(node: TreeNode?): List<Int> {
    var list = ArrayList<Int>()
    if (node != null) {
        list.addAll(inOrder(node.left))
        list.add(node.`val`)
        list.addAll(inOrder(node.right))
    }
    return list
}

fun inOrderNonRecursive(node: TreeNode?): List<Int> {
    var head = node
    var stack = Stack<TreeNode>()
    var list = ArrayList<Int>()
    while (stack.isNotEmpty() || head != null) {
        if (head != null) {
            stack.push(head)
            head = head.left
        } else {
            head = stack.pop()
            list.add(head.`val`)
            head = head.right
        }
    }
    return list
}
