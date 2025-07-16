package Graphs.practise;

import java.util.*;

public class _04_BFS_Practise01 {

    static class Graph {
        Map<Integer, List<Integer>> adjList;
        int noOfNodes;

        public Graph(int noOfNodes){
            this.noOfNodes = noOfNodes;
            adjList = new HashMap<>();
        }

        void addEdge(int nodeOne, int nodeTwo){
            adjList.putIfAbsent(nodeOne, new ArrayList<>());
            adjList.get(nodeOne).add(nodeTwo);

            adjList.putIfAbsent(nodeTwo, new ArrayList<>());
            adjList.get(nodeTwo).add(nodeOne);
        }

        void bfsTraversal(int sourceNode){
            int[] visitedArray = new int[noOfNodes+1];
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(sourceNode);
            visitedArray[sourceNode] = 1;

            while(!queue.isEmpty()){

                int node = queue.poll();

                System.out.print(node + " ");

                for(int neighbour : adjList.get(node)){
                    if(visitedArray[neighbour] == 0){
                        visitedArray[neighbour] = 1;
                        queue.offer(neighbour);
                    }
                }

            }
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter no. of nodes: ");
        int nodes = input.nextInt();

        Graph graph = new Graph(nodes);

        System.out.print("Enter no. of edges: ");
        int edges = input.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter node one: ");
            int nodeOne = input.nextInt();

            System.out.print("Enter node two: ");
            int nodeTwo = input.nextInt();

            graph.addEdge(nodeOne, nodeTwo);
        }

        System.out.print("Please enter the source node to print BFS: ");
        int sourceNode = input.nextInt();

        graph.bfsTraversal(sourceNode);

        input.close();


    }
}
