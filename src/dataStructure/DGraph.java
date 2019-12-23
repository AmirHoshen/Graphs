package dataStructure;

import dataStructure.node_data;
import dataStructure.edge_data;
import elements.edgeData;
import elements.nodeData;
import org.w3c.dom.Node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph, Serializable {
    private static HashMap<Integer, node_data> _allNodes = new HashMap<>();
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
            nodeData tmp = (nodeData) _allNodes.get(src);
            return tmp.edgesOf().get(dest);
        }
        System.out.println("getEdge: Destination vertex or Source vertex dont exist");
        return null;
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
                nodeData tmp = (nodeData) _allNodes.get(src);
                if (!tmp._edge.containsKey(dest)) {
                    edgeData ed = new edgeData(src, dest, w);
                    tmp.addEdge(ed);
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
        nodeData tmp = (nodeData) _allNodes.get(node_id);
        Collection<edge_data> edgeList = new ArrayList<edge_data>();
        edgeList.addAll(tmp._edge.values());
        return edgeList;
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
            nodeData tmp = (nodeData) _allNodes.get(key);
            int counter = tmp._edge.size();
            edgeSize -= counter;
            tmp._edge.clear();
            for (node_data nd : _allNodes.values()) {
                nodeData tmp2 = (nodeData) nd;
                if (tmp2._edge.containsKey(key)) {
                    tmp2._edge.remove(key);
                    edgeSize++;
                }
            }
            _mc++;
            return _allNodes.remove(key);
        } else {
            System.out.println("key doesnt exist");
            return null;
        }
    }

    @Override
    public edge_data removeEdge(int src, int dest) {
        if(_allNodes.containsKey(src)&&_allNodes.containsKey(dest)){
            nodeData tmp = (nodeData)_allNodes.get(src);
            if(tmp._edge.containsKey(dest)){
                edgeSize--;
                return tmp._edge.remove(dest);
            }else{
                System.out.println("Edge not exist");
            }
        }else{
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

}
