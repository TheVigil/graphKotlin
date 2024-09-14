package dataStructures

class MultiGraph(numVertices: Int) : GraphBase(numVertices) {
    override fun addEdge(x: Int, y: Int) {
        super.addEdge(x, y)
    }

    override fun removeEdge(x: Int, y: Int) {
        super.removeEdge(x, y)
    }

    override fun printAdjacencyMatrix() {
        super.printAdjacencyMatrix()
    }

    override fun printNodeAdjacencyList(node: Int) {
        super.printNodeAdjacencyList(node)
    }
}