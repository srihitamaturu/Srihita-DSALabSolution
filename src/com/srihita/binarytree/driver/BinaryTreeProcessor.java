package com.srihita.binarytree.driver;

import java.util.ArrayList;

class Node {
    Node leftNode;
    Node rightNode;
    int nodeData;

    Node(int data) {
        nodeData = data;
        leftNode = rightNode = null;
    }
}

public class BinaryTreeProcessor {
    public static ArrayList<Integer> findLongestPath(Node root) {
        if (root == null) {
            ArrayList<Integer> path = new ArrayList<>();
            return path;
        }
        ArrayList<Integer> left = findLongestPath(root.leftNode);
        ArrayList<Integer> right = findLongestPath(root.rightNode);
        if (right.size() > left.size()) {
            right.add(root.nodeData);
        } else {
            left.add(root.nodeData);
        }
        return (left.size() > right.size() ? left : right);
    }


    public static void main(String[] args) {
        Node root = new Node(100);
        Node node1 = new Node(20);
        Node node2 = new Node(130);
        Node node3 = new Node(10);
        Node node4 = new Node(50);
        Node node5 = new Node(110);
        Node node6 = new Node(140);
        Node node7 = new Node(5);
        node3.leftNode = node7;
        node1.leftNode = node3;
        node1.rightNode = node4;
        node2.leftNode = node5;
        node2.rightNode = node6;
        root.leftNode = node1;
        root.rightNode = node2;
        ArrayList<Integer> output = findLongestPath(root);
        int n = output.size();

        System.out.print(output.get(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            System.out.print(" -> " + output.get(i));
        }
    }
}