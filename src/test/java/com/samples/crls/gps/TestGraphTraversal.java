package com.samples.crls.gps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestGraphTraversal {

    @Test
    public void testBFS() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1, 2);
        graphTraversal.addEdge(1, 5);

        graphTraversal.addEdge(2, 1);
        graphTraversal.addEdge(2, 3);
        graphTraversal.addEdge(2, 4);
        graphTraversal.addEdge(2, 5);

        graphTraversal.addEdge(3, 2);
        graphTraversal.addEdge(3, 4);

        graphTraversal.addEdge(4, 2);
        graphTraversal.addEdge(4, 3);
        graphTraversal.addEdge(4, 5);

        graphTraversal.addEdge(5, 1);
        graphTraversal.addEdge(5, 2);
        graphTraversal.addEdge(5, 4);

        graphTraversal.BFS(1);

    }

    @Test
    public void printPath() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1, 2);
        graphTraversal.addEdge(1, 5);

        graphTraversal.addEdge(2, 1);
        graphTraversal.addEdge(2, 3);
        graphTraversal.addEdge(2, 4);
        graphTraversal.addEdge(2, 5);

        graphTraversal.addEdge(3, 2);
        graphTraversal.addEdge(3, 4);

        graphTraversal.addEdge(4, 2);
        graphTraversal.addEdge(4, 3);
        graphTraversal.addEdge(4, 5);

        graphTraversal.addEdge(5, 1);
        graphTraversal.addEdge(5, 2);
        graphTraversal.addEdge(5, 4);

        graphTraversal.BFS(1);
        graphTraversal.printPathAfterBFS(1, 3);
    }

    @Test
    public void testDFS() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1,2);
        graphTraversal.addEdge(1,4);
        graphTraversal.addEdge(2,3);
        graphTraversal.addEdge(2,4);
        graphTraversal.addEdge(3,4);
        graphTraversal.addEdge(4,2);
        graphTraversal.addEdge(5,3);
        graphTraversal.addEdge(5,6);
        graphTraversal.addEdge(6,6);
        graphTraversal.DFS();
    }

    @Test
    public void testDFSWithStack() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1,2);
        graphTraversal.addEdge(1,4);
        graphTraversal.addEdge(2,3);
        graphTraversal.addEdge(3,4);
        graphTraversal.addEdge(4,2);
        graphTraversal.addEdge(5,3);
        graphTraversal.addEdge(5,6);
        graphTraversal.addEdge(6,6);
        graphTraversal.DFSWithStack();
    }

    @Test
    public void testDFSPrint() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1,2);
        graphTraversal.addEdge(1,4);
        graphTraversal.addEdge(2,3);
        graphTraversal.addEdge(3,4);
        graphTraversal.addEdge(4,2);
        graphTraversal.addEdge(5,3);
        graphTraversal.addEdge(5,6);
        graphTraversal.addEdge(6,6);
        graphTraversal.DFSPrintVisit();
    }

    @Test
    public void testConnectedCompontnentsCount() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.addEdge(1,2);
        graphTraversal.addEdge(1,4);
        graphTraversal.addEdge(2,3);
        graphTraversal.addEdge(3,4);
        graphTraversal.addEdge(4,2);
        graphTraversal.addEdge(5,3);
        graphTraversal.addEdge(5,6);
        graphTraversal.addEdge(6,6);
        graphTraversal.DFS();
    }

    @Test
    public void testDag() {
        DagAndTopologicalSort graphTraversal = new DagAndTopologicalSort();
        graphTraversal.addEdge("u","v");
        graphTraversal.addEdge("u","x");
        graphTraversal.addEdge("v","y");
        graphTraversal.addEdge("y","x");
        //graphTraversal.addEdge("x","v");
        graphTraversal.addEdge("w","y");
        graphTraversal.addEdge("w","z");
        //graphTraversal.addEdge("z","z");
        Assertions.assertTrue(graphTraversal.isGraphAcyclic());
    }

    @Test
    public void testTopologicalSort() {
        DagAndTopologicalSort graphTraversal = new DagAndTopologicalSort();
        graphTraversal.addEdge("undershorts", "pants");
        graphTraversal.addEdge("undershorts", "shoes");
        graphTraversal.addEdge("pants", "shoes");
        graphTraversal.addEdge("pants", "belt");
        graphTraversal.addEdge("belt", "jacket");
        graphTraversal.addEdge("shirt", "tie");
        graphTraversal.addEdge("tie", "jacket");
        graphTraversal.addEdge("shirt", "belt");
        graphTraversal.addEdge("socks", "shoes");
        graphTraversal.addEdge("watch");
        LinkedList<TopoGraphNode> ordereredList = graphTraversal.topologicalSort();
        for(TopoGraphNode graphNode: ordereredList) {
            System.out.println(String.format("%s, %d/%d ",graphNode.value, graphNode.startTime, graphNode.endTime ));
        }
    }

    @Test
    public void testTopologicalSort1() {
        DagAndTopologicalSort graphTraversal = new DagAndTopologicalSort();
        graphTraversal.addEdge("m", "r");
        graphTraversal.addEdge("m", "q");
        graphTraversal.addEdge("m", "x");

        graphTraversal.addEdge("n", "q");
        graphTraversal.addEdge("n", "o");
        graphTraversal.addEdge("n", "u");

        graphTraversal.addEdge("o", "r");
        graphTraversal.addEdge("o", "v");
        graphTraversal.addEdge("o", "s");

        graphTraversal.addEdge("p", "o");
        graphTraversal.addEdge("p", "s");
        graphTraversal.addEdge("p", "z");

        graphTraversal.addEdge("q", "t");
        graphTraversal.addEdge("r", "u");
        graphTraversal.addEdge("r", "y");
        graphTraversal.addEdge("s", "r");
        graphTraversal.addEdge("u", "t");
        graphTraversal.addEdge("v", "w");
        graphTraversal.addEdge("v", "x");

        graphTraversal.addEdge("w", "z");
        graphTraversal.addEdge("y", "v");

        LinkedList<TopoGraphNode> ordereredList = graphTraversal.topologicalSort();
        for(TopoGraphNode graphNode: ordereredList) {
            System.out.println(String.format("%s, %d/%d ",graphNode.value, graphNode.startTime, graphNode.endTime ));
        }
    }

    @Test
    public void testConnectedComponents() {
        StronglyConnectedComponents stronglyConnectedComponents = new StronglyConnectedComponents();
        stronglyConnectedComponents.addEdge("a", "b");

        stronglyConnectedComponents.addEdge("b", "c");
        stronglyConnectedComponents.addEdge("b", "f");
        stronglyConnectedComponents.addEdge("b", "e");

        stronglyConnectedComponents.addEdge("c", "d");
        stronglyConnectedComponents.addEdge("c", "g");

        stronglyConnectedComponents.addEdge("d", "c");
        stronglyConnectedComponents.addEdge("d", "h");

        stronglyConnectedComponents.addEdge("e", "a");
        stronglyConnectedComponents.addEdge("e", "f");
        stronglyConnectedComponents.addEdge("f", "g");
        stronglyConnectedComponents.addEdge("g", "f");
        stronglyConnectedComponents.addEdge("g", "h");
        stronglyConnectedComponents.addEdge("h", "h");
        List<String> connectedComponents = stronglyConnectedComponents.findStronglyConnectedComponents();
        for(String component: connectedComponents) {
            System.out.println(component);
        }
    }
}
