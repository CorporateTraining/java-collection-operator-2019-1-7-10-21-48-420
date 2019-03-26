package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.addAll(Arrays.asList(array[i]));
        }
        return list;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.addAll(Arrays.asList(array[i]));
        }
        for (Integer arr : list) {
            if (!result.contains(arr)) {
                result.add(arr);
            }
        }
        return result;
    }
}
