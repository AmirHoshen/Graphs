package gui;

import dataStructure.DGraph;
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
                StdDraw.setPenRadius(0.04);
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.point(x,y);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void drawEdges() {
    }


    public static void main(String[] args) throws Exception {
        Point3D p = new Point3D(1,5,0);
        nodeData nd = new nodeData(p,1);
        Graph_GUI g = new Graph_GUI();
        g.addVertex(nd);
        g.drawGraph();

    }
}
