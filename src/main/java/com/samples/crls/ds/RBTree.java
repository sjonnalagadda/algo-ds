package com.samples.crls.ds;

public class RBTree {

    private RBTreeNode rootNode;
    private RBTreeNode sentinel;

    RBTree() {
        this.sentinel = new RBTreeNode();
        this.sentinel.color = Color.BLACK;
        this.sentinel.parent = this.sentinel.left = this.sentinel.right = null;
        this.rootNode = sentinel;
    }

    void inOrderTraversal() {
        inOrderTraversalInternal(this.rootNode);
    }

    private void inOrderTraversalInternal(final RBTreeNode node) {
        if(node != sentinel) {
            inOrderTraversalInternal(node.left);
            System.out.print(node.value+ " ");
            inOrderTraversalInternal(node.right);
        }
    }

    void preOrderTraversal() {
        preOrderTraversalInternal(this.rootNode);
    }

    private void preOrderTraversalInternal(final RBTreeNode node) {
        if(node != sentinel) {
            System.out.print(node.value+ " ");
            inOrderTraversalInternal(node.left);
            inOrderTraversalInternal(node.right);
        }
    }

    void postOrderTraversal() {
        postOrderTraversalInternal(this.rootNode);
    }

    private void postOrderTraversalInternal(final RBTreeNode node) {
        if(node != sentinel) {
            inOrderTraversalInternal(node.left);
            inOrderTraversalInternal(node.right);
            System.out.print(node.value+ " ");
        }
    }

    RBTreeNode search(int value) {
        return searchInternal(this.rootNode, value);
    }

    private RBTreeNode searchInternal(RBTreeNode node, int value) {
        if(node == this.sentinel || value == node.value) {
            return node;
        }
        if(value < node.value) {
            return searchInternal(node.left, value);
        } else {
            return searchInternal(node.right, value);
        }
    }

