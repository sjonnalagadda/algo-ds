package com.samples.crls.gps;

import com.samples.crls.ds.Stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphTraversal {
    private Map<Integer, GraphNode> adjacencyList; //Adjacency Lists
    private int time; // Only used in DFS
    private int connectedComponent;

    GraphTraversal() {
        this.adjacencyList = new HashMap<>();
    }

    void addEdge(int vertextU,int vertexV) {
        createMissingNode(vertextU);
        createMissingNode(vertexV);
        this.adjacencyList.get(vertextU).connectedNodes.add(this.adjacencyList.get(vertexV));
    }

    void BFS(int sourceVertex) {
        //paint all the vertex's other than source vertex as white color
        Iterator<Map.Entry<Integer, GraphNode>> adjacencyIterator = adjacencyList.entrySet().iterator();
        while(adjacencyIterator.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = adjacencyIterator.next();
            if(entry.getKey().equals(sourceVertex)) {
                colorNodes(entry.getValue(), GraphColor.GRAY, 0);
            } else {
                colorNodes(entry.getValue(), GraphColor.WHITE, Integer.MAX_VALUE);
            }

        }
        Queue<GraphNode> queue = new ArrayDeque<>();
        //Put the source vertex in the queue
        queue.add(this.adjacencyList.get(sourceVertex));
        while(!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if(node.connectedNodes != null) {
                for(GraphNode connectedNode: node.connectedNodes) {
                    if(connectedNode.color == GraphColor.WHITE) {
                        connectedNode.color = GraphColor.GRAY;
                        connectedNode.distance = node.distance + 1;
                        connectedNode.predecessor = node;
                        queue.add(connectedNode);
                    }
                }
            }
            //System.out.println(node.value);
            node.color = GraphColor.BLACK;
        }
    }

    void printPathAfterBFS(int sourceVertex, int destinationVertex) {
        if(sourceVertex == destinationVertex) {
            System.out.println(sourceVertex);
            return;
        }
        GraphNode desNode = this.adjacencyList.get(destinationVertex);
        if(desNode.predecessor == null) {
            System.out.println("No path to vertex " + destinationVertex + " exist." );
        }
        else {
            printPathAfterBFS(sourceVertex, desNode.predecessor.value);
            System.out.println(destinationVertex);
        }
    }

    private void createMissingNode(int vertexId) {
        if(this.adjacencyList.get(vertexId) == null) {
            GraphNode graphNode = new GraphNode();
            graphNode.value = vertexId;
            graphNode.connectedNodes = new LinkedList<>();
            this.adjacencyList.put(vertexId, graphNode);
        }
    }
    private void colorNodes(final GraphNode graphNode, GraphColor color, int distance) {
        graphNode.color = color;
        graphNode.distance = distance;
    }

    void DFS() {
        Iterator<Map.Entry<Integer, GraphNode>> itForColoring = adjacencyList.entrySet().iterator();
        while(itForColoring.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = itForColoring.next();
            GraphNode aVertex = entry.getValue();
            aVertex.color = GraphColor.WHITE;
            aVertex.predecessor = null;
        }
        Iterator<Map.Entry<Integer, GraphNode>> itForDfsTraversal = adjacencyList.entrySet().iterator();
        this.time = 0;
        this.connectedComponent = 0;
        while(itForDfsTraversal.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = itForDfsTraversal.next();
            if(entry.getValue().color == GraphColor.WHITE) {
                this.connectedComponent += 1;
                entry.getValue().componentNumber = this.connectedComponent;
                dfsVisit(entry.getValue());
            }
        }
    }

    private void dfsVisit(GraphNode graphNode) {
        this.time += 1;
        graphNode.color = GraphColor.GRAY;
        graphNode.startTime = time;
        if(graphNode.connectedNodes != null) {
            for(GraphNode connectedNode: graphNode.connectedNodes) {
                if(connectedNode.color == GraphColor.WHITE) {
                    connectedNode.predecessor = graphNode;
                    connectedNode.componentNumber = graphNode.componentNumber;
                    dfsVisit(connectedNode);
                }
            }
        }
        graphNode.color = GraphColor.BLACK;
        this.time += 1;
        graphNode.endTime  = this.time;
    }

    void DFSWithStack() {
        Iterator<Map.Entry<Integer, GraphNode>> itForColoring = adjacencyList.entrySet().iterator();
        while(itForColoring.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = itForColoring.next();
            GraphNode aVertex = entry.getValue();
            aVertex.color = GraphColor.WHITE;
            aVertex.predecessor = null;
        }
        Iterator<Map.Entry<Integer, GraphNode>> itForDfsTraversal = adjacencyList.entrySet().iterator();
        this.time = 0;
        while(itForDfsTraversal.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = itForDfsTraversal.next();
            if(entry.getValue().color == GraphColor.WHITE) {
                dfsVisitWithStack(entry.getValue());
            }
        }
    }

    private void dfsVisitWithStack(GraphNode graphNode) {
        this.time += 1;
        graphNode.color = GraphColor.GRAY;
        graphNode.startTime = time;
        java.util.Stack<GraphNode> dfsTraversal = new java.util.Stack<>();
        dfsTraversal.push(graphNode);
        while(!dfsTraversal.isEmpty()) {
            GraphNode currentNode = dfsTraversal.peek();
            GraphNode firstWhiteNeighbor = getFirstWhiteNeighbor(currentNode);
            //Convert the current node to black.
            if(firstWhiteNeighbor == null) {
                currentNode.color = GraphColor.BLACK;
                this.time += 1;
                currentNode.endTime  = this.time;
                dfsTraversal.pop();
            } else {
                firstWhiteNeighbor.color = GraphColor.GRAY;
                this.time += 1;
                firstWhiteNeighbor.startTime  = this.time;
                firstWhiteNeighbor.predecessor = currentNode;
                dfsTraversal.push(firstWhiteNeighbor);
            }
        }
    }

    private GraphNode getFirstWhiteNeighbor(GraphNode currentNode) {
        for(GraphNode connectedNode: currentNode.connectedNodes) {
            if(connectedNode.color == GraphColor.WHITE) {
              return connectedNode;
            }
        }
        return null;
    }

    void DFSPrintVisit() {
        Iterator<Map.Entry<Integer, GraphNode>> itForColoring = adjacencyList.entrySet().iterator();
        while(itForColoring.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = itForColoring.next();
            GraphNode aVertex = entry.getValue();
            aVertex.color = GraphColor.WHITE;
            aVertex.predecessor = null;
        }
        Iterator<Map.Entry<Integer, GraphNode>> itForDfsTraversal = adjacencyList.entrySet().iterator();
        this.time = 0;
        while(itForDfsTraversal.hasNext()) {
            Map.Entry<Integer, GraphNode> entry = itForDfsTraversal.next();
//            if(entry.getValue().color == GraphColor.WHITE) {
                dfsPrintVisit(entry.getValue());
            //}
        }
    }

    private void dfsPrintVisit(GraphNode graphNode) {
        //This is wrong logic.
        this.time += 1;
        graphNode.color = GraphColor.GRAY;
        graphNode.startTime = time;
        for(GraphNode connectedNode: graphNode.connectedNodes) {
            if(connectedNode.color == GraphColor.WHITE) {
                connectedNode.predecessor = graphNode;
                System.out.println(String.format("(%d, %d) is a tree edge", graphNode.value, connectedNode.value));
                dfsVisit(connectedNode);
            } else if(connectedNode.color == GraphColor.GRAY){
                System.out.println(String.format("(%d, %d) is a back edge", graphNode.value, connectedNode.value));
            } else if(connectedNode.startTime > graphNode.startTime){
                System.out.println(String.format("(%d, %d) is a forward edge", graphNode.value, connectedNode.value));
            }else {
                System.out.println(graphNode.color + "  "+ connectedNode.color );
                System.out.println(String.format("(%d, %d) is a cross edge", graphNode.value, connectedNode.value));
            }
        }
        graphNode.color = GraphColor.BLACK;
        this.time += 1;
        graphNode.endTime  = this.time;
    }
}
