package Graphs.practise;

import java.util.*;
public class _03_DFS_Practise01 {

    public static class Graph {
        int noOfNodes;
        Map<Integer, ArrayList<Integer>> adjList;
        int components;

        public Graph(int noOfNodes) {
            this.noOfNodes = noOfNodes;
            adjList = new HashMap<>();
        }

        void addEdges(int nodeOne, int nodeTwo){
            adjList.putIfAbsent(nodeOne, new ArrayList<Integer>());
            adjList.get(nodeOne).add(nodeTwo);

            adjList.putIfAbsent(nodeTwo, new ArrayList<>());
            adjList.get(nodeTwo).add(nodeOne);
        }

        void DFS(int node, boolean[] visitedArray){
            visitedArray[node] = true;
            System.out.println(node + "  ");

            if(adjList.containsKey(node)){
                for(int neighbour : adjList.get(node)){
                    if(!visitedArray[neighbour]){
                        DFS(neighbour, visitedArray);
                    }
                }
            }
        }

        void printDFS(){
            boolean[] visited = new boolean[noOfNodes];
            int count = 0;
            for(int node = 0; node < noOfNodes; node++){
                if(!visited[node]){
                    count++;
                    DFS(node, visited);
                }
                components = count;
            }
        }

        int noOfComponents(){
            return components;
        }
    }
    public static void main(String[] args) {
        System.out.println("14-07-2025");
        /*
        so for dfs we need a ajdList and noOfNode from the user. AjdList means hashMap.

        DFS requires a visited array, to keep track of weather a node is visited during the traversal
         */

        Graph adjacentList = new Graph(6);
        adjacentList.addEdges(0,1);
        adjacentList.addEdges(2,0);
        adjacentList.addEdges(1,2);
        adjacentList.addEdges(3,0);
        adjacentList.addEdges(4,2);

        adjacentList.printDFS();
        System.out.println("no. of components are: " + adjacentList.noOfComponents());
    }
}
