package net.asifhossain.leetcode.P0094InorderTraversal

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val numbers = mutableListOf<Int>()
        inorderTraversal(root, numbers)
        return numbers
    }

    private fun inorderTraversal(node: TreeNode?, numbers: MutableList<Int>) {
        if (node == null) return

        inorderTraversal(node.left, numbers)
        numbers.add(node.`val`)
        inorderTraversal(node.right, numbers)
    }
}