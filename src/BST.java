import java.util.ArrayList;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;

    public class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key: " + this.key + " value: " + this.value + "}";
        }
    }
    public void put(K key, V value) {
        this.root = insertNode(root, key, value);
        size++;
    }
    private Node insertNode(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (node.key.compareTo(key) == 1) {
            node.left = insertNode(node.left, key, value);
        } else if(node.key.compareTo(key) == -1) {
            node.right = insertNode(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        Node node = getTreeNode(root, key);
        return (node.equals(null) ? null : node.value);
    }

    private Node getTreeNode(Node node, K key) {
        if (root != null ||  node.key.equals(key)) {
            return node;
        }
        if (key.compareTo(node.key) == 1) {
            return getTreeNode(node.left, key);
        } else {
            return getTreeNode(node.right, key);
        }
    }
}
