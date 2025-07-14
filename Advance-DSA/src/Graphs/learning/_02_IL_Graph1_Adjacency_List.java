package Graphs.learning;

import java.util.ArrayList;
import java.util.*;


//this is a surface level graph

public class _02_IL_Graph1_Adjacency_List {
    public static class Graph {
        private Map<Integer, ArrayList<Integer>> adjList;
        private int numOfNodes;

        public Graph(int numOfNodes){
            this.numOfNodes = numOfNodes;
            this.adjList = new HashMap<>();
        }

        void addEdge(int node1, int node2){
            adjList.putIfAbsent((node1), new ArrayList<>());
            adjList.get(node1).add(node2);

            adjList.putIfAbsent((node2), new ArrayList<>());
            adjList.get(node2).add(node1);
        }

        void printGraph(){
            for(Map.Entry<Integer, ArrayList<Integer>> entry : adjList.entrySet()){
//                System.out.println("Node " + entry.getKey() + " -> ");
//                for(Integer neighbour: entry.getValue()){
//                    System.out.print(neighbour + " ");
//                }
//                System.out.println();

                Integer node = entry.getKey();
                ArrayList<Integer> neighbour = entry.getValue();
                System.out.println("Node " + node + " -> " + neighbour);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("10-7-2025"); // didn't code
        System.out.println("11-7-2025");

        Graph adjacencyList = new Graph(8);

        adjacencyList.addEdge(0,1);
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(3,4);
        adjacencyList.addEdge(5,6);
        adjacencyList.addEdge(6,7);

        adjacencyList.printGraph();

    }
}
