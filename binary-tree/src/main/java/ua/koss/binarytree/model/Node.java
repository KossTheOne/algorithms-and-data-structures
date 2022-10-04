package ua.koss.binarytree.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Node<T> {
    @Getter
    private T value;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T value) {
        this.value = value;
        rightNode = null;
        leftNode = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
