package net.asifhossain.interviewcake.BinarySerchTreeChecker;

/**
 * @author asif.hossain
 * @since 10/8/17.
 */
public class Solution {
    public static void main(String[] args) {
        Node n1 = new Node(50);
        Node n2 = new Node(30);
        n2.right = new Node(40);
        n2.left = new Node(20);

        Node n3 = new Node(80);
        n3.right = new Node(70);
        n3.left = new Node(90);

        n1.left = n2;
        n1.right = n3;

        System.out.println(isBST(n1));
    }


    static int lastValue = Integer.MIN_VALUE;
    private static boolean isBST(Node root) {
        if (root == null) return true;

        if (!isBST(root.left)) {
            return false;
        }

        if(root.data < lastValue) return false;

        lastValue = root.data;


        return isBST(root.right);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
