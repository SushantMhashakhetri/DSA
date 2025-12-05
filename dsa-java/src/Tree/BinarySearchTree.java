package Tree;

public class BinarySearchTree {

    private TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

       public TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode insert(int data, TreeNode node){
        if(node == null){
            node = new TreeNode(data);
            return node;

        }
        if(data< node.data) {
         node.left = insert(data, node.left);
        } else {
            node.right = insert(data, node.right);
        }

        return node;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data+"-->");
        inOrderTraversal(node.right);
    }

    public TreeNode search(TreeNode root, int key) {
        if (root == null || key == root.data) {
            return root;
        }
        if (key < root.data) {
           return search(root.left, key);
        } else {
           return search(root.right, key);
        }
    }

    private boolean validBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return validBST(node.left, min, node.data) && validBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(1, bst.root);
        bst.root = bst.insert(1, bst.root);
        bst.root = bst.insert(8, bst.root);
        bst.root = bst.insert(9, bst.root);
        bst.root = bst.insert(2, bst.root);
        bst.inOrderTraversal(bst.root);
        System.out.println();
      TreeNode temp =   bst.search(bst.root,52);
        if (temp != null) {
        System.out.println(temp.data);
        } else {
            System.out.println("Not Found !");
        }
    }
}
