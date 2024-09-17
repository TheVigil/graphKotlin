package dataStructures

class MultiGraph(numVertices: Int) : GraphBase(numVertices) {

    /**
     * Multigraph is implemented as a 3D array instead of a 2D array. Every vertex pair (x, y) now has a mutable list
     * of booleans to represent any edge e_0...e_n between them.
     */
    private val _adjacencyMatrix = mutableListOf<MutableList<MutableList<Boolean>>>();
    private val _numbVertices = numVertices;
    init {
        for (i in 0..<_numbVertices)
        {
            this._adjacencyMatrix.add(i,
                MutableList<MutableList<Boolean>>(_numbVertices){
                    MutableList<Boolean>(_numbVertices){false}
                })
        }
    }

    override fun addVertex(idx: Int) {
        super.addVertex(idx)
    }

    override fun addEdge(x: Int, y: Int) {
        super.addEdge(x, y)
        /**
         * Multiple edges between any vertex pair (x, y) are allowed in a MultiGraph. Simply adding a boolean to the
         * list without accounting for idx position is sufficient here, since we only care about the presence of
         * multiple edges and aren't building any extra relationship between vertexes here.
         */
        this._adjacencyMatrix[x][y].add(y, true);
        this._adjacencyMatrix[x][y].add(x, true);
    }

    override fun removeEdge(x: Int, y: Int) {
        super.removeEdge(x, y)
        /**
         * Simply removing the last element from this edge list suffices, since we only care about the presence of
         * multiple edges, the only important data is how many booleans are in the list and not their idx position
         */
        this._adjacencyMatrix[x][y].removeLast();
        this._adjacencyMatrix[x][y].removeLast();
    }

    override fun printAdjacencyMatrix() {
        super.printAdjacencyMatrix()
        for (verticesList in _adjacencyMatrix)
        {
            val x = this._adjacencyMatrix.indexOf(verticesList);
            var y : Int;
            val sb: StringBuilder = StringBuilder();
            sb.append("$x: [")
            for (adjacency in verticesList)
            {
                y = verticesList.indexOf(adjacency);
                sb.append(y.toString() +": " + this._adjacencyMatrix[x][y].toString() + ", ");

            }
            // cleanup trailing comma and whitespace
            sb.deleteRange(sb.lastIndex - 1, sb.lastIndex +1);
            sb.append("]");
            println(sb);
        }
    }

    override fun printNodeAdjacencyList(node: Int) {
        super.printNodeAdjacencyList(node)
    }
}