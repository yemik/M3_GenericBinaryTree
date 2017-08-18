package com.m3s.ko;

public class GenericNode<T> {

    T element;
    GenericNode<T> left;
    GenericNode<T> right;

    GenericNode (T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
