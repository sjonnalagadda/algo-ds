package com.samples.crls.ds;


public class BSTree {

    TreeNode rootNode;

    void inOrderTraversal() {
        inOrderTraversalInternal(this.rootNode);
    }

    private void inOrderTraversalInternal(final TreeNode node) {
        if(node != null) {
            inOrderTraversalInternal(node.left);
            System.out.print(node.value+ " ");
            inOrderTraversalInternal(node.right);
        }
    }

    void inOrderTraversalWithoutRecursion() {
        TreeNode currentNode = this.rootNode;
        TreeNode previousNode = currentNode;
        while (currentNode != null) {
            //Leaf node (or) only one node
            if(currentNode.left == null && currentNode.right == null) {
                System.out.print(currentNode.value+ " ");
                previousNode = currentNode;
                currentNode = currentNode.parent;
            } else if (currentNode.left == previousNode) {
                //Print parent
                System.out.print(currentNode.value+ " ");
                previousNode = currentNode;
                if(currentNode.right == null) {
                    currentNode = currentNode.parent;
                } else {
                    currentNode = currentNode.right;
                }
            } else if (currentNode.right == previousNode) {
                //Print parent
                if(currentNode.left == null) {
                    System.out.print(currentNode.value+ " ");
                }
                //Move to parents parent
                previousNode = currentNode;
                currentNode = currentNode.parent;
            } else if(currentNode.left != null && previousNode != currentNode.left) {
                previousNode = currentNode;
                currentNode = currentNode.left;
            } else if(currentNode.right != null && previousNode != currentNode.right) {
                previousNode = currentNode;
                currentNode = currentNode.right;
            }
        }
    }

    void preOrderTraversal() {
        preOrderTraversalInternal(this.rootNode);
    }

    private void preOrderTraversalInternal(final TreeNode node) {
        if(node != null) {
            System.out.print(node.value+ " ");
            preOrderTraversalInternal(node.left);
            preOrderTraversalInternal(node.right);
        }
    }

    void preOrderTraversalWithoutRecursion() {
        TreeNode currentNode = this.rootNode;
        TreeNode previousNode = currentNode;
        while (currentNode != null) {
            //Leaf node (or) only one node
            if(currentNode.left != previousNode && currentNode.right != previousNode) {
                System.out.print(currentNode.value+ " ");
                previousNode = currentNode;
                if(currentNode.left != null) {
                    currentNode = currentNode.left;
                } else if(currentNode.right != null){
                    currentNode = currentNode.right;
                } else {
                    currentNode = currentNode.parent;
                }
            } else if (currentNode.left == previousNode) {
                previousNode = currentNode;
                if(currentNode.right == null) {
                    currentNode = currentNode.parent;
                } else {
                    currentNode = currentNode.right;
                }
            } else if (currentNode.right == previousNode) {
                //Move to parents parent
                previousNode = currentNode;
                currentNode = currentNode.parent;
            } else if(currentNode.left != null && previousNode != currentNode.left) {
                previousNode = currentNode;
                currentNode = currentNode.left;
            } else if(currentNode.right != null && previousNode != currentNode.right) {
                previousNode = currentNode;
                currentNode = currentNode.right;
            }
        }
    }

    void postOrderTraversal() {
        postOrderTraversalInternal(this.rootNode);
    }

    private void postOrderTraversalInternal(final TreeNode node) {
        if(node != null) {
            postOrderTraversalInternal(node.left);
            postOrderTraversalInternal(node.right);
            System.out.print(node.value+ " ");
        }
    }

    void postOrderTraversalWithoutRecursion() {
        TreeNode currentNode = this.rootNode;
        TreeNode previousNode = currentNode;
        while (currentNode != null) {
            //Leaf node (or) only one node
            if(currentNode.left == null && currentNode.right == null) {
                System.out.print(currentNode.value+ " ");
                previousNode = currentNode;
                currentNode = currentNode.parent;
            } else if (currentNode.left == previousNode) {
                previousNode = currentNode;
                if(currentNode.right == null) {
                    currentNode = currentNode.parent;
                } else {
                    currentNode = currentNode.right;
                }
            } else if (currentNode.right == previousNode) {
                //Move to parents parent
                System.out.print(currentNode.value+ " ");
                previousNode = currentNode;
                currentNode = currentNode.parent;
            } else if(currentNode.left != null && previousNode != currentNode.left) {
                previousNode = currentNode;
                currentNode = currentNode.left;
            } else if(currentNode.right != null && previousNode != currentNode.right) {
                previousNode = currentNode;
                currentNode = currentNode.right;
            }
        }
    }

