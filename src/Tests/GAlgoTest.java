package Tests;

import dataStructure.DGraph;
import dataStructure.graph;
import algorithms.Graph_Algo;
import dataStructure.node_data;
import elements.nodeData;
import gui.Graph_GUI;
import org.junit.jupiter.api.Test;
import utils.Point3D;

import java.util.List;


public class GAlgoTest {
    @Test
    public void init(graph g) {

    }
    @Test
    public void isConnected() throws Exception {
        Graph_GUI gg = new Graph_GUI();
        graph graph = new DGraph();
        Graph_Algo g = new Graph_Algo();

        node_data n1 = new nodeData(new Point3D(-20,-20));
        node_data n2 = new nodeData(new Point3D(0,0));
        node_data n3 = new nodeData(new Point3D(40,20));
        node_data n4 = new nodeData(new Point3D(15,50));


        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);

        graph.connect(0,1,8);
        graph.connect(0,3,9);
        graph.connect(1,2,4);
        graph.connect(2,3,1);
        graph.connect(3,0,4);
        graph.connect(1,0,5);
        g.init(graph);
        gg.init(graph);
        System.out.println(g.isConnected());
        gg.drawGraph();

        //g.init(graph);//bugggy
        //System.out.println(graph.getEdge(3,1).getSrc());
        //System.out.println(g.shortestPathDist(4,1));
        //if(!g.isConnected()){
            //fail("isConnected() doesn't Work!");
       // }else{
      //      System.out.println("isConnected() Works!");
       // }

    }
    public void shortestPathToString(List<node_data> l){
        String ans = "";
        //for(node_data n : l)

    }

}
