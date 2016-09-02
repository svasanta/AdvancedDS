package com.vava.ds;

import java.util.List;

/**
 * Created by vasantas on 8/31/2016.
 */
public interface Graph<V> {
    public int geVertices();
    public int getEdges();
    public List<V> neighbours(Integer v);
    public int inDegree(Integer v);

    public default void connect(V v1, V v2){

    }

    List<Integer> neighboursNeighbour(Integer v);

    void neighboursNeighbour(Integer v, int level, List<Integer> result);
}
