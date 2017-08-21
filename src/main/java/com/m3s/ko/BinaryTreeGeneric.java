package com.m3s.ko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeGeneric<T extends Comparable<T>> {
    private List<GenericNode<T>> nodeList = new ArrayList<>(1);
    public Display treeDisplay = new Display();

    // Set the constructor to add the root node when instantiated
    public BinaryTreeGeneric (T element) {
        GenericNode<T> root = new GenericNode<T>(element);
        nodeList.add(root);
//        this.addNode(element);
    }

    // Set the constructor to add the elements passed when instantiated
    public BinaryTreeGeneric (T[] elements) {
        addArrayOfNodes(elements);
    }

    // Set the constructor to add the elements passed when instantiated
    public BinaryTreeGeneric (List<T> elements) {
        addListOfNodes(elements);
    }

    // Get the integer value of the node
    public int getNodeValue(GenericNode<T> node) {
        return Integer.parseInt(node.toString());
    }

    // Method to return the root element
    public GenericNode<T> getRootNode() {
        // Get the first element in the node list as the root is always added first
        if (!nodeList.isEmpty()) {
            GenericNode<T> rootNode = nodeList.get(0);
            treeDisplay.printSuccess("The root node was found containing the value " + getNodeValue(rootNode) + ".");
            return rootNode;
        } else {
            treeDisplay.printError("No root node was found.");
            return null;
        }
    }

    // Count the number of nodes in the ndoe list, as every node in the binary search tree is added to the list
    public int getNumberOfNodes() {
        int treeSize = nodeList.size();
        treeDisplay.printSuccess("The number of elements is  " + treeSize + ".");
        return treeSize;
    }

    // Start at the root node when deciding where to add the new element
    public void addNode(T element) {
        GenericNode<T> root = getRootNode();
        setLeaf(element, root);
        treeDisplay.printSuccess("A new node was added with the value of "+ element +".");
    }

    // Method to add multiple nodes to the tree and node list
    private void addNodeFromList(T element) {
        if (nodeList.isEmpty()) {
            nodeList.add(new GenericNode<T> (element));
        } else {
            addNode(element);
        }
    }

    // Method to add multiple nodes to the tree and node list
    public void addArrayOfNodes(T[] elements) {
        for (T value: elements) {
            addNodeFromList(value);
        }
    }

    // Method to add multiple nodes to the tree and node list
    public void addListOfNodes(List<T> elements) {
        for (T value: elements) {
            addNodeFromList(value);
        }
    }

    public GenericNode<T> findNode(T element) {
        if (! nodeList.isEmpty()) {
            GenericNode<T> root = getRootNode();
            // Starting with the root node, compare the nodes to see if the left or right of the node should be checked
            if (element.compareTo(root.element) > 0 && root.right != null) {
                return findNodeRecursive(root.right, element);
            } else if (element.compareTo(root.element) < 0 && root.left != null) {
                return findNodeRecursive(root.left, element);
            } else if (element.compareTo(root.element) == 0) {
               treeDisplay.printNode(root);
                return root;
            } else {
                treeDisplay.printError("The node was not found.");
                return null;
            }
        } else {
            treeDisplay.printError("The binary tree is empty.");
            return null;
        }
    }

    // Recursively find nodes after comparing with the root node
    private GenericNode<T> findNodeRecursive(GenericNode<T> currentNode, T element) {
        if (element.compareTo(currentNode.element) > 0 && currentNode.right != null) {
            return findNodeRecursive(currentNode.right, element);
        } else if (element.compareTo(currentNode.element) < 0 && currentNode.left != null) {
            return findNodeRecursive(currentNode.left, element);
        } else if (element.compareTo(currentNode.element) == 0) {
            treeDisplay.printNode(currentNode);
            return currentNode;
        } else {
            treeDisplay.printError("The node was not found.");
            return null;
        }
    }

    // Find a node in the nodeList (not in the tree) (can be used for testing)
    public GenericNode<T> findNodeInList(T element) {
        if (! nodeList.isEmpty()) {
            GenericNode<T> foundNode = null;
            for (GenericNode<T> node : nodeList) {
                if (element.compareTo(node.element) == 0) {
                    foundNode = node;
                }
            }
            if (foundNode == null) {
                treeDisplay.printNode(foundNode);
                return nodeList.get(nodeList.indexOf(foundNode));
            } else {
                treeDisplay.printError("The node was not found.");
                return null;
            }
        } else {
            treeDisplay.printError("The binary tree is empty.");
            return null;
        }
    }

    // Sort the list of nodes (not the tree)
    public List<GenericNode<T>> getSortedTreeListAsc() {
        List<GenericNode<T>> sorted = nodeList;
        sorted.sort(Comparator.comparing(node -> getNodeValue(node)));
        treeDisplay.printBSTList(sorted);
        return sorted;
    }

    // Sort the list of nodes (not the tree)
    public List<GenericNode<T>> getSortedTreeListDesc() {
        List<GenericNode<T>> sorted = getSortedTreeListAsc();
        Collections.reverse(sorted);
        treeDisplay.printBSTList(sorted);
        return sorted;
    }

    // Recursively sort the tree in ascending order after starting at the root node.
    private List<GenericNode<T>> getSortedTreeAscRecursive(GenericNode<T> current) {
        // If the node is the next node in order return it in an arrayList
        if (current == null) {
            return new ArrayList<>();
        // Recursively call the method on the tree in ascending numerical order
        } else if (current.left != null) {
            ArrayList<GenericNode<T>> resultList = new ArrayList<>();
            resultList.addAll(getSortedTreeAscRecursive(current.left));
            resultList.add(current);
            resultList.addAll(getSortedTreeAscRecursive(current.right));
            return resultList;
        } else if (current.right != null) {
            ArrayList<GenericNode<T>> resultList = new ArrayList<>();
            resultList.add(current);
            resultList.addAll(getSortedTreeAscRecursive(current.right));
            return resultList;
        } else {
            ArrayList<GenericNode<T>> resultList = new ArrayList<>();
            resultList.add(current);
            return resultList;
        }
    }

    public List<GenericNode<T>> getSortedTreeAsc() {
        GenericNode<T> current = getRootNode();
        List<GenericNode<T>> sorted = new ArrayList<>();
        sorted.addAll(getSortedTreeAscRecursive(current.left));
        sorted.add(current);
        sorted.addAll(getSortedTreeAscRecursive(current.right));
        treeDisplay.printBSTList(sorted);
        return sorted;
    }

    // Recursively sort the tree in descending order after starting at the root node.
    private List<GenericNode<T>> getSortedTreeDescRecursive(GenericNode<T> current) {
        // If the node is the next node in order return it in an arrayList
        if (current == null) {
            return new ArrayList<>();
        // Recursively call the method on the tree in descending numerical order
        } else if (current.right != null) {
            ArrayList<GenericNode<T>> resultList = new ArrayList<>();
            resultList.addAll(getSortedTreeDescRecursive(current.right));
            resultList.add(current);
            resultList.addAll(getSortedTreeDescRecursive(current.left));
            return resultList;
        } else if (current.left != null) {
            ArrayList<GenericNode<T>> resultList = new ArrayList<>();
            resultList.add(current);
            resultList.addAll(getSortedTreeDescRecursive(current.left));
            return resultList;
        } else {
            ArrayList<GenericNode<T>> resultList = new ArrayList<>();
            resultList.add(current);
            return resultList;
        }
    }

    public List<GenericNode<T>> getSortedTreeDesc() {
        GenericNode<T> current = getRootNode();
        List<GenericNode<T>> sorted = new ArrayList<>();
        sorted.addAll(getSortedTreeDescRecursive(current.right));
        sorted.add(current);
        sorted.addAll(getSortedTreeDescRecursive(current.left));
        treeDisplay.printBSTList(sorted);
        return sorted;
    }

    // Recursively compare nodes to find the position for the next node to be added to the tree
    private void setLeaf(T element, GenericNode<T> current) {
        if (element.compareTo((T) current.element) > 0) {
            if (current.right != null) {
                setLeaf(element, current.right);
            } else {
                current.right = new GenericNode<T>(element);
                nodeList.add(current.right);
            }
        } else {
            if (current.left != null) {
                setLeaf(element, current.left);
            } else {
                current.left = new GenericNode<T>(element);
                nodeList.add(current.left);
            }
        }
    }

    public void getEmployees() {
        DAO employees = new DAO();
        employees.addEmployees(this);
    }
}
