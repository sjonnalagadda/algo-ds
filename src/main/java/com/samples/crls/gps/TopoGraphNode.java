package com.samples.crls.gps;

import java.util.List;

public class TopoGraphNode {
    String value;
    List<TopoGraphNode> connectedNodes; // Helps both DFS and BFS
    int distance; // Helps in BFS
    int startTime; // Helps in DFS
    int endTime; //  Helps in DFS
    TopoGraphNode predecessor; // Helps both DFS and BFS
    GraphColor color; // Helps both DFS and BFS
    int componentNumber; // Helps both DFS
}
