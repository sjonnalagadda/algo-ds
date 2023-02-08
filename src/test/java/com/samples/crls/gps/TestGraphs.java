package com.samples.crls.gps;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestGraphs {

    @Test
    public void testEdgesTranspose() {
        Graphs graphs = new Graphs(6);
        graphs.addEdge(1, 2);
        graphs.addEdge(1, 4);

        graphs.addEdge(2, 5);
        graphs.addEdge(3, 6);

        graphs.addEdge(3, 5);
        graphs.addEdge(4, 2);

        graphs.addEdge(5, 4);
        graphs.addEdge(6, 6);
        LinkedList<Integer>[] transposedAdjacencyList =  graphs.transpose();
        for(int i=1 ; i<transposedAdjacencyList.length; i++) {
            for(int vertex: transposedAdjacencyList[i]) {
                System.out.println(i + "-->"+ vertex);
            }
        }
    }

    @Test
    public void testMultigraphToUndirectedGraph() {
        Graphs graphs = new Graphs(6);
        graphs.addEdge(1, 2);
        graphs.addEdge(1, 5);
        graphs.addEdge(1, 5);
        graphs.addEdge(1, 6);
        graphs.addEdge(1, 6);
        graphs.addEdge(1, 6);

        graphs.addEdge(2, 1);
        graphs.addEdge(2, 2);
        graphs.addEdge(2, 3);
        graphs.addEdge(2, 6);


        graphs.addEdge(3, 3);
        graphs.addEdge(3, 4);
        graphs.addEdge(3, 6);
        graphs.addEdge(3, 6);

        graphs.addEdge(4, 3);
        graphs.addEdge(4, 4);
        graphs.addEdge(4, 5);
        graphs.addEdge(4, 6);
        graphs.addEdge(4, 6);

        graphs.addEdge(5, 1);
        graphs.addEdge(5, 1);
        graphs.addEdge(5, 4);
        graphs.addEdge(5, 6);

        LinkedList<Integer>[] transposedAdjacencyList =  graphs.createUndirectedGraphFromMultigraph();
        for(int i=1 ; i<transposedAdjacencyList.length; i++) {
            for(int vertex: transposedAdjacencyList[i]) {
                System.out.println(i + "-->"+ vertex);
            }
        }
    }
}
