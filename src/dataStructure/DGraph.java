package dataStructure;

import elements.edgeData;
import elements.nodeData;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph, Serializable {
    private HashMap<Integer, node_data> _allNodes = new HashMap<>();

    private HashMap<Integer, HashMap<Integer, edge_data>> _allEdges = new HashMap<>();

    private int edgeSize = 0;

    private int _mc = 0;

    @Override
    public node_data getNode(int key) {//because the ID is unique and it is in order if you get the node by key it also
        //gives the node in the order of creation. O(1) easy.
        return _allNodes.get(key);
    }

    @Override
    public edge_data getEdge(int src, int dest) {
        if (_allNodes.containsKey(src) && _allNodes.containsKey(dest)) {
            return _allEdges.get(src).get(dest);
        }
        System.out.println("getEdge: Destination vertex or Source vertex dont exist");
        return null;
    }

    public HashMap<Integer, HashMap<Integer, edge_data>> get_allEdges() {
        return _allEdges;
    }

    public HashMap<Integer, node_data> get_allNodes() {
        return _allNodes;
    }

    @Override
    public void addNode(node_data n) {
        nodeData node = (nodeData) n;
        if (!_allNodes.containsKey(node.getKey())) {
            _mc++;
            _allNodes.put(node.getKey(), n);
        } else {
            System.out.println("vertex is allReady exist");
        }
    }

    @Override
    public void connect(int src, int dest, double w) throws Exception {//this method responsible for creating edge obj and adding them
        if (w <= 0) {
            System.out.println("Bad Weight : Not Connected!");
        } else {
            if (_allNodes.containsKey(src) && _allNodes.containsKey(dest)) {
                edgeData ed = new edgeData(src, dest, w);
                if (!_allEdges.containsKey(src)) {
                    _allEdges.put(src, new HashMap<>());
                    _allEdges.get(src).put(dest, ed);
                    edgeSize++;
                    _mc++;
                } else {
                    _allEdges.get(src).put(dest, ed);
                    edgeSize++;
                    _mc++;
                }
            } else {
                System.out.println("src or dest are Wrong!");
            }
        }
    }

    @Override
    public Collection<node_data> getV() {
        return this._allNodes.values();
    }

    @Override
    public Collection<edge_data> getE(int node_id) {
        return _allEdges.get(node_id).values();
    }

    @Override
    public node_data removeNode(int key) {
        //if it has edges containing the ID = key so remove them all from src and dest O(n)
        //create node and apply to it the node we are about to remove to return it O(1)
        //delete it from node collection O(n)
        //after deletion should refresh drawing with stdDraw and use Connect to see if Connected still.
        //summery : O(n)+O(n)+O(1) = O(n)!
        //_edges.get(key).clear();
        if (_allNodes.containsKey(key)) {
            nodeData _temp = (nodeData) _allNodes.get(key);
            _temp.edgesOf().clear();
            edgeSize -= _allEdges.get(key).size();
            _allEdges.get(key).clear();
            _allEdges.remove(key);
            _mc++;
            return _allNodes.remove(key);
        } else {
            System.out.println("key doesnt exist");
            return null;
        }
    }

    @Override
    public edge_data removeEdge(int src, int dest) {
        if (_allNodes.containsKey(src) && _allNodes.containsKey(dest)) {
            nodeData tmp = (nodeData) _allNodes.get(src);
            tmp.deleteEdge(src, dest);
            if (_allEdges.containsKey(src) && _allEdges.get(src).containsKey(dest)) {
                edgeSize--;
                return _allEdges.get(src).remove(dest);
            } else {
                System.out.println("Edge not exist");
            }
        } else {
            System.out.println("source or destination doesnt exist");
        }
        return null;
    }

    @Override
    public int nodeSize() {
        return _allNodes.size();
    }

    @Override
    public int edgeSize() {
        return this.edgeSize;
    }

    @Override
    public int getMC() {
        return _mc;
    }

    public graph copy(graph g) throws Exception {
        graph _temp = new DGraph();
        for (node_data n : g.getV()) {
            _temp.addNode(n);
        }
        for (node_data n : g.getV()) {
            for (edge_data e : g.getE(n.getKey())) {
                _temp.connect(e.getSrc(), e.getDest(), e.getWeight());
            }
        }
        return _temp;
    }


}
