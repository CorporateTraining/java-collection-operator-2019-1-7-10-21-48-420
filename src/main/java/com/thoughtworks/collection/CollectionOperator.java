package com.thoughtworks.collection;

import com.sun.tools.javac.util.ArrayUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if (left > right) {
            for (int i = left; i >= right; i--) {
                list.add(i);
            }
        } else {
            for (int i = left; i <= right; i++) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if (left > right) {
            for (int i = left; i >= right; i--) {
                list.add(i);
            }
        } else {
            for (int i = left; i <= right; i++) {
                list.add(i);
            }
        }

        return list.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> list = convertNumber(array);

        return list.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {

        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = convertNumber(firstArray);
        List<Integer> secondList = convertNumber(secondArray);
        firstList.retainAll(secondList);
        return firstList;
    }

    private List<Integer> convertNumber(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int item : array) {
            list.add(item);
        }
        return list;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(firstArray));
        List<Integer> secondList = Arrays.asList(secondArray);
        List<Integer> list = secondList.stream().filter(item -> !firstList.contains(item)).collect(Collectors.toList());
        firstList.addAll(list);

        return firstList;
    }
}
