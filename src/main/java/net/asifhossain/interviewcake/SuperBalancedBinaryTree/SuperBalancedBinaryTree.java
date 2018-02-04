package net.asifhossain.interviewcake.SuperBalancedBinaryTree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SuperBalancedBinaryTree {
    static private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(4);


        System.out.println(isSuperBalancedBinaryTree(root));

    }

    public static boolean isSuperBalancedBinaryTree(Node root) {
        Set<Integer> depths = new HashSet<>(3);

        isSuperBalancedBinaryTree(root, 0, depths);

        System.out.println(depths);

        if(depths.size() < 2) return true;

        if (depths.size() > 2) return false;

        return Math.abs((int) depths.toArray()[0] - (int) depths.toArray()[1]) <= 1;
    }

    private static void isSuperBalancedBinaryTree(Node node, int depth, Set<Integer> depths) {

        if(node == null) return;

        if(node.left == null && node.right == null) {
            depths.add(depth);
        }

        isSuperBalancedBinaryTree(node.left, depth + 1, depths);
        isSuperBalancedBinaryTree(node.right, depth + 1, depths);
    }

}
