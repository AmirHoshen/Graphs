package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.edge_data;
import elements.nodeData;
import utils.Point3D;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 *
 * @author
 */
public class Graph_Algo implements graph_algorithms {
    private graph _graph;

    private Comparator<node_data> comparator = new Comparator<node_data>() {
        @Override
        public int compare(node_data o1, node_data o2) {
            if (o1.getWeight() < o2.getWeight())
                return -1;
            else if (o1.getWeight() > o2.getWeight())
                return 1;
            else
                return 0;
        }
    };

    @Override
    public void init(graph g) {
        this._graph = g;
//        for (node_data n:g.getV()) {
//            _graph.addNode(n);
//            for (edge_data e : g.getE(n.getKey())) {
//                try {
//                    _graph.connect(n.getKey(), e.getDest(), e.getWeight());
//                } catch (Exception ex) {
//                }
//            }
//        }
    }

    @Override
    public void init(String file_name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void save(String file_name) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isConnected() {
        resetVisits();
        boolean ans = true;
        Stack<node_data> stack = new Stack<>();
        stack.addAll(_graph.getV());
        while (!stack.empty()) {
            node_data v = stack.pop();
            if (v.getTag() == -1) {
                v.setTag(1);
                for (node_data e : neighbors(v)) {
                    stack.push(e);
                }
            }
        }
        for (node_data v : _graph.getV())
            if (v.getTag() != 1) {
                ans = false;
                return ans;
            }
        return ans;
    }

    @Override
    public double shortestPathDist(int src, int dest) {//check if src==dest if so return 0
        if (src == dest)
            return 0;
        dijkstra(_graph.getNode(src));
        return _graph.getNode(dest).getWeight();
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        if (src == dest)
            return null;
        ArrayList<node_data> _neighbors = new ArrayList<>();
        for (edge_data e : _graph.getE(src))
            _neighbors.add(_graph.getNode(e.getDest()));
        dijkstra(_graph.getNode(src));
        return _neighbors;
    }

    private Collection<node_data> neighbors(node_data node_data) {
        ArrayList<node_data> temp = new ArrayList<>();
        for (edge_data edge_data : _graph.getE(node_data.getKey()))
            temp.add(_graph.getNode(edge_data.getDest()));
        return temp;
    }

    private void dijkstra(node_data id) {
        resetVisits();
        resetWeights();
        id.setWeight(0);
        PriorityQueue<node_data> priorityQueue = new PriorityQueue<>(comparator);
        for (node_data nd : _graph.getV()) {
            priorityQueue.add(nd);
        }
        while (!priorityQueue.isEmpty()) {
            node_data _temp = priorityQueue.poll();
            for (node_data n : neighbors(_temp)) {//takes one of the neighbors
                double t;
                if (n.getTag() == -1) {
                    t = _temp.getWeight() + _graph.getEdge(_temp.getKey(), n.getKey()).getWeight();//node + edge weight
                    if(n.getWeight()>t){
                        n.setWeight(t);
                        nodeData _tempN = (nodeData)n;
                        ((nodeData) n).set_prev(_temp.getKey());
                    }
                }
            }
            _temp.setTag(1);//visited on the lowest weight
        }
    }

    @Override
    public List<node_data> TSP(List<Integer> targets) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public graph copy() {
        // TODO Auto-generated method stub
        return null;
    }

    public void resetVisits() {
        for (node_data v : _graph.getV())
            v.setTag(-1);
    }

    public void resetWeights() {
        for (node_data v : _graph.getV())
            v.setWeight(Integer.MAX_VALUE);
    }

}
