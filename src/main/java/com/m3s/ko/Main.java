package com.m3s.ko;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Employee kodz = new Employee("02", "Kayode", "Oduyemi", 25000);
        BinaryTreeGeneric<Employee> bst = new BinaryTreeGeneric<>(kodz);
        bst.findNode(new Employee("2"));
    }
}
