package elements;

import dataStructure.node_data;
import utils.Point3D;

import java.io.InvalidObjectException;

public class nodeData implements node_data {
    private static int _id = 0;
    private double _weight;
    private Point3D _location;
    private String _info = "";
    private int _tag;


    public nodeData(){
        this._id++;
        _weight = 0;
        _location = new Point3D(0,0);
    }

    public nodeData(double weight,Point3D location){
        this._id++;
        _weight = weight;
        _location = location;
    }

    public nodeData(nodeData nd){
        this._id++;
        this._weight = nd.getWeight();
        this._location = new Point3D(nd.getLocation());
        this._tag = nd.getTag();
        this._info = nd.getInfo();
    }

    @Override
    public int getKey() {
        return _id;
    }

    @Override
    public double getWeight() {
        return this._weight;
    }

    @Override
    public void setWeight(double w) {
        this._weight = w;
    }

    @Override
    public Point3D getLocation() {
        return this._location;
    }

    @Override
    public void setLocation(Point3D p) {
        if(p!=null){
            this._location = new Point3D(p);
        }
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void setInfo(String s) {

    }

    @Override
    public int getTag() {
        return 0;
    }

    @Override
    public void setTag(int t) {

    }
}
