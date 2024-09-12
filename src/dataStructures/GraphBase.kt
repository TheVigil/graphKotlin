package dataStructures

class GraphBase (numVerticies: Int) {

    val adjacencyMatrix = mutableListOf<MutableList<Boolean>>();

    init {
        for(i in 0..<numVerticies){
            // initial population of the adjMatr with false, because we do not know if there are edges at the given
            // positions
            val x = i;
            adjacencyMatrix.add(i, MutableList<Boolean>(numVerticies){false});
        }
    }
    // TODO: account for multigraphs, digraphs, and undirected graphs. The relationship here only holds for an
    //  undirected graph (abstract method by graph type)
    fun addEdge(x: Int, y: Int){
        // add an edge for a given vertex pair (V0, V1)
        this.adjacencyMatrix[x][y] = true;
        this.adjacencyMatrix[y][x] = true;
    }

    fun removeEdge(x: Int, y: Int){
        // remove the edge between a give vertex pair (V0, V1)
        this.adjacencyMatrix[x][y] = false;
    }

    fun printAdjacencyMatrix()
    {
        for (verticesList in adjacencyMatrix)
        {
            val x = this.adjacencyMatrix.indexOf(verticesList);
            var y : Int;
            val sb: StringBuilder = StringBuilder();
            sb.append("$x: [")
            for (adjacency in verticesList)
            {
                y = verticesList.indexOf(adjacency);
                sb.append(y.toString() +": " + this.adjacencyMatrix[x][y].toString() + ", ");

            }
            // cleanup trailing comma and whitespace
            sb.deleteRange(sb.lastIndex - 1, sb.lastIndex +1);
            sb.append("]");
            println(sb);
        }
    }

    fun printNodeAdjacencyList(node: Int){
        // print the adjacency list for the node given by its index
        val sb: StringBuilder = StringBuilder();
        sb.append("$node: [");

        for(neighbor in this.adjacencyMatrix[node]){
            val idx = this.adjacencyMatrix[node].indexOf(neighbor);
            sb.append("$idx: $neighbor, ");
        }

        // clean up trailing whitespace and comma
        sb.deleteRange(sb.lastIndex - 1, sb.lastIndex + 1);
        sb.append("]");
        println(sb);
    }
}