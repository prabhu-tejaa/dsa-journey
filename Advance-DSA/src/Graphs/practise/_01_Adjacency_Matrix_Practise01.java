package Graphs.practise;

public class _01_Adjacency_Matrix_Practise01 {
    public static class Graph {
        int[][] adjMatrix;
        int noOfNodes;

        public Graph(int noOfNodes){
            this.noOfNodes = noOfNodes;
            adjMatrix = new int[noOfNodes+1][noOfNodes+1];
        }

        void addEdges(int node1, int node2){
            adjMatrix[node1][node2] = 1;
            adjMatrix[node2][node1] = 1;
        }

        void display(){
            for(int i = 0; i <= noOfNodes; i++){
                for(int j = 0; j <= noOfNodes; j++){
                    if(adjMatrix[i][j] == 1){
                        System.out.println(i + " ----> " + j);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Graph adjacencyMatrix = new Graph(6);

        adjacencyMatrix.addEdges(0,1);
        adjacencyMatrix.addEdges(1,2);
        adjacencyMatrix.addEdges(2,3);
        adjacencyMatrix.addEdges(3,4);
        adjacencyMatrix.addEdges(3,6);
        adjacencyMatrix.addEdges(4,5);

        adjacencyMatrix.display();

    }
}
