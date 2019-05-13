package net.asifhossain.leetcode.P0108ArrayToBst

import com.sun.xml.internal.fastinfoset.util.StringArray

class TreeNode(val value:  Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun main(args: StringArray) {

    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? = makeBst(nums, 0, nums.size -1)

    private fun makeBst(nums: IntArray, indexFirst: Int, indexLast: Int): TreeNode? {
        if (indexFirst > indexLast) return null
        val root = TreeNode(nums[(indexFirst + indexLast) / 2])
        root.left = makeBst(nums, indexFirst, (indexFirst + indexLast) / 2 - 1)
        root.right = makeBst(nums, (indexFirst + indexLast) / 2 + 1, indexLast)

        return root
    }
}