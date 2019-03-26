package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return array.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream()
                .filter(item -> item % 3 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> list = new ArrayList<>(firstList);
        list.retainAll(secondList);
        return list;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> list = new ArrayList<>();
        for(Integer arr : array){
            if(!list.contains(arr)){
                list.add(arr);
            }
        }

        return list;
    }
}
