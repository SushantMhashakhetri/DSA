package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void createTreeNode() {
        TreeNode first = new TreeNode(1);      //                             1
        TreeNode second = new TreeNode(2);     //                        2          3
        TreeNode third = new TreeNode(4);      //                     4     5     6    7
        TreeNode fourth = new TreeNode(5);
        TreeNode fifth = new TreeNode(3);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(10);

        root = first;
        first.left = second;
        first.right = fifth;

        second.left = third;
        second.right = fourth;

        fifth.left = sixth;
        fifth.right = seventh;


    }
  // preorder binary tree traversal using recursion
    public void preOrderTraversal(TreeNode temp) {
        if (temp == null){
            return;

        }
        System.out.print(temp.data+"-->");
        preOrderTraversal(temp.left);
        preOrderTraversal(temp.right);
    }

    // preorder binary tree traversal using stack

    public void preOrderTraversalUsingStack() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data+"-->");
            if(node.right!=null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data+"-->");
        inOrderTraversal(node.right);
    }

    public void inOrderTraversalUsingStack(){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null){
            if (temp != null ){
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data+"-->");
                temp = temp.right;
            }

        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+"-->");
    }

    public void postOrderTraversalUsingStack() {
        if (root == null) {
            return;
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || current != null){

            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null ) {
                    temp = stack.pop();
                    System.out.print(temp.data+"-->");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                      temp = stack.pop();
                        System.out.print(temp.data+"-->");
                    }

                } else {
                    current = temp;
                }
            }
        }
       
    }

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {

            TreeNode temp = queue.poll();
            System.out.print(temp.data+"-->");
            if (temp.left != null) {
                queue.offer(temp.left);

            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

    }

    public int findMaxInBinaryTree(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int result = node.data;
        int left = findMaxInBinaryTree(node.left);
        int right = findMaxInBinaryTree(node.right);
        if(left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }


    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.createTreeNode();
        bt.preOrderTraversal(bt.root);
        System.out.println();
        bt.preOrderTraversalUsingStack();
        System.out.println();
        bt.inOrderTraversal(bt.root);
        System.out.println();
        bt.inOrderTraversalUsingStack();
        System.out.println();
        bt.postOrderTraversal(bt.root);
        System.out.println();
        bt.postOrderTraversalUsingStack();
        System.out.println();
        bt.levelOrderTraversal();
        System.out.println();
        System.out.println(bt.findMaxInBinaryTree(bt.root));
    }



}
