package gui;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import elements.nodeData;
import utils.Point3D;
import utils.StdDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collection;

public class Graph_GUI {

    DGraph g = new DGraph();
    Graph_Algo g_a = new Graph_Algo();
    public void init(graph g){
        this.g = (DGraph) g;
        g_a.init(g);
    }

    public void init(String file_name) {
        try
        {
            FileInputStream file = new FileInputStream(file_name);
            ObjectInputStream in = new ObjectInputStream(file);
            g = (DGraph)in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized");
        }

        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void save(String file_name) {
        try
        {
            FileOutputStream file = new FileOutputStream(file_name);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(g);
            out.close();
            file.close();

            System.out.println("Object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void addVertex(nodeData n) {
        g.addNode(n);
    }

    public void drawGraph() {
        try {
            if (g.getV() != null) {
                StdDraw.setCanvasSize(800, 800);
                StdDraw.setXscale(-100, 100);
                StdDraw.setYscale(-100, 100);

                //menu bar
                JMenuBar menu = new JMenuBar();


                JMenu file = new JMenu("File");
                menu.add(file);
                JMenuItem save = new JMenuItem("Save");
                JMenuItem load = new JMenuItem("Load");
                file.add(save);
                file.add(load);

                JMenu Algo = new JMenu("Algo");
                menu.add(Algo);
                JMenuItem isCon = new JMenuItem("isConnected");
                JMenuItem tsp = new JMenuItem("TSP");
                JMenuItem sP = new JMenuItem("shortest_Path");
                Algo.add(isCon);
                Algo.add(tsp);
                Algo.add(sP);
///////////////////////////////////////////////////////////////////////bottom definition start
                //actions:
                //save
                ActionListener saveClicked = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FileDialog chooser = new FileDialog(StdDraw.frame, "Use a .png or .jpg extension", FileDialog.SAVE);
                        chooser.setVisible(true);
                        String filename = chooser.getFile();
                        if (filename != null) {
                            StdDraw.save(chooser.getDirectory() + File.separator + chooser.getFile());
                        }
                    }
                };
                save.addActionListener(saveClicked);

                //load:
                ActionListener loadClicked = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FileDialog chooser = new FileDialog(StdDraw.frame, "Use a .png or .jpg extension", FileDialog.LOAD);
                        chooser.setVisible(true);
                        String filename = chooser.getFile();
                        if (filename != null) {
                            ImageIcon icon = new ImageIcon(filename);
                            JLabel label = new JLabel(icon);
                            JFrame f = new JFrame();
                            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            f.getContentPane().add(new JScrollPane(label));
                            f.setSize(StdDraw.frame.getSize().width,StdDraw.frame.getSize().height);
                            f.setLocation(200,200);
                            f.setVisible(true);
                        }
                    }
                };
                load.addActionListener(loadClicked);
////////////////////////////////////////////////////////////////////////
                //algo:
                //isConnected:
                ActionListener isConn = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            g_a.copy(g);
                        } catch (Exception ex) {
                            System.out.println("something went wrong: (Graph_GUI:line:114)");
                            ex.printStackTrace();
                        }
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setPenRadius(0.6);
                        StdDraw.text(-80,80, "is connected: "+g_a.isConnected());
                    }
                };
                isCon.addActionListener(isConn);
                ///////////////////////////////////////////
                //TSP:
                ActionListener TSP = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
                tsp.addActionListener(TSP);

                //////////////////////////////////////////
                //shortestPath
                ActionListener shortPath = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
                sP.addActionListener(shortPath);


///////////////////////////////////////////////////////////////////////////-bottom definition end
                StdDraw.frame.setJMenuBar(menu);


                drawEdges();
                drawVertex();

            }

        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    private void drawVertex() {
        try {
            Collection<node_data> vertex = g.getV();
            for (node_data a : vertex) {
                double x = a.getLocation().x();
                double y = a.getLocation().y();
                StdDraw.setPenRadius(0.03);
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.point(x, y);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void drawEdges() {
        Collection<node_data> vertex = g.getV();
        for (node_data a : vertex) {
            nodeData tmp = (nodeData) a;
            Collection<edge_data> edge = g.getE(a.getKey());
            for (edge_data e : edge) {
                double s_x = a.getLocation().x();
                double s_y = a.getLocation().y();
                double d_x = g.getNode(e.getDest()).getLocation().x();
                double d_y = g.getNode(e.getDest()).getLocation().y();
                //draw the edge between two vertexes
                StdDraw.setPenRadius(0.006);
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(s_x, s_y, d_x, d_y);
                //draw the weight on the middle edge
                StdDraw.setPenRadius(0.3);
                StdDraw.setPenColor(StdDraw.BLACK);
                String weight = Double.toString(e.getWeight());
                StdDraw.text((0.8) * s_x + (0.2) * d_x, (0.8) * s_y + (0.2) * d_y, weight);
            }
        }
    }


    public static void main(String[] args) throws Exception {
//        Graph_GUI gg = new Graph_GUI();
//
//        Point3D p = new Point3D(-50, 50);
//        Point3D p1 = new Point3D(10, 75);
//        Point3D p2 = new Point3D(50, -25);
//        Point3D p3 = new Point3D(-40, -35);
//        Point3D p4 = new Point3D(15, 20);
//
//
//        nodeData a = new nodeData(p);
//        nodeData b = new nodeData(p1);
//        nodeData c = new nodeData(p2);
//        nodeData d = new nodeData(p3);
//        nodeData e = new nodeData(p4);
//
//
//        gg.addVertex(a);
//        gg.addVertex(b);
//        gg.addVertex(c);
//        gg.addVertex(d);
//        gg.addVertex(e);
//
//        gg.g.connect(a.getKey(), c.getKey(), b.getWeight());
//        gg.g.connect(c.getKey(), a.getKey(), c.getWeight());
//        gg.g.connect(a.getKey(), d.getKey(), d.getWeight());
//        gg.g.connect(d.getKey(), e.getKey(), d.getWeight());
//        gg.g.connect(d.getKey(), c.getKey(), a.getWeight());
//        gg.g.connect(d.getKey(), e.getKey(), c.getWeight());
//        gg.g.connect(d.getKey(), b.getKey(), d.getWeight());
//        gg.g.connect(a.getKey(), b.getKey(), e.getWeight());
//        gg.g.connect(b.getKey(), e.getKey(), b.getWeight());
//        gg.g.connect(e.getKey(), b.getKey(), d.getWeight());
//        gg.drawGraph();
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



    }
}
