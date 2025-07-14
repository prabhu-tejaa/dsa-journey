package Graphs.learning;

public class _01_Graph1_Adjacency_Matrix {

    public static class Graph {
        private int[][] adjMatrix;
        private int noOfNodes;

        public Graph(int noOfNodes){
            this.noOfNodes = noOfNodes;
            adjMatrix = new int[noOfNodes+1][noOfNodes+1]; // here by default the matrix is filled with 0
        }

        void addEdge(int node1, int node2){
            adjMatrix[node1][node2] = 1; // directed graph
            adjMatrix[node2][node1] = 1; //use up and this for undirected graph
        }

        void printGraph(){
            for(int i = 0; i <= noOfNodes; i++){
                for(int j = 0; j <= noOfNodes; j++){
                    if(adjMatrix[i][j] == 1){
                        System.out.println(i + " ---> " + j);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("09-07-2025"); // didn't code, just watched graphs1 lecture
        System.out.println("10-07-2025");

        Graph g = new Graph(6);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,6);
        g.addEdge(4,5);

        g.printGraph();


    }
}
