package com.m3s.ko;

public class Employee implements Comparable<Employee> {
    private String id;
    private String firstName;
    private String lastName;
    private int salary;

    Employee(String id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getValue() {
        return new Integer(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
        int employeeValue = employee.getValue();
        if (getValue() > employeeValue) {
             return 1;
        } else if (getValue() < employeeValue) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "" + getValue();
    }

//    @Override
//    public int compareTo(Object employee) {
//        if(!(employee instanceof Employee)){
//            return 0;
//        }
//        int employeeValue=((Employee)employee).getValue();
//        if (getValue() > employeeValue) {
//            return 1;
//        } else if (getValue() < employeeValue) {
//            return -1;
//        }
//        return 0;
//    }
}
