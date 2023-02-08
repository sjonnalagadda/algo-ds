package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBSTree {

    @Test
    public void testBSTInOrderTraversal() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        bsTree.inOrderTraversal();
        System.out.println("");
    }

    @Test
    public void testBSTInOrderTraversalWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        bsTree.inOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTInOrderTraversalWithoutRecursion1() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree1();
        bsTree.inOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTInOrderTraversalWithoutRecursion2() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree2();
        bsTree.inOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTInOrderTraversalWithoutRecursion3() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree3();
        bsTree.inOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTInOrderTraversalWithoutRecursion4() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree4();
        bsTree.inOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPreOrderTraversal() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        bsTree.preOrderTraversal();
        System.out.println("");
    }

    @Test
    public void testBSTPreOrderTraversalWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        bsTree.preOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPreOrderTraversalWithoutRecursion1() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree1();
        bsTree.preOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPreOrderTraversalWithoutRecursion2() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree2();
        bsTree.preOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPreOrderTraversalWithoutRecursion3() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree3();
        bsTree.preOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPreOrderTraversalWithoutRecursion4() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree4();
        bsTree.preOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPostOrderTraversal() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        bsTree.postOrderTraversal();
        System.out.println("");
    }

    @Test
    public void testBSTPostOrderTraversalWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        bsTree.postOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPostOrderTraversalWithoutRecursion1() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree1();
        bsTree.postOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPostOrderTraversalWithoutRecursion2() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree2();
        bsTree.postOrderTraversalWithoutRecursion();
        System.out.println("");
    }

    @Test
    public void testBSTPostOrderTraversalWithoutRecursion3() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree3();
        bsTree.postOrderTraversalWithoutRecursion();
        System.out.println("");
    }


    @Test
    public void testBSTPosteOrderTraversalWithoutRecursion4() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree4();
        bsTree.postOrderTraversalWithoutRecursion();
        System.out.println("");
    }


    @Test
    public void testBSTSearch() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNotNull(bsTree.search(4));
    }

    @Test
    public void testBSTSearch2() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNotNull(bsTree.search(11));
    }

    @Test
    public void testBSTSearchLowerNotFound() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNull(bsTree.search(1));
    }

    @Test
    public void testBSTSearchHigherNotFound() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNull(bsTree.search(12));
    }

    @Test
    public void testBSTSearchWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNotNull(bsTree.searchWithoutRecursion(4));
    }

    @Test
    public void testBSTSearch2WithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNotNull(bsTree.searchWithoutRecursion(11));
    }

    @Test
    public void testBSTSearchLowerNotFoundWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNull(bsTree.searchWithoutRecursion(1));
    }

    @Test
    public void testBSTSearchHigherNotFoundWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        Assertions.assertNull(bsTree.searchWithoutRecursion(12));
    }

    @Test
    public void testMinimum() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.minimum();
        Assertions.assertEquals(2, node.value);
    }

    @Test
    public void testMaximum() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.maximum();
        Assertions.assertEquals(11, node.value);
    }

    @Test
    public void testMinimumWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.minimumWithoutRecursion();
        Assertions.assertEquals(2, node.value);
    }

    @Test
    public void testMaximumWithoutRecursion() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.maximumWithoutRecursion();
        Assertions.assertEquals(11, node.value);
    }

    @Test
    public void testSuccessor() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.searchWithoutRecursion(4);
        TreeNode sucessor = bsTree.sucessor(node);
        Assertions.assertEquals(7, sucessor.value);
    }

    @Test
    public void testSuccessor1() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.searchWithoutRecursion(7);
        TreeNode sucessor = bsTree.sucessor(node);
        Assertions.assertEquals(8, sucessor.value);
    }


    @Test
    public void testPredecessor() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.searchWithoutRecursion(8);
        TreeNode predecessor = bsTree.predecessor(node);
        Assertions.assertEquals(7, predecessor.value);
    }

    @Test
    public void testPredecessor1() {
        BSTree bsTree = new BSTree();
        bsTree.rootNode = createTree();
        TreeNode node = bsTree.searchWithoutRecursion(4);
        TreeNode predecessor = bsTree.predecessor(node);
        Assertions.assertEquals(3, predecessor.value);
    }

    @Test
    public void testInsertion() {
        BSTree bsTree = new BSTree();
        bsTree.insert(15);
        bsTree.insert(11);
        bsTree.insert(17);
        bsTree.insert(6);
        bsTree.insert(13);
        bsTree.insert(16);
        bsTree.insert(22);
        bsTree.insert(4);
        bsTree.insert(9);
        bsTree.insert(12);
        bsTree.insert(14);
        bsTree.insert(20);
        bsTree.insert(23);
        bsTree.insert(8);
        bsTree.insert(10);
        bsTree.insert(19);
        bsTree.insert(21);
        bsTree.insert(7);
        TreeNode node = bsTree.searchWithoutRecursion(7);
        TreeNode predecessor = bsTree.predecessor(node);
        Assertions.assertEquals(6, predecessor.value);
    }

    private TreeNode createTree() {
        TreeNode rootNode = new TreeNode();
        rootNode.value = 7;

        TreeNode threeNode = new TreeNode();
        threeNode.value = 3;
        threeNode.parent = rootNode;
        rootNode.left = threeNode;

        TreeNode twoNode = new TreeNode();
        twoNode.value = 2;
        twoNode.parent = threeNode;
        threeNode.left = twoNode;

        TreeNode fourNode = new TreeNode();
        fourNode.value = 4;
        fourNode.parent = threeNode;
        threeNode.right = fourNode;


        TreeNode tenNode = new TreeNode();
        tenNode.value = 10;
        tenNode.parent = rootNode;
        rootNode.right = tenNode;


        TreeNode eightNode = new TreeNode();
        eightNode.value = 8;
        eightNode.parent = tenNode;
        tenNode.left = eightNode;

        TreeNode elevenNode = new TreeNode();
        elevenNode.value = 11;
        elevenNode.parent = tenNode;
        tenNode.right = elevenNode;
        return rootNode;
    }

    private TreeNode createTree1() {
        TreeNode rootNode = new TreeNode();
        rootNode.value = 1;

        TreeNode fourNode = new TreeNode();
        fourNode.value = 4;
        rootNode.right = fourNode;
        fourNode.parent = rootNode;

        TreeNode fiveNode = new TreeNode();
        fiveNode.value = 5;
        fourNode.right = fiveNode;
        fiveNode.parent = fourNode;

        TreeNode tenNode = new TreeNode();
        tenNode.value = 10;
        fiveNode.right = tenNode;
        tenNode.parent = fiveNode;

        TreeNode sixteenNode = new TreeNode();
        sixteenNode.value = 16;
        tenNode.right = sixteenNode;
        sixteenNode.parent = tenNode;

        TreeNode sevenTeenNode = new TreeNode();
        sevenTeenNode.value = 17;
        sixteenNode.right = sevenTeenNode;
        sevenTeenNode.parent = sixteenNode;

        TreeNode twentyOneNode = new TreeNode();
        twentyOneNode.value = 21;
        sevenTeenNode.right = twentyOneNode;
        twentyOneNode.parent = sevenTeenNode;

        return  rootNode;
    }

    private TreeNode createTree2() {

        TreeNode rootNode = new TreeNode();
        rootNode.value = 4;

        TreeNode oneNode = new TreeNode();
        oneNode.value = 1;
        rootNode.left = oneNode;
        oneNode.parent = rootNode;

        TreeNode fiveNode = new TreeNode();
        fiveNode.value = 5;
        rootNode.right = fiveNode;
        fiveNode.parent = rootNode;

        TreeNode tenNode = new TreeNode();
        tenNode.value = 10;
        fiveNode.right = tenNode;
        tenNode.parent = fiveNode;

        TreeNode sixteenNode = new TreeNode();
        sixteenNode.value = 16;
        tenNode.right = sixteenNode;
        sixteenNode.parent = tenNode;

        TreeNode sevenTeenNode = new TreeNode();
        sevenTeenNode.value = 17;
        sixteenNode.right = sevenTeenNode;
        sevenTeenNode.parent = sixteenNode;

        TreeNode twentyOneNode = new TreeNode();
        twentyOneNode.value = 21;
        sevenTeenNode.right = twentyOneNode;
        twentyOneNode.parent = sevenTeenNode;

        return  rootNode;
    }

    private TreeNode createTree3() {
        TreeNode rootNode = new TreeNode();
        rootNode.value = 5;

        TreeNode oneNode = new TreeNode();
        oneNode.value = 1;
        rootNode.left = oneNode;
        oneNode.parent = rootNode;

        TreeNode fourNode = new TreeNode();
        fourNode.value = 4;
        oneNode.right = fourNode;
        fourNode.parent = oneNode;

        TreeNode tenNode = new TreeNode();
        tenNode.value = 10;
        rootNode.right = tenNode;
        tenNode.parent = rootNode;

        TreeNode sixteenNode = new TreeNode();
        sixteenNode.value = 16;
        tenNode.right = sixteenNode;
        sixteenNode.parent = tenNode;

        TreeNode sevenTeenNode = new TreeNode();
        sevenTeenNode.value = 17;
        sixteenNode.right = sevenTeenNode;
        sevenTeenNode.parent = sixteenNode;

        TreeNode twentyOneNode = new TreeNode();
        twentyOneNode.value = 21;
        sevenTeenNode.right = twentyOneNode;
        twentyOneNode.parent = sevenTeenNode;

        return  rootNode;
    }


    private TreeNode createTree4() {
        TreeNode rootNode = new TreeNode();
        rootNode.value = 10;

        TreeNode fourNode = new TreeNode();
        fourNode.value = 4;
        rootNode.left = fourNode;
        fourNode.parent = rootNode;

        TreeNode fiveNode = new TreeNode();
        fiveNode.value = 5;
        fourNode.right = fiveNode;
        fiveNode.parent = fourNode;

        TreeNode oneNode = new TreeNode();
        oneNode.value = 1;
        fourNode.left = oneNode;
        oneNode.parent = fourNode;

        TreeNode sixteenNode = new TreeNode();
        sixteenNode.value = 16;
        rootNode.right = sixteenNode;
        sixteenNode.parent = rootNode;

        TreeNode sevenTeenNode = new TreeNode();
        sevenTeenNode.value = 17;
        sixteenNode.right = sevenTeenNode;
        sevenTeenNode.parent = sixteenNode;

        TreeNode twentyOneNode = new TreeNode();
        twentyOneNode.value = 21;
        sevenTeenNode.right = twentyOneNode;
        twentyOneNode.parent = sevenTeenNode;

        return  rootNode;
    }
}
