package ua.koss.binarytree.model;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeftNode(addRecursive(current.getLeftNode(), value));
        } else {
            current.setRightNode(addRecursive(current.getRightNode(), value));
        }

        return current;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    public Node<T> search(T valueToSearch) {
        return searchRecursive(root, valueToSearch);
    }

    private Node<T> searchRecursive(Node<T> current, T valueToSearch) {
        if (current == null || valueToSearch == null) {
            return null;
        } else if (current.getValue().equals(valueToSearch)) {
            return current;
        }

        return current.getValue().compareTo(valueToSearch) > 0 ?
                searchRecursive(current.getLeftNode(), valueToSearch) :
                searchRecursive(current.getRightNode(), valueToSearch);
    }

    public Node<T> remove(T valueToRemove) {
        if (valueToRemove == null) {
            return null;
        }
        return removeRecursive(root, valueToRemove);
    }

    private Node<T> removeRecursive(Node<T> current, T valueToRemove) {
        if (current == null) return null;

        if (valueToRemove.compareTo(current.getValue()) < 0) {
            current.setLeftNode(removeRecursive(current.getLeftNode(), valueToRemove));
        } else if (valueToRemove.compareTo(current.getValue()) > 0) {
            current.setRightNode(removeRecursive(current.getRightNode(), valueToRemove));
        } else {
            if (current.getLeftNode() == null) {
                current = current.getRightNode();
                size--;
                return current;
            } else if (current.getRightNode() == null) {
                current = current.getLeftNode();
                size--;
                return current;
            }
            current.setValue(inOrderSuccessor(current.getRightNode()));
            current.setRightNode(removeRecursive(current.getRightNode(), valueToRemove));
        }


        return current;
    }

    private T inOrderSuccessor(Node<T> root) {
        T minimum = root.getValue();
        while (root.getLeftNode() != null) {
            minimum = root.getLeftNode().getValue();
            root = root.getLeftNode();
        }
        size--;
        return minimum;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<T> root)
    {
        StringBuilder builder = new StringBuilder();
        if (root == null)
            return "";
        builder.append(toString(root.getLeftNode()));
        builder.append(toString(root.getRightNode()));
        return builder.append(root.getValue().toString()).toString();
    }
}
