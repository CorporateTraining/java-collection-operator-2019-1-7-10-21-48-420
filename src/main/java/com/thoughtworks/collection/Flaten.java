package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(array)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> list = Arrays.stream(array)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
