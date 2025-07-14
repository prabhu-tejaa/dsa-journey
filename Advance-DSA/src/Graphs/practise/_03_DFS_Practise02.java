package Graphs.practise;

import java.util.*;

public class _03_DFS_Practise02 {

    public static class Graph {
        int noOfNodes;
        Map<Integer, ArrayList<Integer>> adjList;
        int components;

        public Graph(int noOfNodes){
            this.noOfNodes = noOfNodes;
            adjList = new HashMap<>();
        }

        void addEdges(int nodeOne, int nodeTwo){
            adjList.putIfAbsent(nodeOne, new ArrayList<Integer>());
            adjList.get(nodeOne).add(nodeTwo);

            adjList.putIfAbsent(nodeTwo, new ArrayList<Integer>());
            adjList.get(nodeTwo).add(nodeOne);
        }

        void dfs(int node, boolean[] visited){
            visited[node] = true;
            System.out.print(node + " ");
            if(adjList.containsKey(node)){
                for(int neighbour : adjList.get(node)){
                    if(!visited[neighbour]){
                        dfs(neighbour, visited);
                    }
                }
            }
        }

        void printDfs(){
            boolean[] visited = new boolean[noOfNodes];
            int count = 0;

            for(int node = 0; node < noOfNodes; node++){
                if(!visited[node]){
                    count++;
                    dfs(node, visited);
                }
                components = count;
            }
        }

        void printNoOfComponents(){
            System.out.println("\nNo. of components: " + components);
        }
    }

    public static void main(String[] args){
        Graph adjacentList = new Graph(5);
        adjacentList.addEdges(0,1);
        adjacentList.addEdges(2,0);
        adjacentList.addEdges(1,2);
        adjacentList.addEdges(3,0);
        adjacentList.addEdges(4,2);

        adjacentList.printDfs();
        adjacentList.printNoOfComponents();

    }
}
