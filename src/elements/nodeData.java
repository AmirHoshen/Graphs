package elements;

import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;

import java.util.ArrayList;
import java.util.Collection;

public class nodeData implements node_data {
    private ArrayList<edge_data> _edge = new ArrayList<>();
    private static int _id = 0;
    private int _key;
    private int _prev;
    private double _weight;
    private Point3D _location;
    private String _info = "";
    private int _tag;


    public nodeData() {
        this._key = _id;
        this._id++;
        this._info="";
        this._tag = -1;
        _weight = 0;//check for logic if it should have empty constructor!
        _location = new Point3D(0, 0);
    }

    public nodeData(Point3D location) throws Exception {
        this._key = _id;
        this._id++;
        _location = new Point3D(location);
        _tag = -1;
        _info = "";
    }

    public nodeData(nodeData nd) {
        this._key = nd._key;
        this._weight = nd._weight;
        this._location = new Point3D(nd.getLocation());
        this._tag = nd._tag;
        this._info = nd._info;
    }

    public void addEdge(edgeData e){
        if(this._key==e.getSrc()){
            _edge.add(e);
        }else{
            System.out.println("Inserted wrong edge value");
        }
    }

    @Override
    public int getKey() {
        return _key;
    }

    @Override
    public double getWeight() {
        return this._weight;
    }

    @Override
    public void setWeight(double w) {
        if(w<0){
            System.out.println("SetWeight: weight cannot be negative");
        }
        this._weight = w;
    }

    @Override
    public Point3D getLocation() {
        return this._location;
    }

    @Override
    public void setLocation(Point3D p) {
        if (p != null) {
            this._location = new Point3D(p);
        }
    }

    @Override
    public String getInfo() {
        return _info;
    }

    @Override
    public void setInfo(String s) {
        this._info = s;
    }

    @Override
    public int getTag() {
        return _tag;
    }

    @Override
    public void setTag(int t) {
        if(t<-1 || t>1){
            throw new IllegalArgumentException("nodeData: setTag->Tag can only be -1,0,1");
        }else {
            _tag = t;
        }
    }

    public Collection<edge_data> edgesOf(){
        return _edge;
    }
    public void deleteEdge(int src,int dest){
        for(edge_data ed : _edge){
            if(src==ed.getSrc() && dest == ed.getDest())
                _edge.remove(ed);
        }
    }
    public void set_prev(int n){
        this._prev = n;
    }
    public int get_prev(){
        return this._prev;
    }
}
