package leetcode

class `144二叉树的前序遍历` {
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
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
