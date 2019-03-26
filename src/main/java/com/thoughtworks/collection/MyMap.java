package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map(item -> item * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        List<String> list = new ArrayList<>();
        for (Integer item : array) {
            list.add(letterList.get(item - 1));
        }

        return list;
    }

    public List<String> mapLetters() {
        List<String> list = new ArrayList<>();
        for (Integer item : array) {
            if (item <= 26) {
                list.add(letterList.get(item - 1));
            } else {
                list.add(letterList.get((item - 1) / 26 - 1) + letterList.get((item - 1) % 26));
            }
        }

        return list;
    }

    public List<Integer> sortFromBig() {
        Collections.reverse(array);
        return array;
    }

    public List<Integer> sortFromSmall() {
        Collections.sort(array);
        return array;
    }
}
