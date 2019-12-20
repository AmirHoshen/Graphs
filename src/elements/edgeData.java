package elements;

import dataStructure.edge_data;

public class edgeData implements edge_data {// zug sadur shel start ve end weight ze ha mishkal shel ha maavar ba keshet
    private int _src;
    private int _dest;
    private double _weight;
    private String _info;
    private int _tag;

    public edgeData(int src, int dest, double weight) throws Exception {
        this._src = src;
        this._dest = dest;
        if (weight <= 0) {
            throw new Exception("Weight isn't Correct!");
        }
        this._weight = weight;
        this._tag = 0;
    }

    @Override
    public int getSrc() {
        return this._src;
    }

    @Override
    public int getDest() {
        return this._dest;
    }

    @Override
    public double getWeight() {
        return this._weight;
    }

    @Override
    public String getInfo() {
        return this._info;
    }

    @Override
    public void setInfo(String s) {
        this._info = "";// TO-Do
    }

    @Override
    public int getTag() {
        return this._tag;
    }

    @Override
    public void setTag(int t) {
        this._tag = t;
    }
}
