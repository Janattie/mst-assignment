package org.example.mst;

import java.util.List;

public class GraphData {
    private int id;
    private List<String> nodes;
    private List<Edge> edges;

    public GraphData() {}

    public GraphData(int id, List<String> nodes, List<Edge> edges) {
        this.id = id;
        this.nodes = nodes;
        this.edges = edges;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<String> getNodes() { return nodes; }
    public void setNodes(List<String> nodes) { this.nodes = nodes; }

    public List<Edge> getEdges() { return edges; }
    public void setEdges(List<Edge> edges) { this.edges = edges; }
}
