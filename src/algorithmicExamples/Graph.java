package algorithmicExamples;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by swetha on 4/25/17.
 */
public class Graph {
    private int numOfVertices;
    private LinkedList<Integer> adjacentList[];

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjacentList = new LinkedList[numOfVertices];
        for(int i = 0 ; i < numOfVertices ; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }

    //add edge to list
    void addEdge(int v, int w) {
        adjacentList[v].add(w);
    }
    // prints BFS traversal from a given source s .. Use Queue
    // Do this till queue is empty
    //1. Start from vertex, mark it visited and add it to Queue
    //2. Print the node, and pop the 1st element (Head)
    //3. Get adj vertices of that node and check if the adj vertices are visited. If they are NOT visited, add it to Queue
//    Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[numOfVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>(); //used to hold all adjacent nodes of a given node .. and pop it once its loop completes

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll(); //retrieves and removes 1st element of the list(head)

            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer n : adjacentList[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //DFS Use stack..to backtrack
    void DFSUtil(int s, boolean visited[]) {
        visited[s] = true;
        System.out.print(s + " ");
        for (Integer n : adjacentList[s]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    //1. Start at vertex, push to stack, print it and mark it visited
    //2. Get adj unvisited nodes. Push to stack. Print. Mark as Visit
    //3. Push only 1 elem to stack(the adj node)
    //4.Once we hit no where to go, pop 1st elem from stack and backtrack
    // Find adj unvisited nodes..
    void DFS(int s) {
        boolean visited[] = new boolean[numOfVertices];
        DFSUtil(s, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        System.out.println("BFS...");
        g.BFS(2);
        System.out.print("\n");
        System.out.println("DFS...");
        g.DFS(2);

    }

}
