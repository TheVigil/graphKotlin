package dataStructures

open class GraphBase (numVertices: Int) {

    private val _adjacencyMatrix = mutableListOf<MutableList<Boolean>>();
    private val _numbVertices = numVertices;

    init {
        for(i in 0..<_numbVertices){
            // initial population of the adjMatr with false, because we do not know if there are edges at the given
            // positions
            val x = i;
            _adjacencyMatrix.add(i, MutableList<Boolean>(_numbVertices){false});
        }
    }
    // TODO: account for updating idx -> bool relations to make sure edge definitions remain intact, this currently does not work!
    open fun addVertex(idx: Int = this._adjacencyMatrix.lastIndex + 1){
       // adds a vertex to the graph
        this._adjacencyMatrix.add(idx, MutableList<Boolean>(_numbVertices){false})
    }
    open fun addEdge(x: Int, y: Int){
        // add an edge for a given vertex pair (V0, V1)
        if(this._adjacencyMatrix[x][y] || this._adjacencyMatrix[y][x]){
            println("ERR: a simple graph can only contain one edge between any verticies (x, y). " +
                    "Use a multigraph instead!")

        }
        else{
            this._adjacencyMatrix[x][y] = true;
            this._adjacencyMatrix[y][x] = true;
        }

    }

    open fun removeEdge(x: Int, y: Int){
        // remove the edge between a give vertex pair (V0, V1)
        this._adjacencyMatrix[x][y] = false;
        this._adjacencyMatrix[y][x] = false;
    }

    open fun printAdjacencyMatrix()
    {
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

    open fun printNodeAdjacencyList(node: Int){
        // print the adjacency list for the node given by its index
        val sb: StringBuilder = StringBuilder();
        sb.append("$node: [");

        for(neighbor in this._adjacencyMatrix[node]){
            val idx = this._adjacencyMatrix[node].indexOf(neighbor);
            sb.append("$idx: $neighbor, ");
        }

        // clean up trailing whitespace and comma
        sb.deleteRange(sb.lastIndex - 1, sb.lastIndex + 1);
        sb.append("]");
        println(sb);
    }
}