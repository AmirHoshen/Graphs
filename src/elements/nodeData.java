package elements;

import dataStructure.node_data;
import utils.Point3D;

import java.security.InvalidParameterException;

public class nodeData implements node_data {
    private static int _id = 0;
    private double _weight;
    private Point3D _location;
    private String _info = "";
    private int _tag;


    public nodeData() {// weird constructor
        this._id++;
        _weight = 0;//check for logic if it should have empty constructor!
        _location = new Point3D(0, 0);
    }

    public nodeData(Point3D location, double weight) throws Exception {
        if(weight<=0){
            throw new Exception("nodeData: (location,weight)->Weight isn't Correct, should be Positive!");
        }
        this._id++;
        _weight = weight;
        _location = location;
    }

    public nodeData(nodeData nd) {
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
        if (p != null) {
            this._location = new Point3D(p);
        }
    }

    @Override
    public String getInfo() {
        _info = "node id: " + _id +
                "\nnode weight: " + _weight +
                "\nnode location: " + _location +
                "\nnode tag: =" + _tag;
        return _info;
    }

    @Override
    public void setInfo(String s) {
        if (s != null && !s.isEmpty()) {
            throw new InvalidParameterException("nodeData_setInfo: Info string received is empty");
        } else {
            s.toLowerCase();
            s.replaceAll(" ", "");
            if (s.contains("id") && s.contains("weight") && s.contains("location")) {
                if (s.indexOf('d') < s.indexOf('w') && s.indexOf('d') < s.indexOf('l')) {               //id appear 1st in string
                    if (s.indexOf('w') < s.indexOf('l')) {                                  //Appearance: id 1st, weight 2nd and location last
                        _id = Integer.parseInt(s.substring(s.indexOf('d'), s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.indexOf('l')));
                        _location = new Point3D(s.substring(s.indexOf('n') + 1, s.length()));
                    } else {                                                                    //id 1st , location 2nd and weight is last
                        _id = Integer.parseInt(s.substring(s.indexOf('d'), s.indexOf('l')));
                        _location = new Point3D(s.substring(s.indexOf('n') + 1, s.indexOf('w')));
                        ;
                        _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.length()));
                    }

                } else if (s.indexOf('w') < s.indexOf('d') && s.indexOf('w') < s.indexOf('l')) {              //weight appear 1st in string
                    if (s.indexOf('d') < s.indexOf('l')) {                           //Appearance: weight is 1st,id 2nd and location last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.indexOf('i')));
                        _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.indexOf('l')));
                        _location = new Point3D(s.substring(s.indexOf('n') + 1, s.length()));
                    } else {                                                       //Appearance: weight is 1st,location 2nd and id last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.charAt('l')));
                        _location = new Point3D(s.substring(s.indexOf('n') + 1, s.indexOf('i')));
                        _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.length()));
                    }
                } else if (s.indexOf('l') < s.indexOf('d') && s.indexOf('l') < s.indexOf('l')) {            //location appear 1st in string
                    if (s.indexOf('d') < s.indexOf('w')) {                             //Appearance: location is 1st, id 2nd and weight last
                        _location = new Point3D(s.substring(s.indexOf('n') + 1, s.indexOf('i')));
                        _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.length()));
                    } else {                                                         //Appearance: location is 1st, weight 2nd and id last
                        _location = new Point3D(s.substring(s.indexOf('n') + 1, s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.indexOf('i')));
                        _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.length()));
                    }
                }
            } else if (s.contains("id") && s.contains("weight")) {
                if (s.indexOf('d') < s.indexOf('w')) {
                    _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.indexOf('w')));
                    _weight = Double.parseDouble(s.substring(s.indexOf('t') + 1, s.length()));
                } else {
                    _id = Integer.parseInt(s.substring(s.charAt('d') + 1, s.length()));
                    _weight = Double.parseDouble(s.substring(s.indexOf('w') + 1, s.charAt('d')));
                }
            } else if (s.contains("id") && s.contains("location")) {
                if (s.indexOf('d') < s.indexOf('l')) {
                    _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.indexOf('w')));
                    _location = new Point3D(s.substring(s.indexOf('n') + 1, s.length()));
                } else {
                    _id = Integer.parseInt(s.substring(s.indexOf('d') + 1, s.length()));
                    _location = new Point3D(s.substring(s.indexOf('n') + 1, s.indexOf('i')));
                }
            } else if (s.contains("weight") && s.contains("location")) {
                if (s.indexOf('h') < s.indexOf('n')) {
                    _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.indexOf('l')));
                    _location = new Point3D(s.substring(s.charAt('n') + 1, s.length()));
                } else {
                    _weight = Double.parseDouble(s.substring(s.indexOf('h') + 2, s.length()));
                    _location = new Point3D(s.substring(s.charAt('n') + 1, s.indexOf('w')));
                }
            } else if (s.equalsIgnoreCase("id")) {
                _id = Integer.parseInt(s.substring(2, s.length()));
            } else if (s.equalsIgnoreCase("weight")) {
                _weight = Double.parseDouble(s.substring(s.indexOf('t') + 1, s.length()));
            } else if (s.equalsIgnoreCase("location")) {
                _location = new Point3D(s.substring(s.indexOf('n') + 1, s.length()));
            }
        }
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
}
