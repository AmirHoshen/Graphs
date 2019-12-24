package Tests;

import dataStructure.DGraph;
import dataStructure.graph;
import algorithms.Graph_Algo;
import elements.nodeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class GAlgoTest {
    @Test
    public void init(graph g) {

    }
    @Test
    public void isConnected() throws Exception {
        boolean ans = true;
        graph graph = new DGraph();
        Graph_Algo g = new Graph_Algo();
        graph.addNode(new nodeData());
        graph.addNode(new nodeData());
        graph.addNode(new nodeData());
        graph.addNode(new nodeData());

        graph.connect(0,1,8);
        graph.connect(0,3,9);
        graph.connect(1,2,4);
        graph.connect(2,3,1);
        graph.connect(3,0,4);
        graph.connect(1,0,5);
        g.init(graph);
        System.out.println(g.isConnected());
        System.out.println(g.shortestPathDist(0,3));
        //g.init(graph);//bugggy
        //System.out.println(graph.getEdge(3,1).getSrc());
        //System.out.println(g.shortestPathDist(4,1));
        //if(!g.isConnected()){
            //fail("isConnected() doesn't Work!");
       // }else{
      //      System.out.println("isConnected() Works!");
       // }

    }

}
