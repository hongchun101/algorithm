package leetcode

class `94二叉树的中序遍历` {
}


fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
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
