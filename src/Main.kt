import dataStructures.GraphBase
import dataStructures.MultiGraph

fun main() {
    println("Hello World!");

    val G: GraphBase = GraphBase(2);
    G.addEdge(0, 1);
    G.printAdjacencyMatrix();
    println();
    G.addVertex();
    G.printAdjacencyMatrix();
    println();
    G.addVertex(1);
    G.printAdjacencyMatrix();
    println();
    G.addEdge(1 ,3);
    G.printAdjacencyMatrix();

    //val MultiG: MultiGraph = MultiGraph(2);
    // MultiG.addEdge(0, 1);
    println("Stop");
}