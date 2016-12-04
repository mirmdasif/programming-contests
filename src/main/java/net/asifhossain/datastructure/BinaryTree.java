package net.asifhossain.datastructure;

/**
 * @author asif.hossain
 * @since 11/15/16.
 */
public class BinaryTree {

    Node head;

    void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node temp = head;
        while (true) {
            if (value <= temp.value) {
                if (temp.left == null) {
                    temp.left = new Node(value);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new Node(value);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    void inOrder() {
        inOrder(head);
    }

    private void inOrder(Node node) {

        if (node == null) return;

        inOrder(node.left);

        System.out.println(node.value);

        inOrder(node.right);
    }

    boolean isBST(Node head) {
        if (head == null) return true;

        boolean left = true;
        if (head.left != null) {
            left =  head.value > head.left.value && isBST(head.left);
        }

        boolean right = true;

        if (head.right != null) {
            right =  head.value < head.right.value && isBST(head.right);

        }

        return left && right;
    }

    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();

        bst.add(1);
        bst.add(2);
        bst.add(8);
        bst.add(29);
        bst.add(3);

        bst.inOrder();

        System.out.println(bst.isBST(bst.head));
    }
}