    TreeNode search(int value) {
        return searchInternal(this.rootNode, value);
    }

    private TreeNode searchInternal(TreeNode node, int value) {
        if(node == null || value == node.value) {
            return node;
        }
        if(value < node.value) {
            return searchInternal(node.left, value);
        } else {
            return searchInternal(node.right, value);
        }
    }

    TreeNode searchWithoutRecursion(int value) {
        TreeNode currentNode = this.rootNode;
        while(currentNode != null) {
            if(currentNode == null || currentNode.value == value) {
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

    TreeNode minimum() {
        return minimumInternal(this.rootNode, this.rootNode);
    }

    private TreeNode minimumInternal(TreeNode node, final TreeNode previousNode) {
        if(node == null) {
            return previousNode;
        }
        return minimumInternal(node.left, node);
    }

    TreeNode minimumWithoutRecursion() {
        TreeNode currentNode = this.rootNode;
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    TreeNode maximum() {
        return maximumInternal(this.rootNode, this.rootNode);
    }

    private TreeNode maximumInternal(TreeNode node, final TreeNode previousNode) {
        if(node == null) {
            return previousNode;
        }
        return maximumInternal(node.right, node);
    }

    TreeNode maximumWithoutRecursion() {
        TreeNode currentNode = this.rootNode;
        while(currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    TreeNode sucessor(TreeNode node) {
        //When there is right node.
        if(node.right != null) {
            return minimumInternal(node.right, node.right);
        }
        //When there is no right node.
        TreeNode successor = node.parent;
        //Go up until the ancestors are right to it.
        while (successor != null && node == successor.right) {
            node = successor;
            successor = successor.parent;
        }
        return successor;
    }

    TreeNode predecessor(TreeNode node) {
        //When there is right node.
        if(node.left != null) {
            return maximumInternal(node.left, node.left);
        }
        //When there is no left node.
        TreeNode predecessor = node.parent;
        //Go up until the ancestors until parent's left is same as node.
        while (predecessor != null && node == predecessor.left) {
            node = predecessor;
            predecessor = predecessor.parent;
        }

        return predecessor;
    }


    void insert(int x) {
        TreeNode aNode = new TreeNode();
        aNode.value = x;
        TreeNode previous = null;
        TreeNode current = this.rootNode;
        while (current != null) {
            previous = current;
            if( aNode.value > current.value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        //Assigning parent
        aNode.parent = previous;
        //In case as root node
        if(previous == null) {
            this.rootNode = aNode;
        } else if (aNode.value > previous.value) {
            previous.right = aNode;
        } else {
            previous.left = aNode;
        }
    }

    private void transplant(TreeNode toBeDeleted, TreeNode tobeMoved) {
        //Root node
        if(toBeDeleted.parent == null) {
            this.rootNode = tobeMoved;
        //If to be deleted to left of it's parent
        } else if(toBeDeleted.parent.left == toBeDeleted) {
            toBeDeleted.parent.left = tobeMoved;
            //If to be deleted is to right of it's parent
        } else {
            toBeDeleted.parent.right = tobeMoved;
        }
        if(tobeMoved != null) {
            tobeMoved.parent = toBeDeleted.parent;
        }
    }

    void delete(int x) {
        TreeNode toBeDeleted = searchWithoutRecursion(x);
        if(toBeDeleted == null) {
            throw new RuntimeException("No node found");
        }
        //When there is only right node
        if (toBeDeleted.left == null) {
            transplant(toBeDeleted, toBeDeleted.right);
        //When there is only left node
        }else if(toBeDeleted.right == null) {
            transplant(toBeDeleted, toBeDeleted.left);
        //When there are both nodes
        } else {
            TreeNode sucessor = minimumInternal(toBeDeleted.right, toBeDeleted.right);
            //When successor is not immediate, move the right child of successor to successor's posiiton
            //Before moving successor to original position.
            if (sucessor.parent != toBeDeleted) {
                transplant(sucessor, sucessor.right);
                sucessor.right = toBeDeleted.right;
                sucessor.right.parent = sucessor;
            }
            //Trasn
            transplant(toBeDeleted, sucessor);
            sucessor.left = toBeDeleted.left;
            sucessor.left.parent = sucessor;
        }
    }

}
