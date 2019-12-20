package dataStructure;

import elements.edgeData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph {
    private ArrayList<node_data> _nodes;
    private HashMap<Integer,HashMap<Integer,edge_data>> _edges;
    private int edgeSize;
    private int _mc;

    public DGraph() {//empty Graph
        _nodes = new ArrayList<>();
        _edges = new HashMap<>();
        _mc = 0;
    }

    @Override
    public node_data getNode(int key) {//because the ID is unique and it is in order if you get the node by key it also
        //gives the node in the order of creation. O(1) easy.
        return _nodes.get(key);
    }

    @Override
    public edge_data getEdge(int src, int dest) {
        return _edges.get(src).get(dest);
    }

    @Override
    public void addNode(node_data n) {
        _nodes.add(n);
        _mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {//this method responsible for creating edge obj and adding them
        if (w <= 0) {
            System.out.println("Bad Weight : Not Connected!");
        } else {
            if (_nodes.contains(src) && _nodes.contains(dest)) {
                try{
                _edges.put(src,new HashMap<>());
                _edges.get(src).put(dest,new edgeData(src,dest,w));
                }catch (Exception e){
                    System.out.println(e.getCause());
                }
                edgeSize++;
                _mc++;
            }else{
                System.out.println("src or dest are Wrong!");
            }
        }
    }

    @Override
    public Collection<node_data> getV() {
        return this._nodes;
    }

    @Override
    public Collection<edge_data> getE(int node_id) {
        return (Collection<edge_data>) _edges.get(node_id);
    }

    @Override
    public node_data removeNode(int key) {
        //if it has edges containing the ID = key so remove them all from src and dest O(n)
        //create node and apply to it the node we are about to remove to return it O(1)
        //delete it from node collection O(n)
        //after deletion should refresh drawing with stdDraw and use Connect to see if Connected still.
        //summery : O(n)+O(n)+O(1) = O(n)!
        //_edges.get(key).clear();
        edgeSize = edgeSize - _edges.get(key).size();
        _edges.get(key).clear();
        for(HashMap i : _edges.values()){
            i.remove(key);
            edgeSize--;
        }
        _mc++;
        return _nodes.remove(key);
    }

    @Override
    public edge_data removeEdge(int src, int dest) {
        return _edges.get(src).remove(dest);
    }

    @Override
    public int nodeSize() {
        return _nodes.size();
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
