package com.samples.crls.ds;

import org.junit.jupiter.api.Test;

public class TestRBTree {

    @Test
    public void insertIntoRBTree() {
        RBTree rbTree = new RBTree();
        rbTree.insert(1);
        rbTree.insert(2);
        rbTree.insert(5);
        rbTree.insert(4);
        rbTree.insert(7);
        rbTree.insert(8);
        rbTree.insert(11);
        rbTree.insert(14);
        rbTree.insert(15);
        rbTree.inOrderTraversal();
    }

    @Test
    public void insertIntoRBTree1() {
        RBTree rbTree = new RBTree();
        rbTree.insert(10);
        rbTree.insert(18);
        rbTree.insert(7);
        rbTree.insert(15);
        rbTree.insert(16);
        rbTree.insert(30);
        rbTree.insert(25);
        rbTree.insert(40);
        rbTree.insert(60);
        rbTree.insert(2);
        rbTree.insert(1);
        rbTree.insert(70);
        rbTree.inOrderTraversal();
    }

    @Test
    public void testDelete() {
        RBTree rbTree = new RBTree();
        rbTree.insert(10);
        rbTree.insert(18);
        rbTree.insert(7);
        rbTree.insert(15);
        rbTree.insert(16);
        rbTree.insert(30);
        rbTree.insert(25);
        rbTree.insert(40);
        rbTree.insert(60);
        rbTree.insert(2);
        rbTree.insert(1);
        rbTree.insert(70);
        rbTree.delete(25);
        rbTree.inOrderTraversal();
    }

    @Test
    public void whenBlackNodeBeingDeletedHasOnlyRightChild() {
        //In this case the right child with red color is moved to
        //node being deleted (3).  So, node(4) gets moved to
        //node(3) place and gets simply recolored to black.
        //Black deleted and replaced with red
        RBTree rbTree = new RBTree();
        rbTree.insert(2);
        rbTree.insert(1);
        rbTree.insert(3);
        rbTree.insert(4);
        rbTree.delete(3);
        rbTree.inOrderTraversal();
    }

    @Test
    public void whenBlackNodeBeingDeletedHasOnlyLeftChild() {
        //In this case the left child node(32) with red color is moved to
        //node being deleted (35).  So, node(32) gets moved to
        //node(35) place and gets simply recolored to black.
        //Black deleted and replaced with red
        RBTree rbTree = new RBTree();
        rbTree.insert(20);
        rbTree.insert(15);
        rbTree.insert(25);
        rbTree.insert(10);
        rbTree.insert(17);
        rbTree.insert(30);
        rbTree.insert(35);
        rbTree.insert(32);
        rbTree.delete(35);
        rbTree.inOrderTraversal();
    }

    @Test
    public void whenDeletingRoot() {
        //In this case the successor node(3) with black color is moved to
        //root node being deleted (2).  So, node(4) gets moved to
        //node(3) place and gets simply recolored to black.
        //Black deleted and replaced with red
        RBTree rbTree = new RBTree();
        rbTree.insert(2);
        rbTree.insert(1);
        rbTree.insert(3);
        rbTree.insert(4);
        rbTree.delete(2);
        rbTree.inOrderTraversal();
    }

    @Test
    public void whenDeletingANodeWhoseSuccessorIsMinimumOfLeftSubtreeOfRightChild() {
        //In this case the successor node(3) with black color is moved to
        //root node being deleted (2).  So, node(4) gets moved to
        //node(3) place and gets simply recolored to black.
        //Black deleted and replaced with red
        RBTree rbTree = new RBTree();
        rbTree.insert(80);
        rbTree.insert(40);
        rbTree.insert(30);
        rbTree.insert(45);
        rbTree.insert(20);
        rbTree.insert(35);
        rbTree.insert(44);
        rbTree.insert(46);

        rbTree.insert(97);
        rbTree.insert(100);
        rbTree.insert(84);

        rbTree.insert(95);
        rbTree.insert(93);
        rbTree.insert(94);
        rbTree.insert(96);


        rbTree.inOrderTraversal();
    }
}
