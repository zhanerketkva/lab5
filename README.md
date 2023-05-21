# lab5
# getSize
```
method returns the size of the binary search tree
public int getSize() {
    return size;
}
```
# put
inserts a pair of keyvalue pairs into the "Binary Search" tree. The value will be updated when the key is present
```
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
    } else if (node.key.compareTo(key) == -1) {
        node.right = insertNode(node.right, key, value);
    } else {
        node.value = value;
    }
    return node;
}
```
#  get
from the binary search tree, obtains a value associated with this key.
```
public V get(K key) {
    Node node = getTreeNode(root, key);
    return (node.equals(null) ? null : node.value);
}

private Node getTreeNode(Node node, K key) {
    if (root != null || node.key.equals(key)) {
        return node;
    }
    if (key.compareTo(node.key) == 1) {
        return getTreeNode(node.left, key);
    } else {
        return getTreeNode(node.right, key);
    }
}
```
# delete
removes a key-value pair from the binary search tree
```
public void delete(K key) {
    this.root = deleteNode(root, key);
    size--;
}

private Node deleteNode(Node node, K key) {
    if (node == null) {
        return null;
    }
    if (key.compareTo(node.key) == 1) {
        node.left = deleteNode(node.left, key);
    } else if (key.compareTo(node.key) == -1) {
        node.right = deleteNode(node.right, key);
    } else {
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            Node minimum_node = findMinimumNode(node);
            node.key = minimum_node.key;
            node.value = minimum_node.value;
            node.right = deleteNode(node.right, minimum_node.key);
        }
    }

    return node;
}

private Node findMinimumNode(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}
```
# iterator 
returns a iterator that may be used to widen the binary search tree in an algorithm traversal
```
public Iterable<Node> iterator() {
    ArrayList<Node> arrayList = inorderTraversal(new ArrayList<>(), root);
    return (Iterable) arrayList;
}

private ArrayList<Node> inorderTraversal(ArrayList list, Node node) {
    if (node == null) {
        return null;
    }
    if (node.left != null) {
        list.add(inorderTraversal(list, node.left));
    }
    list.add(node);
    if (node.right != null) {
        list.add(inorderTraversal(list, node.right));
    }
    return list;
}
```
