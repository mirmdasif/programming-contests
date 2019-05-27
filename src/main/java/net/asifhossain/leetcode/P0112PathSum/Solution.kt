package net.asifhossain.leetcode.P0112PathSum

class TreeNode(var `val`: Int) {
    var left : TreeNode? = null
    var right : TreeNode? = null
}

class Solution {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) return false

        if (root.left == null && root.right == null)
            return sum - root.`val` == 0
        if (root.left != null && root.right !=null)
            return hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)

        return if (root.left != null)
            hasPathSum(root.left, sum - root.`val`)
        else
            hasPathSum(root.right, sum - root.`val`)
    }
}