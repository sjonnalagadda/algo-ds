package com.samples.crls.ds;

enum Color {
    RED,
    BLACK
}
public class RBTreeNode {
    RBTreeNode left;
    RBTreeNode right;
    RBTreeNode parent;
    Color color;
    int value;
}
