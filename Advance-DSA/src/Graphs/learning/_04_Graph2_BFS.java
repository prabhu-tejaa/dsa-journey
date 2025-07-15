package Graphs.learning;

import java.util.*;

public class _04_Graph2_BFS {

    static class Graph {
        Map<Integer,List<Integer>> adjList;
        int noOfNodes;

        public Graph(int noOfNodes){
            this.noOfNodes = noOfNodes;
            adjList = new HashMap<>();
        }

        void addEdges(int nodeOne, int nodeTwo){
            adjList.putIfAbsent(nodeOne, new ArrayList<>());
            adjList.get(nodeOne).add(nodeTwo);

            adjList.putIfAbsent(nodeTwo, new ArrayList<>());
            adjList.get(nodeTwo).add(nodeOne);
        }

        void printBFS(int sourceNode){

            Queue<Integer> queue = new LinkedList<>();
            int[] visited = new int[noOfNodes+1];

            queue.offer(sourceNode);
            visited[sourceNode] = 1;

            while(!queue.isEmpty()){

                int node = queue.poll();
                System.out.print(node + " ");

                for(int neighbour : adjList.get(node)){
                    if(visited[neighbour] == 0){
                        visited[neighbour] = 1;
                        queue.offer(neighbour);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        int nodes, edges, sourceNode;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter no. of nodes: ");
        nodes = input.nextInt();

        Graph graph = new Graph(nodes);

        System.out.print("Enter no. of edges: ");
        edges = input.nextInt();

        for(int i = 0; i < edges; i++){
            int nodeOne, nodeTwo;
            System.out.print("Enter source node: ");
            nodeOne = input.nextInt();
            System.out.print("Enter destination node: ");
            nodeTwo = input.nextInt();
            System.out.println();
            graph.addEdges(nodeOne, nodeTwo);
        }

        System.out.print("Please enter the source node to print BFS: ");
        sourceNode = input.nextInt();

        graph.printBFS(sourceNode);

        input.close();
    }
}
