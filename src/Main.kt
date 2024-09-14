import dataStructures.GraphBase

fun main() {
    println("Hello World!");

    val G: GraphBase = GraphBase(2);
    G.addEdge(0, 1);
    G.printAdjacencyMatrix();
    println();
    G.printNodeAdjacencyList(0);
    G.addEdge(0, 1);
}