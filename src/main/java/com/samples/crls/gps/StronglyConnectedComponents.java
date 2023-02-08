package com.samples.crls.gps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class StronglyConnectedComponents {

    private Map<String, TopoGraphNode> adjacencyList; //Adjacency Lists
    private int time; // Only used in DFS
    private int connectedComponent;
    private Stack<TopoGraphNode> finishedNodes;

    StronglyConnectedComponents() {
        this.adjacencyList = new TreeMap<>();
        this.time = 0;
        this.connectedComponent = 0;
        this.finishedNodes = new Stack<>();
    }

    void addEdge(String vertextU, String vertextV) {
        addMissingNode(vertextU,  this.adjacencyList);
        addMissingNode(vertextV,  this.adjacencyList);
        this.adjacencyList.get(vertextU).connectedNodes.add(this.adjacencyList.get(vertextV));
    }

    List<String> findStronglyConnectedComponents() {
        Iterator<Map.Entry<String, TopoGraphNode>> coloringIterator = adjacencyList.entrySet().iterator();
        while(coloringIterator.hasNext()) {
            Map.Entry<String, TopoGraphNode> graphNodeEntry = coloringIterator.next();
            graphNodeEntry.getValue().color = GraphColor.WHITE;
        }
        this.time = 0;
        this.connectedComponent = 0;
        Iterator<Map.Entry<String, TopoGraphNode>> dfsTraversalIterator = adjacencyList.entrySet().iterator();

        while(dfsTraversalIterator.hasNext()) {
            Map.Entry<String, TopoGraphNode> graphNodeEntry = dfsTraversalIterator.next();
            if(graphNodeEntry.getValue().color == GraphColor.WHITE) {
                this.connectedComponent += 1;
                graphNodeEntry.getValue().componentNumber = this.connectedComponent;
                dfsTraversal(graphNodeEntry.getValue());
            }
        }
        Map<String, TopoGraphNode> transposedGraph = transpose();
        Iterator<Map.Entry<String, TopoGraphNode>> coloringIterator1 = transposedGraph.entrySet().iterator();
        while(coloringIterator1.hasNext()) {
            Map.Entry<String, TopoGraphNode> graphNodeEntry = coloringIterator1.next();
            graphNodeEntry.getValue().color = GraphColor.WHITE;
        }

        this.time = 0;
        List<String> connectedComponents = new ArrayList<>();
        while(!this.finishedNodes.isEmpty()) {
            TopoGraphNode node = this.finishedNodes.pop();
            TopoGraphNode forDfsTraversal = transposedGraph.get(node.value);
            if(forDfsTraversal.color == GraphColor.WHITE) {
                connectedComponents.add(findConnectedComponents(forDfsTraversal));
            }
        }
        return connectedComponents;
    }

    private String findConnectedComponents(final TopoGraphNode graphNode) {
        this.time += 1;
        graphNode.startTime = this.time;
        graphNode.color = GraphColor.GRAY;
        Stack<TopoGraphNode> depthTracker = new Stack<>();
        depthTracker.push(graphNode);
        StringBuilder  componentNodes = null;
        while(!depthTracker.isEmpty()) {
            TopoGraphNode topOfStackNode = depthTracker.peek();
            //A way to find a back edge (If GRAY and Have a GRAY as connected node. Even if it is self-loop
            TopoGraphNode nextWhiteNodeByDepth = findFirstNeighborBasedOnNodeColor(topOfStackNode, GraphColor.WHITE);
            if(nextWhiteNodeByDepth == null) {
                depthTracker.pop();
                this.time += 1;
                topOfStackNode.endTime = this.time;
                topOfStackNode.color = GraphColor.BLACK;
                if(componentNodes == null) {
                    componentNodes = new StringBuilder(topOfStackNode.value);
                } else {
                    componentNodes.append(',');
                    componentNodes.append(topOfStackNode.value);
                }
            } else {
                this.time += 1;
                nextWhiteNodeByDepth.color = GraphColor.GRAY;
                nextWhiteNodeByDepth.startTime = this.time;
                nextWhiteNodeByDepth.predecessor = topOfStackNode;
                depthTracker.push(nextWhiteNodeByDepth);
            }
        }
        return componentNodes.toString();
    }

    private void dfsTraversal(final TopoGraphNode graphNode) {
        this.time += 1;
        graphNode.startTime = this.time;
        graphNode.color = GraphColor.GRAY;
        Stack<TopoGraphNode> depthTracker = new Stack<>();
        depthTracker.push(graphNode);

        while(!depthTracker.isEmpty()) {
            TopoGraphNode topOfStackNode = depthTracker.peek();
            TopoGraphNode nextWhiteNodeByDepth = findFirstNeighborBasedOnNodeColor(topOfStackNode, GraphColor.WHITE);
            if(nextWhiteNodeByDepth == null) {
                depthTracker.pop();
                this.time += 1;
                topOfStackNode.endTime = this.time;
                topOfStackNode.color = GraphColor.BLACK;
                this.finishedNodes.push(topOfStackNode);
            } else {
                this.time += 1;
                nextWhiteNodeByDepth.color = GraphColor.GRAY;
                nextWhiteNodeByDepth.startTime = this.time;
                nextWhiteNodeByDepth.predecessor = topOfStackNode;
                depthTracker.push(nextWhiteNodeByDepth);
            }
        }
    }

    private static void addMissingNode(String aVertexValue, Map<String, TopoGraphNode> adjacencyList) {
        if(!adjacencyList.containsKey(aVertexValue)) {
            TopoGraphNode topoGraphNode  = new TopoGraphNode();
            topoGraphNode.connectedNodes = new LinkedList<>();
            topoGraphNode.value = aVertexValue;
            adjacencyList.put(aVertexValue, topoGraphNode);
        }
    }

    private TopoGraphNode findFirstNeighborBasedOnNodeColor(TopoGraphNode graphNode, GraphColor graphColor) {
        for(TopoGraphNode topoGraphNode: graphNode.connectedNodes) {
            if(topoGraphNode.color == graphColor) {
                return topoGraphNode;
            }
        }
        return null;
    }

    private Map<String, TopoGraphNode> transpose() {
        Map<String, TopoGraphNode> adjacencyListTransposed = new TreeMap<>();
        Iterator<Map.Entry<String, TopoGraphNode>> sourceGraphIterator = adjacencyList.entrySet().iterator();
        while(sourceGraphIterator.hasNext()) {
            Map.Entry<String, TopoGraphNode> graphNodeEntry = sourceGraphIterator.next();
            for(TopoGraphNode connectedNode: graphNodeEntry.getValue().connectedNodes) {
                addTransposedEdge(connectedNode.value, graphNodeEntry.getKey(), adjacencyListTransposed);
            }
        }
        return adjacencyListTransposed;
    }

    private static void addTransposedEdge(String vertextU, String vertextV, Map<String,
            TopoGraphNode> transopsedAdjacencyList) {
        addMissingNode(vertextU,  transopsedAdjacencyList);
        addMissingNode(vertextV,  transopsedAdjacencyList);
        transopsedAdjacencyList.get(vertextU).connectedNodes.add(transopsedAdjacencyList.get(vertextV));
    }
}
