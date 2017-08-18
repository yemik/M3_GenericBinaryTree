package com.m3s.ko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeGeneric<T extends Comparable<T>> {
    private List<GenericNode<T>> nodeList = new ArrayList<>(1);
    public Display treeDisplay = new Display();

    public BinaryTreeGeneric (T element) {
        GenericNode<T> root = new GenericNode<T>(element);
        nodeList.add(root);
//        this.addNode(element);
    }

    public BinaryTreeGeneric (T[] elements) {
        addNodes(elements);
    }

    public int getNodeValue(GenericNode<T> node) {
        return Integer.parseInt(node.toString());
    }

    public GenericNode<T> getRootNode() {
        if (!nodeList.isEmpty()) {
            GenericNode<T> rootNode = nodeList.get(0);
            treeDisplay.printSuccess("The root node was found containing the value " + getNodeValue(rootNode) + ".");
            return rootNode;
        } else {
            treeDisplay.printError("No root node was found.");
            return null;
        }
    }

    public int getNumberOfNodes() {
        int treeSize = nodeList.size();
        treeDisplay.printSuccess("The number of elements is  " + treeSize + ".");
        return treeSize;
    }

    public void addNode(T element) {
        GenericNode<T> root = getRootNode();
        setLeaf(element, root);
        treeDisplay.printSuccess("A new node was added with the value of "+ element +".");
    }

    public void addNodes(T[] elements) {
        for (T value: elements) {
            if (nodeList.isEmpty()) {
                nodeList.add(new GenericNode<T> (value));
            } else {
                addNode(value);
            }
        }
    }

    public GenericNode<T> findNode(T element) {
        if (! nodeList.isEmpty()) {
            GenericNode<T> root = getRootNode();
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

    public List<GenericNode<T>> getSortedTreeListAsc() {
        List<GenericNode<T>> sorted = nodeList;
        sorted.sort(Comparator.comparing(node -> getNodeValue(node)));
        treeDisplay.printBSTList(sorted);
        return sorted;
    }

    public List<GenericNode<T>> getSortedTreeListDesc() {
        List<GenericNode<T>> sorted = getSortedTreeListAsc();
        Collections.reverse(sorted);
        treeDisplay.printBSTList(sorted);
        return sorted;
    }

    private List<GenericNode<T>> getSortedTreeAscRecursive(GenericNode<T> current) {
        if (current == null) {
            return new ArrayList<>();
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

    private List<GenericNode<T>> getSortedTreeDescRecursive(GenericNode<T> current) {
        if (current == null) {
            return new ArrayList<>();
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
}
