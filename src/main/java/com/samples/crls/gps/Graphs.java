package com.samples.crls.gps;

import java.util.LinkedList;

public class Graphs {
    private int vertices;   // No. of vertices
    private LinkedList<Integer> adjacencyList[]; //Adjacency Lists

    Graphs(int vertices) {
        this.vertices = ++vertices;
        this.adjacencyList = new LinkedList[this.vertices];
        for(int i=1;i<this.vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int vertextU,int vertexV){
        this.adjacencyList[vertextU].add(vertexV);
    }

    LinkedList<Integer>[] transpose() {
        LinkedList<Integer>[] transposedAdjacencyList = new LinkedList[this.vertices];
        for(int i=1;i<this.vertices; i++) {
            transposedAdjacencyList[i] = new LinkedList<>();
        }

        for(int i=1;i<this.vertices; i++) {
            for(int vertex: this.adjacencyList[i]) {
                transposedAdjacencyList[vertex].add(i);
            }
        }
        return transposedAdjacencyList;
    }

    LinkedList<Integer>[] createUndirectedGraphFromMultigraph() {
        LinkedList<Integer>[] transposedAdjacencyList = new LinkedList[this.vertices];
        for(int i=1;i<this.vertices; i++) {
            transposedAdjacencyList[i] = new LinkedList<>();
        }

        for(int i=1;i<this.vertices; i++) {
            int duplicateVertexChecker = 0;
            for(int vertex: this.adjacencyList[i]) {
                if(i != vertex && duplicateVertexChecker != vertex) {
                    transposedAdjacencyList[vertex].add(i);
                    duplicateVertexChecker = vertex;
                }
            }
        }
        return transposedAdjacencyList;
    }
}
