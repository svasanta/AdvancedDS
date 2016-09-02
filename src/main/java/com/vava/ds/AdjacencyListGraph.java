package com.vava.ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Graph implementation based on adjacency list DS.
 *
 */
public class AdjacencyListGraph implements Graph<Integer> {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    @Override
    public int geVertices() {
        return map.size();
    }

    @Override
    public int getEdges() {
        return map.keySet().stream().mapToInt( (k) -> map.get(k).size()).sum();
    }

    @Override
    public List<Integer> neighbours(Integer v) {
        if(map.get(v) == null){
            return Collections.<Integer>emptyList();
        }
        return map.get(v).stream().collect(Collectors.<Integer>toList());
    }

    @Override
    public int inDegree(Integer v) {
        Optional<List<Integer>> o = Optional.of(map.get(v));
        return o.isPresent() ? o.get().size() :  0;
    }

    @Override
    public void connect(Integer v1, Integer v2) {
        if( map.get(v1) == null){
            map.get(new ArrayList<>());
        }
        map.get(v1).add(v2);
    }

    @Override
    public void neighboursNeighbour(Integer v, int level, List<Integer> result) {
        if(map.get(v) == null || level == 1){
            result.addAll(neighbours(v));
            return ;
        }

        for (int i = 0; i < map.get(v).size(); i++) {
            neighboursNeighbour(map.get(v).get(i), i-1, result);
        }
    }
}
