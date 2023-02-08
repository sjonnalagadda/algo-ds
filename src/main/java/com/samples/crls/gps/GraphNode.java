package com.samples.crls.gps;

import java.util.List;

enum GraphColor {
    WHITE,
    GRAY,
    BLACK
}
public class GraphNode {
    int value;
    GraphColor color;
    int distance;
    int startTime;
    int endTime;
    int componentNumber;
    GraphNode predecessor;
    List<GraphNode> connectedNodes;
}
