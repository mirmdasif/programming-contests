package net.asifhossain.leetcode.P0017BinaryTreeLevelOrderTraversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        Map<TreeNode, Integer> depths = new HashMap<>();

        if (root == null) return result;

        nodes.add(root);
        depths.put(root, 0);


        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer depth = depths.get(node);

            if (result.size() <= depth) {
                result.add(depth, new ArrayList<>());
            }

            List<Integer> levelValues = result.get(depth);
            levelValues.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                depths.put(node.left, depth + 1);
            }

            if (node.right != null) {
                nodes.add(node.right);
                depths.put(node.right, depth + 1);
            }
        }

        Collections.reverse(result);

        return result;
    }
}