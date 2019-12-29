package Tests;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node_data;
import elements.nodeData;
import gui.Graph_GUI;
import org.junit.jupiter.api.Test;
import utils.Point3D;

public class GAlgoTest {
    @Test
    public void GAlgoTest() {
        graph graph = new DGraph();
        Graph_Algo g = new Graph_Algo();

        node_data n1 = new nodeData(new Point3D(50, 10));
        node_data n2 = new nodeData(new Point3D(10, 10));
        node_data n3 = new nodeData(new Point3D(50, 40));
        node_data n4 = new nodeData(new Point3D(33, 25));
        node_data n5 = new nodeData(new Point3D(10, 40));
        node_data n6 = new nodeData(new Point3D(33, 50));

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.addNode(n6);

        graph.connect(0, 3, 1);
        graph.connect(3, 4, 5);
        graph.connect(4, 5, 1);
        graph.connect(5, 2, 6);
        graph.connect(2, 3, 3);
        graph.connect(3, 1, 4);
        graph.connect(1, 0, 2);
        graph.connect(3, 0, 10);
        g.init(graph);
        System.out.println(g.isConnected());

        graph graph1 = new DGraph();
        Graph_Algo g1 = new Graph_Algo();

        node_data n11 = new nodeData(new Point3D(50, 10));
        node_data n21 = new nodeData(new Point3D(10, 10));

        graph1.addNode(n11);
        graph1.addNode(n21);

        graph1.connect(0, 1, 1);
        graph1.connect(1, 0, 5);

        g1.init(graph1);
        System.out.println(g1.isConnected());
        g.shortestPathToString(g.shortestPath(2, 0));
        g.save("test.txt");
        Graph_Algo t = new Graph_Algo();
        t.init("test.txt");
        t.shortestPathToString(t.shortestPath(0, 1));
    }

    public static void main(String[] args) {
        Graph_GUI gg = new Graph_GUI();
        graph graph = new DGraph();
        Graph_Algo g = new Graph_Algo();

        node_data n1 = new nodeData(new Point3D(-20, -20));
        node_data n2 = new nodeData(new Point3D(40, 40));
        node_data n3 = new nodeData(new Point3D(70, 10));
        node_data n4 = new nodeData(new Point3D(-70, 10));
        node_data n5 = new nodeData(new Point3D(-50, -50));
        node_data n6 = new nodeData(new Point3D(50, -50));
        node_data n7 = new nodeData(new Point3D(0, 0));

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.addNode(n6);
        graph.addNode(n7);

        graph.connect(0, 1, 8);
        graph.connect(0, 2, 9);
        graph.connect(1, 6, 4);
        graph.connect(6, 2, 5);
        graph.connect(2, 3, 1);
        graph.connect(3, 6, 4);
        graph.connect(3, 0, 5);
        graph.connect(6, 5, 6);
        graph.connect(1, 3, 8);
        graph.connect(5, 2, 15);
        graph.connect(5, 3, 14);
        graph.connect(6, 4, 4);
        graph.connect(4, 5, 9);
        graph.connect(4, 3, 5);
        graph.connect(5, 1, 26);
        graph.connect(1, 2, 25);
        graph.connect(6, 0, 5);

        g.init(graph);
        gg.init(graph);
        g.shortestPathToString(g.shortestPath(1, 4));
        gg.drawGraph();
    }
}
