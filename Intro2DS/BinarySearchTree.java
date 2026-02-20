/**
 * This class implements a binary search tree (BST) data structure.
 * A BST is a binary tree where each node has at most two children, and for any given node, the left child's value is less than the node's value, and the right child's value is greater than the node's value.
 * This property allows for efficient searching, insertion, and deletion operations.
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>> {


    /**
     * This inner class represents a node in the binary search tree.
     * Each node contains a data element of type T, and references to the left and right
     * child nodes. The constructor initializes the data and sets the left and right child references to null.
     * The Node class is private because it is an implementation detail of the BinarySearchTree class and should not be exposed to users of the BinarySearchTree.
     */
    private class Node {
        T data;
        Node left;
        Node right;

        /**
         * Constructor for the Node class. It initializes the data field with the provided value and sets the left and right child references to null.
         * The data parameter is of type T, which is a generic type that extends Comparable, allowing us to compare the values for insertion and searching in the binary search tree.
         * @param data
         */
        public Node(T data) { this.data = data; }
    }

    /**
     * The root of the binary search tree. It is a reference to the topmost node in the tree. Initially, it is set to null, indicating that the tree is empty.
     * The root node is the entry point for all operations on the binary search tree, such as insertion, searching, and traversal. When a new node is inserted into the tree, it will be placed in the correct position based on its value compared to the existing nodes, starting from the root.
     * The root is private because it is an implementation detail of the BinarySearchTree class and should not be exposed to users of the BinarySearchTree.
     */
    private Node root;

    /**
     * Inserts a new value into the binary search tree. This method takes a data element of type T as a parameter and calls the recursive helper method insertRec to find the correct position for the new node in the tree.
     * The insert method is public, allowing users of the BinarySearchTree class to add new values to the tree. The insertRec method will compare the new data with the current node's data and decide whether to go left or right in the tree until it finds an appropriate null position to insert the new node.
     * The time complexity of the insert operation is O(h), where h is the height of the tree. In the worst case (when the tree is skewed), this can be O(n), but in a balanced tree, it is O(log n).
     * @param data
     */
    public void insert(T data) {
        root = insertRec(root, data);
    }

    /**
     * This is a recursive helper method for inserting a new value into the binary search tree. It takes the current node (root) and the data to be inserted as parameters. If the current node is null, it creates and returns a new node with the given data. If the data is less than the current node's data, it recursively calls itself on the left child; if greater, it calls itself on the right child. Finally, it returns the updated node.
     * The insertRec method is private because it is an implementation detail of the BinarySearchTree class and should not be exposed to users of the BinarySearchTree. It is only intended to be called by the public insert method.
     * The time complexity of this method is O(h), where h is the height of the tree, due to the recursive calls. In a balanced tree, this would be O(log n), but in the worst case (skewed tree), it can be O(n).
     * @param root
     * @param data
     * @return
     */
    private Node insertRec(Node root, T data) {
        if (root == null) {
            return new Node(data);
        }
        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }
}