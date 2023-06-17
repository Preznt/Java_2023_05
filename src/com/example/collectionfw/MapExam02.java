package com.example.collectionfw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam02 {
    public static void main(String[] args) {
        Map<String ,String> map = new HashMap<>();
        map.put("k1","hello");
        map.put("k2","hi");
        map.put("k3","bye");

        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }

}
