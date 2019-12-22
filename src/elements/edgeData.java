package elements;

import dataStructure.edge_data;
import utils.Point3D;

import java.security.InvalidParameterException;

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
            throw new Exception("edgeData:(src,dest,weight)->Weight isn't Correct, should be Positive!");
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
       if(!s.isEmpty() || s!=null){
           s.toLowerCase();
           s.replaceAll(" ","");   //src,dest,weight,tag
           if(s.contains("src")&&s.contains("dest")&&s.contains("weight")&&s.contains("tag")){//string contains all feature
                if(s.indexOf('s')<s.indexOf('d')&&s.indexOf('s')<s.indexOf('w')&&s.indexOf('s')<s.indexOf('t')){//src is 1st
                    if(s.indexOf('w')<s.indexOf('d')&&s.indexOf('w')<s.indexOf('t')){//src 1sr, weight 2nd
                        if(s.indexOf('d')<s.indexOf('t')){//src 1st, weight 2nd, dest 3rd, tag last
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                        }else if(s.indexOf('t')<s.indexOf('d')){//src 1st, weight 2nd, tag 3rd, dest last
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1),s.indexOf('d'));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                        }
                    }else if(s.indexOf('d')<s.indexOf('w')&&s.indexOf('d')<s.indexOf('t')){//src 1st, dest 2nd
                        if(s.indexOf('w')<s.indexOf('t')){//src 1st, dest 2nd, weight 3rd, tag last
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                        }else if(s.indexOf('t')<s.indexOf('w')){//src 1st, dest 2nd, tag 3rd, weight last
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                        }
                    }else if(s.indexOf('t')<s.indexOf('w')&&s.indexOf('t')<s.indexOf('d')){//src 1st, tag 2nd
                        if(s.indexOf('w')<s.indexOf('d')){//src 1st, tag 2nd, weight 3rd, dest last
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                        }else if(s.indexOf('d')<s.indexOf('w')){// src 1st, tag 2nd, dest 3rd, weight last
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                        }
                    }
                }else if(s.indexOf('d')<s.indexOf('s')&&s.indexOf('d')<s.indexOf('w')&&s.indexOf('d')<s.indexOf('t')) {//dest is 1st
                    if(s.indexOf('s')<s.indexOf('w')&&s.indexOf('s')<s.indexOf('t')){//dest 1st, src 2nd
                        if(s.indexOf('w')<s.indexOf('t')){//dest 1st, src 2nd, weight 3rd, tag last
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('s')));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                        }else if(s.indexOf('t')<s.indexOf('w')){//dest 1st, src 2nd, tag 3rd, weight last
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('s')));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                        }
                    }else if(s.indexOf('w')<s.indexOf('s')&&s.indexOf('w')<s.indexOf('t')){//dest 1st, weight 2nd
                        if(s.indexOf('s')<s.indexOf('t')){//dest 1st, weight 2nd, src 3rd, tag last
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('s')));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                        }else if(s.indexOf('t')<s.indexOf('s')){//dest 1st, weight 2nd, tag 3rd, src last
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2, s.indexOf('t')));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('s')));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                        }
                    }else if(s.indexOf('t')<s.indexOf('w')&&s.indexOf('t')<s.indexOf('s')){//dest 1st, tag 2nd
                        if(s.indexOf('w')<s.indexOf('s')){//dest 1st, tag 2nd, weight 3rd, src last
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2, s.indexOf('s')));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1, s.length()));
                        }else if(s.indexOf('s')<s.indexOf('w')){//dest 1st, tag 2nd, src 3rd, weight last
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('r')-1));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                        }
                    }
                }else if(s.indexOf('w')<s.indexOf('s')&&s.indexOf('w')<s.indexOf('d')&&s.indexOf('w')<s.indexOf('t')){//weight is 1st
                    if(s.indexOf('s')<s.indexOf('t')&&s.indexOf('s')<s.indexOf('d')){//weight 1st, src 2nd
                        if(s.indexOf('t')<s.indexOf('d')){//weight 1st, src 2nd, tag 3rds, dest last
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('r')-1));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                        }else if(s.indexOf('d')<s.indexOf('t')){//weight 1st, src 2nd, dest 3rd, tag last
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('r')-1));
                            _src =  Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                        }
                    }else if(s.indexOf('t')<s.indexOf('s')&&s.indexOf('t')<s.indexOf('d')){//weight 1st, tag 2nd
                        if(s.indexOf('s')<s.indexOf('d')){//weight 1st, tag 2nd, src 3rd, dest last
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('r')-1));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                        }else if(s.indexOf('d')<s.indexOf('s')){//weight 1st, tag 2nd, dest 3rd, src last
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('r')-1));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                        }
                    }else if(s.indexOf('d')<s.indexOf('t')&&s.indexOf('d')<s.indexOf('s')){//weight 1st, dest 2nd
                        if(s.indexOf('t')<s.indexOf('s')){//weight 1st, dest 2nd, tag 3rd, src last
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('c')-2));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                        }else if(s.indexOf('s')<s.indexOf('t')){//weight 1st, dest 2nd, src 3rd, tag last
                            _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                            _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                            _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('a')-1));
                            _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                        }
                    }
                }else if(s.indexOf('t')<s.indexOf('s')&&s.indexOf('t')<s.indexOf('d')&&s.indexOf('t')<s.indexOf('w')){//tag is 1st
                  if(s.indexOf('s')<s.indexOf('w')&&s.indexOf('s')<s.indexOf('d')){//tag 1st, src 2nd
                      if(s.indexOf('d')<s.indexOf('w')){//tag 1st, src 2nd, dest 3rd, weight last
                          _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('s')));
                          _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                          _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                          _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                      }else if(s.indexOf('w')<s.indexOf('d')){//tag 1st, src 2nd, weight 3rd, dest last
                          _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('r')-1));
                          _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                          _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                          _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                      }
                  }else if(s.indexOf('w')<s.indexOf('s')&&s.indexOf('w')<s.indexOf('d')){///tag 1st, weight 2nd
                      if(s.indexOf('d')<s.indexOf('s')){//tag 1st,weight 2nd, dest 3rd, src last
                          _tag = Integer.parseInt(s.substring(s.indexOf('a')+2,s.indexOf('w')));
                          _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                          _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('s')));
                          _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                      }else if(s.indexOf('s')<s.indexOf('d')){//tag 1st,weight 2nd, src 3rd, dest last
                          _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                          _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('s')));
                          _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                          _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                      }
                  }else if(s.indexOf('d')<s.indexOf('w')&&s.indexOf('d')<s.indexOf('s')){//tag 1st, dest 2nd
                      if(s.indexOf('w')<s.indexOf('s')){// tag 1st, dest 2nd, weight 3rd, src last
                          _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                          _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                          _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('c')-2));
                          _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                      }else if(s.indexOf('s')<s.indexOf('w')){// tag 1st, dest 2nd, src 3rd, weight last
                          _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                          _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                          _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                          _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                      }
                  }
                }
           }else if(s.contains("src")&&s.contains("weight")&&s.contains("dest")){//all except tag
                if(s.indexOf('s')<s.indexOf('w')&&s.indexOf('s')<s.indexOf('d')){//src 1st
                    if(s.indexOf('d')<s.indexOf('w')){//src 1st, dest 2nd, weight last
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                    }else if(s.indexOf('w')<s.indexOf('d')){//src 1st, weight 2nd, dest last
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                    }
                }else if(s.indexOf('w')<s.indexOf('s')&&s.indexOf('w')<s.indexOf('d')) {//weight 1st
                    if(s.indexOf('s')<s.indexOf('d')){//weight 1st, src 2nd, dest last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('r')-1));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                    }else if(s.indexOf('d')<s.indexOf('s')){//weight 1st, dest 2nd, src last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                    }
                }else if(s.indexOf('d')<s.indexOf('w')&&s.indexOf('d')<s.indexOf('s')){//dest 1st
                    if(s.indexOf('w')<s.indexOf('s')){//dest 1st, weight 2nd, src last
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                    }else if(s.indexOf('s')<s.indexOf('w')){//dest 1st, src 2nd, weight last
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                    }
                }
           }else if(s.contains("src")&&s.contains("weight")&&s.contains("tag")){//all except dest
                if(s.indexOf('s')<s.indexOf('w')&&s.indexOf('s')<s.indexOf('a')-1){//src 1st
                    if(s.indexOf('w')<s.indexOf('a')-1){//src 1st, weight 2nd, tag last
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                    }else if(s.indexOf('a')-1<s.indexOf('w')){//src 1st, tag 2nd, weight last
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                    }
                }else if(s.indexOf('w')<s.indexOf('s')&&s.indexOf('w')<s.indexOf('a')-1){//weight 1st
                    if(s.indexOf('s')<s.indexOf('a')-1){//weight 1st, src 2nd, tag last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                    }else if(s.indexOf('a')-1<s.indexOf('s')){//weight 1st, tag 2nd, src last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('r')-1));
                        _src= Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                    }
                }else if(s.indexOf('a')-1<s.indexOf('w')&&s.indexOf('a')-1<s.indexOf('s')){//tag 1st
                    if(s.indexOf('w')<s.indexOf('s')){//tag 1st, weight 2nd, src last
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('r')-1));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                    }else if(s.indexOf('s')<s.indexOf('w')){//tag 1st, src 2nd, weight last
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('r')-1));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                    }
                }
           }else if(s.contains("weight")&&s.contains("tag")&&s.contains("dest")){//all except src
                if(s.indexOf('w')<s.indexOf('a')-1 &&s.indexOf('w')<s.indexOf('d')){//weight 1st
                    if(s.indexOf('a')-1<s.indexOf('d')){//weight 1st,tag 2nd, dest last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                    }else if(s.indexOf('d')<s.indexOf('a')-1){//weight 1st, dest 2nd, tag last
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                    }
                }else if(s.indexOf('a')-1<s.indexOf('w')&&s.indexOf('a')-1<s.indexOf('d')){//tag 1st
                    if(s.indexOf('w')<s.indexOf('d')){//tag 1st, weight 2nd, dest last
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                    }else if(s.indexOf('d')<s.indexOf('w')){//tag 1st, dest 2nd, weight last
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                    }
                }else if(s.indexOf('d')<s.indexOf('w')&&s.indexOf('d')<s.indexOf('a')-1){//dest 1st
                    if(s.indexOf('w')<s.indexOf('a')-1){//dest 1st, weight 2nd, tag last
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                    }else if(s.indexOf('a')-1<s.indexOf('w')){//dest 1st, tag 2nd, weight last
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                        _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                    }
                }
           }else if(s.contains("tag")&&s.contains("dest")&&s.contains("src")){//all except weight
                if(s.indexOf('a')-1<s.indexOf('d')&&s.indexOf('a')-1<s.indexOf('s')){//tag 1st
                    if(s.indexOf('d')<s.indexOf('c')-2){//tag 1st, dest 2nd, src last
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                    }else if(s.indexOf('c')-2<s.indexOf('d')){//tag 1st, src 2nd, dest last
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                    }
                }else if(s.indexOf('d')<s.indexOf('a')-1 && s.indexOf('d')<s.indexOf('c')-2){//dest 1st
                    if(s.indexOf('a')-1<s.indexOf('c')-2){//dest 1st, tag 2nd, src last
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                    }else if(s.indexOf('c')-2<s.indexOf('a')-1){//dest 1st, src 2nd, tag last
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                    }
                }else if(s.indexOf('c')-2<s.indexOf('d')&&s.indexOf('c')-2<s.indexOf('a')-1){//src `1st
                    if(s.indexOf('d')<s.indexOf('a')-1){//src 1st, dest 2nd, tag last
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                    }else if(s.indexOf('a')-1<s.indexOf('d')){//src 1st, tag 2nd, dest last
                        _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('a')-1));
                        _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                        _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                    }
                }
           }else if(s.contains("src")&&s.contains("weight")){
                if(s.indexOf('s')<s.indexOf('w')){//src 1st, weight 2nd
                    _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('w')));
                    _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                }else{//weight 1st, src 2nd
                    _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('c')-2));
                    _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                }
           }else if(s.contains("src")&&s.contains("dest")){
                if(s.indexOf('s')<s.indexOf('d')){//src 1st, dest 2nd
                    _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('d')));
                    _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                }else{//dest 1st, src 2nd
                    _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('c')-2));
                    _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                }
           }else if(s.contains("src")&&s.contains("tag")){
                if(s.indexOf('s')<s.indexOf('t')){//src 1st, tag 2nd
                    _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.indexOf('t')));
                    _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                }else{//tag 1st, src 2nd
                    _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('s')));
                    _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
                }
           }else if(s.contains("weight")&&s.contains("dest")){
                if(s.indexOf('w')<s.indexOf('d')){//weight 1st, dest 2nd
                    _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('d')));
                    _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                }else{//dest 1st, weight 2nd
                    _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('w')));
                    _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                }
           }else if(s.contains("weight")&&s.contains("tag")){
                if(s.indexOf('w')<s.indexOf('a')-1){//weight 1st, tag 2nd
                    _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.indexOf('a')-1));
                    _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                }else{//tag 1st, weight 2nd
                    _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('w')));
                    _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
                }
           }else if(s.contains("dest")&&s.contains("tag")){
                if(s.indexOf('d')<s.indexOf('a')-1){//dest 1st, tag 2nd
                    _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.indexOf('a')-1));
                    _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
                }else{//tag 1st, dest 2nd
                    _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.indexOf('d')));
                    _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
                }
           }else if(s.contains("src")){
                _src = Integer.parseInt(s.substring(s.indexOf('c')+1,s.length()));
           }else if(s.contains("dest")){
                _dest = Integer.parseInt(s.substring(s.indexOf('d')+4,s.length()));
           }else if(s.contains("weight")){
                _weight = Double.parseDouble(s.substring(s.indexOf('h')+2,s.length()));
           }else if(s.contains("tag")){
                _tag = Integer.parseInt(s.substring(s.indexOf('g')+1,s.length()));
           }
       }else{
           throw new InvalidParameterException("Method setInfo received illegal info!");
       }

           this._info = "source: "+_src+
                   "\ndestination: "+_dest+
                   "\ntag: "+_tag+
                   "\nweight: "+_weight;
    }

    @Override
    public int getTag() {
        return this._tag;
    }

    @Override
    public void setTag(int t) {
        if(t>-1&&t<1) {
            this._tag = t;
        }else{
            throw new IllegalArgumentException("setTag: Method received illegal tag");
        }
    }
}
