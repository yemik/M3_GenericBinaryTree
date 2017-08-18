package com.m3s.ko;

import java.util.List;

public interface BinaryTree {
    Employee getRootNode();
    int getNumberOfNodes();
    void addNode(int element);
    Employee findNode(int value);
    List<Employee> getSortedTreeAsc();
    List<Employee> getSortedTreeDesc();
}
