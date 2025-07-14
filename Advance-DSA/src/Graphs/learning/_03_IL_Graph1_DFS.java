package Graphs.learning;

import java.util.*;

public class _03_IL_Graph1_DFS {

    public static class Graph {
        private Map<Integer, ArrayList<Integer>> adjList;
        private int noOfNodes;
        private int components;


        public Graph(int noOfNodes){
            this.noOfNodes = noOfNodes;
            adjList = new HashMap<>();
        }

        void addEdges(int node1, int node2){
            adjList.putIfAbsent(node1, new ArrayList<>());
            adjList.get(node1).add(node2);

            adjList.putIfAbsent(node2, new ArrayList<>());
            adjList.get(node2).add(node1);
        }

        void dfs(int node, boolean[] visited){
            visited[node] = true;
            System.out.println(node + " ");

            if(adjList.containsKey(node)){
                for(int neighbour : adjList.get(node)){
                    if(visited[neighbour] == false){
                        dfs(neighbour, visited);
                    }
                }
            }
        }

        void printDFS(){
            boolean[] visited = new boolean[noOfNodes];
            int count = 0;
            for(int node = 0; node < noOfNodes; node++){
                if(visited[node] == false){
                    count++;
                    dfs(node, visited);
                }
            }
            components = count;
        }

        void numberOfComponents(){
            System.out.println("No. of components: "+components);
        }

    }
    public static void main(String[] args   ){
        System.out.println("11-07-2025");
        // DFS = Depth First Search

        Graph adjList = new Graph(8);
        adjList.addEdges(0,1);
        adjList.addEdges(1,5);
        adjList.addEdges(1,2);
        adjList.addEdges(2,4);
        adjList.addEdges(2,3);
        adjList.addEdges(3,6);

        adjList.printDFS();
        adjList.numberOfComponents();
    }
}
