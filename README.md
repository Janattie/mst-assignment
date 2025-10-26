

# **Optimization of a City Transportation Network (Minimum Spanning Tree)**
### *Assignment 3 — Implementation of Prim’s and Kruskal’s Algorithms*
---

## **1. Abstract**

This project explores graph optimization methods for designing an efficient **city transportation network**.  
The task is modelled as a **Minimum Spanning Tree (MST)** problem on a weighted undirected graph,  
where:
- **Vertices** represent city districts  
- **Edges** represent potential roads  
- **Edge weights** correspond to construction costs  

Two classical algorithms, **Prim’s** and **Kruskal’s**, were implemented in **Java (JDK 21)** using **Maven**.  
Their performance was compared in terms of total cost, number of algorithmic operations, and execution time.

---

## **2. Problem Definition**

The goal is to connect all districts such that:
1. Each district is reachable from any other.  
2. The total road construction cost is minimized.  

This corresponds to finding a **Minimum Spanning Tree (MST)** connecting all vertices with minimal total edge weight.

---

## **3. Methodology**

### 3.1 Prim’s Algorithm
- Expands a connected tree by repeatedly adding the smallest edge leaving the current set of vertices.  
- Utilizes a **priority queue** and **adjacency list** for efficient edge selection.  
- **Time complexity:** O(E log V)

### 3.2 Kruskal’s Algorithm
- Sorts all edges by increasing weight and adds them sequentially, avoiding cycles using a **Disjoint Set Union (DSU)** structure.  
- **Time complexity:** O(E log E) ≈ O(E log V)

### 3.3 Implementation Metrics
For each algorithm execution, the program records:
- The set of edges forming the MST  
- The total MST cost  
- The number of operations (comparisons, unions, relaxations)  
- The execution time in milliseconds  

---

## **4. Data Format**

### 4.1 Input (`ass_3_input.json`)
Each dataset represents one graph:

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
````

### 4.2 Output (`ass_3_output.json`)

Results for both algorithms are saved as:

```json
{
  "results": [
    {
      "graph_id": 1,
      "input_stats": { "vertices": 5, "edges": 7 },
      "prim": { "total_cost": 16, "operations_count": 28, "execution_time_ms": 1.73 },
      "kruskal": { "total_cost": 16, "operations_count": 18, "execution_time_ms": 0.61 }
    },
    {
      "graph_id": 2,
      "input_stats": { "vertices": 4, "edges": 5 },
      "prim": { "total_cost": 6, "operations_count": 20, "execution_time_ms": 0.03 },
      "kruskal": { "total_cost": 6, "operations_count": 13, "execution_time_ms": 0.03 }
    }
  ]
}
```

---

## **5. Experimental Results**

### Table 1. Algorithm Performance Comparison

### Table 1. Detailed Algorithm Performance Comparison

| **Graph ID** | **Graph Type** | **Vertices (V)** | **Edges (E)** | **Algorithm** | **MST Cost** | **Operations Count** | **Execution Time (ms)** | **Relative Efficiency** |
|:-------------:|:---------------|:----------------:|:--------------:|:---------------|:--------------:|:---------------------:|:------------------------:|:------------------------:|
| 1 | Medium Density (5 nodes, 7 edges) | 5 | 7 | Prim | **16** | 28 | 1.73 | Baseline |
| 1 |                                    | 5 | 7 | Kruskal | **16** | 18 | 0.61 | **2.8× faster** |
| 2 | Sparse (4 nodes, 5 edges) | 4 | 5 | Prim | **6** | 20 | 0.03 | Baseline |
| 2 |                                    | 4 | 5 | Kruskal | **6** | 13 | 0.03 | ≈ same performance |

> **Observation:**  
> • Both algorithms produced identical MST costs, confirming correctness.  
> • Kruskal’s algorithm required fewer operations and demonstrated ≈ 2.8× faster execution on medium graphs.  
> • On smaller sparse graphs, performance difference was negligible due to lower computational load.


> **Observation:**
> Both algorithms produced identical MST costs, confirming correctness.
> Kruskal’s algorithm required fewer operations and shorter execution time for smaller graphs.

---

## **6. Discussion**

| **Criterion**             | **Prim’s Algorithm**                                     | **Kruskal’s Algorithm**                             |
| ------------------------- | -------------------------------------------------------- | --------------------------------------------------- |
| Core principle            | Expands MST from one vertex outward using priority queue | Selects smallest edges globally using sorting + DSU |
| Time complexity           | O(E log V)                                               | O(E log E)                                          |
| Best suited for           | Dense graphs                                             | Sparse graphs                                       |
| Implementation complexity | Moderate (priority queue + adjacency list)               | Simpler (sorting + DSU)                             |
| Typical use case          | Graph stored as adjacency list                           | Graph stored as edge list                           |

**Analysis:**

* Both algorithms yielded equal MST costs, confirming mathematical correctness.
* Kruskal’s algorithm is computationally lighter on sparse graphs, since fewer relaxations occur.
* Prim’s performs better on dense graphs when implemented with a Fibonacci or binary heap.

---

## **7. Conclusion**

This study successfully demonstrates how **greedy graph algorithms** can optimize real-world infrastructure design.
Both **Prim’s** and **Kruskal’s** algorithms correctly identified minimal-cost road networks connecting all city districts.

* **Kruskal’s algorithm** proved faster for smaller, sparse graphs.
* **Prim’s algorithm** scales better for dense or adjacency-based representations.

Both are fundamental approaches to network optimization and graph theory applications in transport systems.

---




