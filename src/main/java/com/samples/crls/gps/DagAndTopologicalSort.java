package com.samples.crls.gps;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class DagAndTopologicalSort {

    private Map<String, TopoGraphNode> adjacencyList; //Adjacency Lists
    private int time; // Only used in DFS
    private int connectedComponent;
    private LinkedList<TopoGraphNode> linearOrder;

    DagAndTopologicalSort() {
        this.adjacencyList = new TreeMap<>();
        this.time = 0;
        this.connectedComponent = 0;
        this.linearOrder = new LinkedList<>();
    }

    void addEdge(String vertextU, String vertextV) {
        addMissingNode(vertextU);
        addMissingNode(vertextV);
        this.adjacencyList.get(vertextU).connectedNodes.add(this.adjacencyList.get(vertextV));
    }

    void addEdge(String vertextU) {
        addMissingNode(vertextU);
    }

    boolean isGraphAcyclic() {
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
                if(!dfsTraversalForFindingAcyclic(graphNodeEntry.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    LinkedList<TopoGraphNode> topologicalSort() {
        Iterator<Map.Entry<String, TopoGraphNode>> coloringIterator = adjacencyList.entrySet().iterator();
        while(coloringIterator.hasNext()) {
            Map.Entry<String, TopoGraphNode> graphNodeEntry = coloringIterator.next();
            graphNodeEntry.getValue().color = GraphColor.WHITE;
        }
        this.time = 0;
        this.connectedComponent = 0;
        this.linearOrder.clear();
        Iterator<Map.Entry<String, TopoGraphNode>> dfsTraversalIterator = adjacencyList.entrySet().iterator();
        while(dfsTraversalIterator.hasNext()) {
            Map.Entry<String, TopoGraphNode> graphNodeEntry = dfsTraversalIterator.next();
            if(graphNodeEntry.getValue().color == GraphColor.WHITE) {
                this.connectedComponent += 1;
                graphNodeEntry.getValue().componentNumber = this.connectedComponent;
                if(!dfsTraversalForFindingAcyclic(graphNodeEntry.getValue())) {
                    throw new RuntimeException("The graph is not acyclic");
                }
            }
        }
        return linearOrder;
    }

    boolean dfsTraversalForFindingAcyclic(final TopoGraphNode graphNode) {
        this.time += 1;
        graphNode.startTime = this.time;
        graphNode.color = GraphColor.GRAY;
        Stack<TopoGraphNode> depthTracker = new Stack<>();
        depthTracker.push(graphNode);
        while(!depthTracker.isEmpty()) {
            TopoGraphNode topOfStackNode = depthTracker.peek();
            //A way to find a back edge (If GRAY and Have a GRAY as connected node. Even if it is self-loop
            TopoGraphNode backEdge = findFirstNeighborBasedOnNodeColor(topOfStackNode, GraphColor.GRAY);
            if(backEdge != null) {
                System.out.println(String.format("(%s, %s) has a back edge",  topOfStackNode.value, backEdge.value));
                return false;
            } else {
                TopoGraphNode nextWhiteNodeByDepth = findFirstNeighborBasedOnNodeColor(topOfStackNode, GraphColor.WHITE);
                if(nextWhiteNodeByDepth == null) {
                    depthTracker.pop();
                    this.time += 1;
                    topOfStackNode.endTime = this.time;
                    topOfStackNode.color = GraphColor.BLACK;
                    linearOrder.addFirst(topOfStackNode);
                } else {
                    this.time += 1;
                    nextWhiteNodeByDepth.color = GraphColor.GRAY;
                    nextWhiteNodeByDepth.startTime = this.time;
                    nextWhiteNodeByDepth.predecessor = topOfStackNode;
                    depthTracker.push(nextWhiteNodeByDepth);
                }
            }
        }
        return true;
    }

    private void addMissingNode(String aVertexValue) {
        if(!this.adjacencyList.containsKey(aVertexValue)) {
            TopoGraphNode topoGraphNode  = new TopoGraphNode();
            topoGraphNode.connectedNodes = new LinkedList<>();
            topoGraphNode.value = aVertexValue;
            this.adjacencyList.put(aVertexValue, topoGraphNode);
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
}
