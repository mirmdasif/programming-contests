package net.asifhossain.leetcode.P0101SymmetricTree

class TreeNode(var `val`: Int) {
    var left : TreeNode? = null
    var right : TreeNode? = null
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root, root)
    }

    fun isSymmetric(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) return true

        if (n1 != null && n2 != null)
            return n1.`val` == n2.`val`
                    && isSymmetric(n1.left, n2.right)
                    && isSymmetric(n1.right, n2.left)
        return false
    }
}