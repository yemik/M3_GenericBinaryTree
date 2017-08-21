package com.m3s.ko;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple Main.
 */
public class EmployeeTreeTests {
    private BinaryTreeGeneric<Employee> bst;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        Employee bob = new Employee("7", "Bob", "Brandy");
        Employee margaret = new Employee("5", "Margret", "Montague");
        Employee paul = new Employee("12", "Paul", "Paton");
        bst = new BinaryTreeGeneric<>(bob);
        bst.treeDisplay.logDebugMessage("Starting Test " + testName.getMethodName() + ":");
        bst.addNode(margaret);
        bst.addNode(paul);
    }

    @Test
    public void checkAddNode() {
        Employee mandy = new Employee("4", "Mandy", "Mae");
        bst.addNode(mandy);
        assertEquals(4, bst.getNodeValue(bst.getRootNode().left.left));
    }

    @Test
    public void checkLength() {
        assertEquals(3, bst.getNumberOfNodes());
    }

    @Test
    public void checkSortAsc() {
        assertEquals(5, bst.getNodeValue(bst.getSortedTreeAsc().get(0)));
    }

    @Test
    public void checkSortDesc() {
        assertEquals(12, bst.getNodeValue(bst.getSortedTreeDesc().get(0)));
    }

    @Test
    public void checkRootNode() {
        assertEquals(7, bst.getNodeValue(bst.getRootNode()));
    }

    @Test
    public void checkFindNodeRoot() {
        assertEquals(7, bst.getNodeValue(bst.findNode(bst.getRootNode().element)));
    }

    @Test
    public void checkFindNode() {
        assertEquals(12, bst.getNodeValue(bst.findNode(new Employee("12", "Steve","Jobs"))));
    }

    @Test
    public void checkFindNoNode() {
        Employee george = new Employee("50");
        Assert.assertTrue(bst.findNode(george) == null);
    }

    @Test
    public void checkFindNodeSingle() {
        Employee george = new Employee("05");
        Employee dave = new Employee("50");
        BinaryTreeGeneric<Employee> singleNodeTree = new BinaryTreeGeneric<>(george);
        assertEquals(5, singleNodeTree.getNodeValue(singleNodeTree.findNode(george)));
        Assert.assertTrue(singleNodeTree.findNode(dave) == null);
    }

    private void addNodesBoardExample() {
        Employee jim = new Employee("1", "Jim", "Brandy");
        Employee john = new Employee("6", "John", "Montague");
        Employee jill = new Employee("15", "Jill", "Paton");
        Employee[] newNodes = {jim, john, jill};
        bst.addArrayOfNodes(newNodes);
    }
    @Test
    public void checkBoardLeft() {
        addNodesBoardExample();
        assertEquals(1, bst.getNodeValue(bst.findNode(new Employee("5")).left));
    }
    @Test
    public void checkBoardRight() {
        addNodesBoardExample();
        assertEquals(15, bst.getNodeValue(bst.findNode(new Employee("12")).right));
    }
    @Test
    public void checkBoardDescendLeft() {
        addNodesBoardExample();
        assertEquals(6, bst.getNodeValue(bst.getRootNode().left.right));
    }
    @Test
    public void checkBoardDescendRight() {
        addNodesBoardExample();
        assertEquals(15, bst.getNodeValue(bst.getRootNode().right.right));
    }
    @Test
    public void checkBoardDescendLeftNull() {
        addNodesBoardExample();
        Assert.assertTrue(bst.getRootNode().left.right.right == null);
    }
    @Test
    public void checkBoardDescendRightNull() {
        addNodesBoardExample();
        Assert.assertTrue(bst.getRootNode().right.left == null);
    }


    private void addNodesBoardExampleList() {
        Employee jim = new Employee("1", "Jim", "Brandy");
        Employee john = new Employee("6", "John", "Montague");
        Employee jill = new Employee("15", "Jill", "Paton");
        List<Employee> newNodes = new ArrayList<Employee>();
        newNodes.add(jim);
        newNodes.add(john);
        newNodes.add(jill);
        bst.addListOfNodes(newNodes);
    }
    @Test
    public void checkBoardLeftList() {
        addNodesBoardExampleList();
        assertEquals(1, bst.getNodeValue(bst.findNode(new Employee("5")).left));
    }
    @Test
    public void checkBoardRightList() {
        addNodesBoardExampleList();
        assertEquals(15, bst.getNodeValue(bst.findNode(new Employee("12")).right));
    }
    @Test
    public void checkBoardDescendLeftList() {
        addNodesBoardExampleList();
        assertEquals(6, bst.getNodeValue(bst.getRootNode().left.right));
    }
    @Test
    public void checkBoardDescendRightList() {
        addNodesBoardExampleList();
        assertEquals(15, bst.getNodeValue(bst.getRootNode().right.right));
    }
    @Test
    public void checkBoardDescendLeftNullList() {
        addNodesBoardExampleList();
        Assert.assertTrue(bst.getRootNode().left.right.right == null);
    }
    @Test
    public void checkBoardDescendRightNullList() {
        addNodesBoardExampleList();
        Assert.assertTrue(bst.getRootNode().right.left == null);
    }

    @Test
    public void compareLength() {
        Employee jim = new Employee("7", "Jim", "Brandy");
        Employee john = new Employee("5", "John", "Montague");
        Employee jill = new Employee("12", "Jill", "Paton");
        Employee[] initialValues = {jim, john, jill};
        BinaryTreeGeneric<Employee> comparableBST = new BinaryTreeGeneric<>(initialValues);
        assertEquals(bst.getNumberOfNodes(), comparableBST.getNumberOfNodes());
    }

    @Test
    public void compareSortAsc() {
        Employee jim = new Employee("7", "Jim", "Brandy");
        Employee john = new Employee("5", "John", "Montague");
        Employee jill = new Employee("12", "Jill", "Paton");
        Employee[] initialValues = {jim, john, jill};
        BinaryTreeGeneric<Employee> comparableBST = new BinaryTreeGeneric<>(initialValues);
        assertEquals(bst.getNodeValue(bst.getSortedTreeAsc().get(0)), comparableBST.getNodeValue(comparableBST.getSortedTreeAsc().get(0)));
    }

    @Test
    public void compareSortDesc() {
        Employee jim = new Employee("7", "Jim", "Brandy");
        Employee john = new Employee("5", "John", "Montague");
        Employee jill = new Employee("12", "Jill", "Paton");
        Employee[] initialValues = {jim, john, jill};
        BinaryTreeGeneric<Employee> comparableBST = new BinaryTreeGeneric<>(initialValues);
        assertEquals(bst.getNodeValue(bst.getSortedTreeDesc().get(0)), comparableBST.getNodeValue(comparableBST.getSortedTreeDesc().get(0)));
    }

    @Test
    public void compareSortMethodAsc() {
        addNodesBoardExample();
        assertEquals(bst.getNodeValue(bst.getSortedTreeAsc().get(0)), bst.getNodeValue(bst.getSortedTreeListAsc().get(0)));
    }

    @Test
    public void compareSortMethodDesc() {
        addNodesBoardExample();
        assertEquals(bst.getNodeValue(bst.getSortedTreeDesc().get(0)), bst.getNodeValue(bst.getSortedTreeListDesc().get(0)));
    }

    private void addNodes() {
        Employee jim = new Employee("4", "Jim", "Brandy");
        Employee john = new Employee("8", "John", "Montague");
        Employee jill = new Employee("15", "Jill", "Paton");
        Employee[] newNodes = {jim, john, jill};
        bst.addArrayOfNodes(newNodes);
    }
    @Test
    public void checkAddNodeLength() {
        addNodes();
        assertEquals(bst.getNumberOfNodes(), 6);
    }
    @Test
    public void checkAddNodeSortAsc() {
        addNodes();
        assertEquals(4, bst.getNodeValue(bst.getSortedTreeAsc().get(0)));
    }
    @Test
    public void checkAddNodeSortDesc() {
        addNodes();
        assertEquals(15, bst.getNodeValue(bst.getSortedTreeDesc().get(0)));
    }

    private void addEmployees() {
        bst.getEmployees();
    }

    private void getThenAddEmployees() {
        DAO<Employee> dao = new DAO<>();
        List<Employee> employees = dao.getEmployees();
        bst.addListOfNodes(employees);
    }

    private List<Employee> instantiateEmployees() {
        DAO<Employee> dao = new DAO<>();
        return dao.getEmployees();
    }

    @Test
    public void checkEmployeesAdded() {
        addEmployees();
        // Check all 14 employees have been added
        assertEquals(17,bst.getNumberOfNodes());
    }

    @Test
    public void checkMillerHasGreatestID() {
        addEmployees();
        assertEquals(7934, bst.getNodeValue(bst.getSortedTreeDesc().get(0)));
    }

    @Test
    public void checkEmployeesAddedAfterGet() {
        getThenAddEmployees();
        // Check all 14 employees have been added
        assertEquals(17,bst.getNumberOfNodes());
    }

    @Test
    public void checkMillerHasGreatestIDAfterGet() {
        getThenAddEmployees();
        assertEquals(7934, bst.getNodeValue(bst.getSortedTreeDesc().get(0)));
    }

    @Test
    public void checkEmployeesAddedAfterInstantiation() {
        bst = new BinaryTreeGeneric<>(instantiateEmployees());
        // Check all 14 employees have been added
        assertEquals(14,bst.getNumberOfNodes());
    }

    @Test
    public void checkMillerHasGreatestIDAfterInstantiation() {
        bst = new BinaryTreeGeneric<>(instantiateEmployees());
        assertEquals(7934, bst.getNodeValue(bst.getSortedTreeDesc().get(0)));
    }

    @After
    public void cleanUp() {
        bst.treeDisplay.logDebugMessage("End of " + testName.getMethodName() + " test.\n");
    }
}
