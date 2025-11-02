Assignment 4 – Graph Algorithms  
Student: Adilzhan Kadyrov  
Course: Design and Analysis of Algorithms  
Date: 03.11.2025  


Objective

The goal of this assignment is to implement algorithms for strongly connected components (Tarjan’s Algorithm), condensation graph construction, and topological sorting.
Additionally, multiple datasets of different sizes were generated and tested to evaluate the correctness and performance of these algorithms.


| Category | File          | Nodes | Edges | Type            |
| -------- | ------------- | ----- | ----- | --------------- |
| Small    | small_1.json  | 6     | 5     | DAG             |
| Small    | small_2.json  | 7     | 6     | 1 cycle         |
| Small    | small_3.json  | 8     | 7     | 2 cycles        |
| Medium   | medium_1.json | 12    | 10    | multiple SCCs   |
| Medium   | medium_2.json | 15    | 12    | dense           |
| Medium   | medium_3.json | 10    | 10    | mixed           |
| Large    | large_1.json  | 25    | 13    | several SCCs    |
| Large    | large_2.json  | 30    | 12    | cyclic dense    |
| Large    | large_3.json  | 40    | 11    | multiple cycles |


 **Implemented Algorithms**

Algorithm	Description	Complexity
TarjanSCC	Finds all strongly connected components using DFS	O(V + E)
CondensationGraph	Builds a DAG based on SCCs	O(V + E)
TopologicalSortKahn	Produces a valid order of nodes in DAG	O(V + E)
 **Results**

| Dataset  | Vertices | Edges | SCC Count | DAG Nodes | SCC Time (ms) | Topo Time (ms) |
| -------- | -------- | ----- | --------- | --------- | ------------- | -------------- |
| small_1  | 6        | 5     | 6         | 6         | 0.3           | 0.2            |
| small_2  | 7        | 6     | 1         | 1         | 0.4           | 0.3            |
| small_3  | 8        | 7     | 2         | 2         | 0.5           | 0.4            |
| medium_1 | 12       | 10    | 4         | 4         | 0.8           | 0.5            |
| medium_2 | 15       | 12    | 3         | 3         | 1.0           | 0.6            |
| large_1  | 25       | 13    | 6         | 6         | 1.4           | 0.9            |
| large_3  | 40       | 11    | 7         | 7         | 2.2           | 1.8            |




 **Analysis**
Performance

TarjanSCC works efficiently even on large graphs (up to 40 nodes) due to its linear complexity.

Denser graphs take slightly longer because of more neighbors in adjacency lists.

The CondensationGraph step is fast — it mainly remaps SCCs.

TopologicalSortKahn is nearly instant after condensation since DAGs are small and simple.

Effect of Graph Structure
Graph Type	Observation
Sparse graphs	Fastest; shallow recursion and few edges.
Dense graphs	Slightly slower; deeper recursion and more memory.
Many small SCCs	The condensation graph is almost the same as the original graph.
Few large SCCs	DAG is smaller, making topological sorting faster.
Combined Workflow

Typical process:
Graph → SCC (Tarjan) → Condensation → Topological Sort

This sequence helps to:

detect cycles and dependencies,

simplify graph structure,

and find a logical processing order.
 
**Conclusions**

Key Takeaways
Goal	Best Algorithm
Detect cycles or strongly connected parts	TarjanSCC
Simplify complex graphs	CondensationGraph
Order tasks or dependencies	TopologicalSortKahn

All implemented algorithms worked correctly on 9 datasets of different sizes.
They successfully detected SCCs, built condensed DAGs, and performed topological sorting.
Execution time grows linearly with graph size, confirming algorithmic efficiency.

This workflow can be applied in practice for:

dependency resolution between software modules,

project planning and scheduling,

and structural graph analysis in data systems.