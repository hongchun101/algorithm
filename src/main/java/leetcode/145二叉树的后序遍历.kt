package leetcode

class `145二叉树的后序遍历` {
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    if(root == null) {
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
