# **Optimization of a City Transportation Network (Minimum Spanning Tree)**  
### *Assignment 3 — Implementation of Prim’s and Kruskal’s Algorithms*

---

## **Abstract**

This project applies *graph optimization algorithms* to model and minimize the total construction cost of a city transportation network.  
The problem is represented as a **weighted undirected graph**, where:
- vertices represent *city districts*;
- edges represent *potential roads*;
- and edge weights correspond to *construction costs*.

Two classical Minimum Spanning Tree (MST) algorithms — **Prim’s** and **Kruskal’s** — were implemented and compared in terms of:
- total MST cost,  
- number of algorithmic operations, and  
- execution time (milliseconds).  

The implementations were written in **Java (JDK 21)** using **Maven**, and data were exchanged in **JSON** format.

---

## **1. Project Structure**

mst-assignment/
│
├── pom.xml
├── README.md
├── data/
│ ├── ass_3_input.json ← Input data (city graphs)
│ └── ass_3_output.json ← Generated output results
│
└── src/
└── main/java/org/example/mst/
├── Main.java
├── Prim.java
├── Kruskal.java
├── Graph.java
├── Edge.java
├── GraphData.java
├── InputData.java
├── MSTEdge.java
├── GraphResult.java
├── AlgorithmRunResult.java
├── InputStats.java
└── OutputData.java


---

## **2. Problem Definition**

The **City Transportation Network** problem aims to connect all city districts such that:
1. every district is reachable from any other, and  
2. the *total road construction cost* is minimized.  

This corresponds to finding a **Minimum Spanning Tree (MST)**.

---

## **3. Algorithms Overview**

### **Prim’s Algorithm**
- Expands a connected tree by repeatedly adding the smallest edge leaving the current set of vertices.
- Uses a *priority queue* and *adjacency list* for efficient edge selection.
- **Time complexity:** O(E log V)  

### **Kruskal’s Algorithm**
- Sorts all edges by increasing weight and adds them sequentially, avoiding cycles using **Disjoint Set Union (DSU)**.
- **Time complexity:** O(E log E) ≈ O(E log V)

### **Key Implementation Details**
Both algorithms record:
- the final set of MST edges,
- total MST cost,
- number of operations (comparisons, unions, relaxations),
- and runtime in milliseconds.

---

## **4. Data Format**

### **Input (ass_3_input.json)**
Each dataset represents a separate graph:
```json
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D", "E"],
      "edges": [
        { "from": "A", "to": "B", "weight": 4 },
        { "from": "A", "to": "C", "weight": 3 },
        { "from": "B", "to": "C", "weight": 2 },
        { "from": "B", "to": "D", "weight": 5 },
        { "from": "C", "to": "D", "weight": 7 },
        { "from": "C", "to": "E", "weight": 8 },
        { "from": "D", "to": "E", "weight": 6 }
      ]
    }
  ]
}


{
  "results": [
    {
      "graph_id": 1,
      "prim": { "total_cost": 16, "operations_count": 28, "execution_time_ms": 1.73 },
      "kruskal": { "total_cost": 16, "operations_count": 18, "execution_time_ms": 0.61 }
    }
  ]
}


| **Graph ID** | **Vertices (V)** | **Edges (E)** | **Algorithm** | **MST Cost** | **Operations** | **Time (ms)** |
|--------------:|-----------------:|---------------:|---------------|--------------:|----------------:|---------------:|
| 1 | 5 | 7 | Prim | **16** | 28 | 1.73 |
| 1 | 5 | 7 | Kruskal | **16** | 18 | 0.61 |
| 2 | 4 | 5 | Prim | **6** | 20 | 0.03 |
| 2 | 4 | 5 | Kruskal | **6** | 13 | 0.03 |


Observation: Both algorithms produced identical MST costs, confirming correctness.
Kruskal’s algorithm was faster and required fewer operations for smaller graphs.

6. Discussion
Correctness: Both Prim’s and Kruskal’s implementations yield the same minimal total cost, confirming algorithmic validity.
Performance: Kruskal’s approach tends to outperform Prim’s on sparse graphs due to simpler edge sorting and fewer relaxations.
Scalability: Prim’s algorithm is preferable for dense graphs where adjacency lists are large.
Implementation Complexity: Kruskal’s algorithm is conceptually simpler (sorting + union-find).
7. Conclusion
This project demonstrates the application of graph theory and greedy optimization to real-world infrastructure planning.
Both algorithms correctly identify minimal road networks connecting all districts with the lowest total cost.
In general:
Prim’s Algorithm → better for dense networks.
Kruskal’s Algorithm → better for sparse or edge-heavy networks.
8. How to Run the Program
Using IntelliJ IDEA
Open the project and wait for Maven to import dependencies.
Place ass_3_input.json in the /data directory.
Run Main.java — results will be written to /data/ass_3_output.json.

mvn compile
mvn exec:java -Dexec.mainClass="org.example.mst.Main"
