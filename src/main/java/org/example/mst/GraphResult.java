package org.example.mst;

public class GraphResult {
    private int graph_id;
    private InputStats input_stats;
    private AlgorithmRunResult prim;
    private AlgorithmRunResult kruskal;

    public int getGraph_id() { return graph_id; }
    public void setGraph_id(int graph_id) { this.graph_id = graph_id; }

    public InputStats getInput_stats() { return input_stats; }
    public void setInput_stats(InputStats input_stats) { this.input_stats = input_stats; }

    public AlgorithmRunResult getPrim() { return prim; }
    public void setPrim(AlgorithmRunResult prim) { this.prim = prim; }

    public AlgorithmRunResult getKruskal() { return kruskal; }
    public void setKruskal(AlgorithmRunResult kruskal) { this.kruskal = kruskal; }
}
