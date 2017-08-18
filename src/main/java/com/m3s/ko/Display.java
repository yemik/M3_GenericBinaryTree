package com.m3s.ko;

import java.util.List;

public class Display <T> {
    private TreeLogger log = new TreeLogger();

    public void printBSTList(List<GenericNode<T>> binarySearchTree) {
        String message= "The binary search tree list is: ";
        for (GenericNode<T> node: binarySearchTree) {
            message = message + node.element.toString() + " ";
        }
        log.setTraceMessage(message);
    }

    public void logTraceMessage(String message) {
        log.setTraceMessage(message);
    }

    public void logDebugMessage(String message) {
        log.displayMessage(message);
    }

    public void printError(String errMsg) {
        log.setErrorMessage(errMsg);
    }

    public void printSuccess(String successMsg) {
        log.setTraceMessage("Success: " + successMsg);
    }

    public void printNode(GenericNode<T> node) {
        logTraceMessage("The value of this node is: " + node.toString());
        if (node.left != null) {
            logTraceMessage("The left leaf of this node has the value: " + node.left.toString());
        } else {
            logTraceMessage("There is no left leaf of this node.");
        }
        if (node.right != null) {
            logTraceMessage("The right leaf of this node has the value: " + node.right.toString());
        } else {
            logTraceMessage("There is no right leaf of this node.");
        }
    }
}
