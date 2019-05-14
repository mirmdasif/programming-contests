package net.asifhossain.leetcode.P0110BalancedBinaryTree

import kotlin.math.abs

class TreeNode(val value:  Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {

        val (height, balanced) = checkBalance(root, 0)

        return balanced
    }

    fun checkBalance(node: TreeNode?, depth: Int): Pair<Int, Boolean> {
        if (node == null) return Pair(depth, true)

        val left = checkBalance(node.left, depth + 1)
        val right = checkBalance(node.right, depth + 1)

        return Pair(maxOf(left.first, right.first), left.second.and(right.second).and(abs(left.first - right.first) <= 1))
    }
}