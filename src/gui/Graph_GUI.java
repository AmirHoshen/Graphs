package gui;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.node_data;
import elements.nodeData;
import utils.Point3D;
import utils.StdDraw;

import java.util.Collection;

public class Graph_GUI {

    DGraph g = new DGraph();


    public void addVertex(nodeData n){
        g.addNode(n);
    }

    public void drawGraph(){
        try{
            if(g.getV()!=null){
                StdDraw.setCanvasSize(800,800);
                StdDraw.setXscale(-100,100);
                StdDraw.setYscale(-100,100);

                drawEdges();
                drawVertex();
            }

        }catch(Exception e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    private void drawVertex() {
        try{
            Collection<node_data> vertex = g.getV();
            for (node_data a: vertex) {
                double x = a.getLocation().x();
                double y = a.getLocation().y();
                StdDraw.setPenRadius(0.006);
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.point(x,y);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void drawEdges() {
        Collection<node_data> vertex = g.getV();
        for(node_data a: vertex) {
            nodeData tmp = (nodeData)a;
            Collection<edge_data> edge = g.getE(a.getKey());
            for(edge_data e: edge){
                double src_x = a.getLocation().x();
                double src_y = a.getLocation().y();
                double dest_x = g.getNode(e.getDest()).getLocation().x();
                double dest_y = g.getNode(e.getDest()).getLocation().y();
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(StdDraw.YELLOW);
                StdDraw.line(src_x,src_y,dest_x,dest_y);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Graph_GUI gg = new Graph_GUI();

        Point3D p = new Point3D(1,5,0);
        Point3D p1 = new Point3D(10,15);
        Point3D p2 = new Point3D(20,25);
        Point3D p3 = new Point3D(30,35);
        Point3D p4 = new Point3D(15,10);


        nodeData a = new nodeData(p,1);
        nodeData b = new nodeData(p1,10);
        nodeData c = new nodeData(p2,12);
        nodeData d = new nodeData(p3,22);
        nodeData e = new nodeData(p4,16);


        gg.addVertex(a);
        gg.addVertex(b);
        gg.addVertex(c);
        gg.addVertex(d);
        gg.addVertex(e);

        gg.g.connect(a.getKey(),b.getKey(),12);
        gg.g.connect(b.getKey(),c.getKey(),12);
        gg.g.connect(c.getKey(),d.getKey(),12);
        gg.g.connect(d.getKey(),e.getKey(),12);

        gg.drawGraph();










        System.out.println("g.connect(p1)");


    }
}