    RBTreeNode searchWithoutRecursion(int value) {
        RBTreeNode currentNode = this.rootNode;
        while(currentNode != this.sentinel) {
            if(currentNode == this.sentinel || currentNode.value == value) {
                return currentNode;
            }
            if(value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    RBTreeNode minimum() {
        return minimumInternal(this.rootNode, this.rootNode);
    }

    private RBTreeNode minimumInternal(RBTreeNode node, final RBTreeNode previousNode) {
        if(node == this.sentinel) {
            return previousNode;
        }
        return minimumInternal(node.left, node);
    }

    RBTreeNode maximum() {
        return maximumInternal(this.rootNode, this.rootNode);
    }

    private RBTreeNode maximumInternal(RBTreeNode node, final RBTreeNode previousNode) {
        if(node == this.sentinel) {
            return previousNode;
        }
        return maximumInternal(node.right, node);
    }

    RBTreeNode sucessor(RBTreeNode node) {
        //When there is right node.
        if(node.right != this.sentinel) {
            return minimumInternal(node.right, node.right);
        }
        //When there is no right node.
        RBTreeNode successor = node.parent;
        //Go up until the ancestors are right to it.
        while (successor != this.sentinel && node == successor.right) {
            node = successor;
            successor = successor.parent;
        }
        return successor;
    }

    RBTreeNode predecessor(RBTreeNode node) {
        //When there is right node.
        if(node.left != this.sentinel) {
            return maximumInternal(node.left, node.left);
        }
        //When there is no left node.
        RBTreeNode predecessor = node.parent;
        //Go up until the ancestors until parent's left is same as node.
        while (predecessor != this.sentinel && node == predecessor.left) {
            node = predecessor;
            predecessor = predecessor.parent;
        }

        return predecessor;
    }

    private void rotateLeft(RBTreeNode toBeChild) {

        RBTreeNode toBeParent = toBeChild.right;
        //turn to be parents left subtree to the input node right subtree.
        toBeChild.right = toBeParent.left;
        if(toBeParent.left != sentinel) {
            toBeParent.left.parent = toBeChild;
        }
        toBeParent.parent = toBeChild.parent;
        //Work on changing parent of to be parent
        if(toBeChild.parent == sentinel) {//the input node is root node.
            this.rootNode = toBeParent;
            this.rootNode.parent = sentinel;
        } else if(toBeChild.parent.left == toBeChild) { // The input is left child
            toBeChild.parent.left = toBeParent;
        } else {
            toBeChild.parent.right = toBeParent;
        }
        //Between new left subtree and parent.
        toBeParent.left = toBeChild;
        toBeChild.parent = toBeParent;
    }

    private void rotateRight(RBTreeNode toBeChild) {
        RBTreeNode toBeParent = toBeChild.left;
        //turn the right subtree of to-be-parent into left subtree of parent of to-be-parent.
        toBeChild.left = toBeParent.right;

        if(toBeParent.right != sentinel) {
            toBeParent.right.parent = toBeChild;
        }

        toBeParent.parent = toBeChild.parent;
        //Work on changing parent of to-be-parent from to-be-child
        if(toBeChild.parent == sentinel) {
            this.rootNode = toBeParent;
            this.rootNode.parent = sentinel;
        } else if(toBeChild.parent.left == toBeChild) {
            toBeChild.parent.left = toBeParent;
        } else {
            toBeChild.parent.right = toBeParent;
        }

        //Between new right subtree and new parent.
        toBeParent.right = toBeChild;
        toBeChild.parent = toBeParent;
    }

    void insert(int x) {
        RBTreeNode nodeToAdded = new RBTreeNode();
        nodeToAdded.value = x;
        nodeToAdded.left = this.sentinel;
        nodeToAdded.right = this.sentinel;
        nodeToAdded.color = Color.RED;
        RBTreeNode previous = sentinel;
        RBTreeNode current = this.rootNode;
        while(current != sentinel) {
            previous = current;
            if (nodeToAdded.value > current.value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        nodeToAdded.parent = previous;
        if(previous == sentinel) {
             this.rootNode = nodeToAdded;
            this.rootNode.parent = sentinel;
        } else if(nodeToAdded.value > previous.value) {
            previous.right = nodeToAdded;
        } else {
            previous.left = nodeToAdded;
        }
        //May be there are two consecutive red nodes (or) root node is red.
        rbInsertFixup(nodeToAdded);
    }

    private void rbInsertFixup(RBTreeNode node) {
        //If node is root node then it has to be black.
        if(node ==  this.rootNode) {
            this.rootNode.color = Color.BLACK;
        } else {
            while(node.parent != null && node.parent.color == Color.RED) {
                if(node.parent.parent.left == node.parent) { //Left-Right (or) Left-Left
                    RBTreeNode uncle = node.parent.parent.right;
                    if(uncle.color == Color.RED) {
                        uncle.color = Color.BLACK;
                        node.parent.color = Color.BLACK;
                        if(node.parent.parent != rootNode) {
                            node.parent.parent.color = Color.RED;
                        }
                        node = node.parent.parent;
                    } else { //for left-right (or) left-left. left-right needs two rotations.
                        //This is for left-right rotation.
                        if(node.parent.right == node) {
                            node = node.parent;
                            rotateLeft(node);
                        }
                        //Once left-right is rotated, it becomes left-left. Left-left needs only one right rotation
                        //The following cases handle
                        node.parent.color = Color.BLACK;
                        node.parent.parent.color = Color.RED;
                        rotateRight(node.parent.parent);
                        node = node.parent.parent;
                    }
                } else if(node.parent.parent.right == node.parent) { //Right-Left (or) Right-Right
                    RBTreeNode uncle = node.parent.parent.left;
                    if(uncle.color == Color.RED) {
                        uncle.color = Color.BLACK;
                        node.parent.color = Color.BLACK;
                        if(node.parent.parent != rootNode) {
                            node.parent.parent.color = Color.RED;
                        }
                        node = node.parent.parent;
                    } else { //for right-left (or) right-right. right-left needs two rotations.
                        //This is for right-left rotation.
                        if(node.parent.left == node) {
                            node = node.parent;
                            rotateRight(node);
                        }
                        //One right-right is rotated, it becomes right-right. right-right needs only one left rotation
                        node.parent.color = Color.BLACK;
                        node.parent.parent.color = Color.RED;
                        rotateLeft(node.parent.parent);
                        node = node.parent.parent;
                    }
                }
            }
        }
    }

    private void rbTransplant(RBTreeNode toBeDeleted, RBTreeNode toBeReplacedWith) {
        if(toBeDeleted.parent == this.sentinel) {
            this.rootNode = toBeReplacedWith;
        } else if(toBeDeleted.parent.left == toBeDeleted) {
            toBeDeleted.parent.left = toBeReplacedWith;
        } else {
            toBeDeleted.parent.right = toBeReplacedWith;
        }
        toBeReplacedWith.parent = toBeDeleted.parent;
    }

    void delete(int x) {
        RBTreeNode toBeDeleted = searchWithoutRecursion(x);

        if(toBeDeleted == this.sentinel) {
            throw new RuntimeException("Element not found");
        }
        RBTreeNode nodeUsedForReplacement;
        Color removedOrMovedNodeColor = toBeDeleted.color;

        if(toBeDeleted.left == this.sentinel) {
            nodeUsedForReplacement = toBeDeleted.right;
            rbTransplant(toBeDeleted, toBeDeleted.right);
        } else if(toBeDeleted.right == this.sentinel) {
            nodeUsedForReplacement = toBeDeleted.left;
            rbTransplant(toBeDeleted, toBeDeleted.left);
        } else {
            RBTreeNode successor = minimumInternal(toBeDeleted.right, toBeDeleted.right);
            //If successor color is red and node being removed is black,
            //then rotation and recoloring is not needed.
            removedOrMovedNodeColor = successor.color;
            //Either the successor is right child (or) somewhere left in the
            //left subtree of the right child, the successor position is always
            //filled by right child of the successor.
            nodeUsedForReplacement = successor.right;
            if(successor == toBeDeleted.right) {
                //For tracking to fix the the balance in rb tree.
                nodeUsedForReplacement.parent = successor;
            } else {
                //Successor right should be right of successors parent
                rbTransplant(successor, successor.right);
                // (For deleted nodes right subtree)
                successor.right = toBeDeleted.right;
                successor.right.parent = successor;
            }
            //For replacing toBeDeleted node with successor in toBeDeleted position.
            rbTransplant(toBeDeleted, successor);
            //For deleted nodes left subtree
            successor.left = toBeDeleted.left;
            successor.left.parent = successor;
            successor.color = toBeDeleted.color;
        }
        if(removedOrMovedNodeColor == Color.BLACK) {
            rbDeleteFixUp(nodeUsedForReplacement);
        }
    }


    private void rbDeleteFixUp(RBTreeNode nodeUsedForReplacement) {
        // When the successor right child is:
        // 1. Black and the successor is also black. It is double-black.
        // 2. Black and successor is red. Then it is red-black.
        while(nodeUsedForReplacement != this.rootNode && nodeUsedForReplacement.color == Color.BLACK) {
            if(nodeUsedForReplacement == nodeUsedForReplacement.parent.left) {
                RBTreeNode sibling = nodeUsedForReplacement.parent.right;
                //If nodeUsedForReplacement and sibling is red.
                if(sibling.color == Color.RED) {
                    sibling.color = Color.BLACK;
                    nodeUsedForReplacement.parent.color = Color.BLACK;
                    rotateLeft(nodeUsedForReplacement.parent);
                    //New Sibling of nodeUsedForReplacement after rotation
                    sibling = nodeUsedForReplacement.parent.right;
                }
                // Either you come into this case, the sibling is already black
                // (or) when it is marked black once detected as red.
                // If left and right children of sibling is black.
                if(sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
                    //Mark siblings color red and change the nodeUsedForReplacement as parent of current nodeUsedForReplacement
                    sibling.color = Color.RED;
                    nodeUsedForReplacement = nodeUsedForReplacement.parent;
                  //This means left children of sibling is red
                } else if(sibling.right.color == Color.BLACK) {
                    //Change color of left child of sibling.
                    sibling.left.color = Color.BLACK;
                    //Change sibling coldr.
                    sibling.color = Color.RED;
                    rotateRight(sibling);
                    sibling = nodeUsedForReplacement.parent.right;
                }else if (sibling.right.color == Color.RED) {
                    sibling.color = nodeUsedForReplacement.parent.color;
                    nodeUsedForReplacement.parent.color = Color.BLACK;
                    sibling.right.color = Color.BLACK;
                    rotateLeft(nodeUsedForReplacement.parent);
                    nodeUsedForReplacement = this.rootNode;
                }
            }else if(nodeUsedForReplacement == nodeUsedForReplacement.parent.right) {
                RBTreeNode sibling = nodeUsedForReplacement.parent.left;
                //If nodeUsedForReplacement and sibling is red.
                if(sibling.color == Color.RED) {
                    sibling.color = Color.BLACK;
                    nodeUsedForReplacement.parent.color = Color.BLACK;
                    rotateRight(nodeUsedForReplacement.parent);
                    //New Sibling of nodeUsedForReplacement after rotation
                    sibling = nodeUsedForReplacement.parent.left;
                }
                // Either you come into this case, the sibling is already black
                // (or) when it is marked black once detected as red.
                // If left and right children of sibling is black.
                if(sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
                    //Mark siblings color red and change the nodeUsedForReplacement as parent of current nodeUsedForReplacement
                    sibling.color = Color.RED;
                    nodeUsedForReplacement = nodeUsedForReplacement.parent;
                    //This means right children of sibling is red
                } else if(sibling.left.color == Color.BLACK) {
                    //Change color of left child of sibling.
                    sibling.right.color = Color.BLACK;
                    //Change sibling color
                    sibling.color = Color.RED;
                    rotateLeft(sibling);
                    sibling = nodeUsedForReplacement.parent.left;
                }else if (sibling.left.color == Color.RED) {
                    sibling.color = nodeUsedForReplacement.parent.color;
                    nodeUsedForReplacement.parent.color = Color.BLACK;
                    sibling.left.color = Color.BLACK;
                    rotateRight(nodeUsedForReplacement.parent);
                    nodeUsedForReplacement = this.rootNode;
                }
            }
        }
        //This case typically gets executed
        // 1. when node being deleted has only one child (Left / Right) and node deleted is black.
        // 2. When root node is deleted and node replacing it is automatically colored as black.
        // 3. When the successor is black, successor right child (replacing successor) is red,
        //    then it can be converted to black automatically.
        nodeUsedForReplacement.color = Color.BLACK;
    }
}
