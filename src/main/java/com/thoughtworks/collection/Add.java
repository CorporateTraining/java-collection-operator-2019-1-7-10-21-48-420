package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            int number = leftBorder;
            leftBorder = rightBorder;
            rightBorder = number;
        }
        int sum = 0;
        for (int i = leftBorder; i <= rightBorder; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            int number = leftBorder;
            leftBorder = rightBorder;
            rightBorder = number;
        }
        int sum = 0;
        for (int i = leftBorder; i <= rightBorder; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(item -> item * 3 + 2)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                arrayList.set(i, arrayList.get(i) * 3 + 2);
            }
        }

        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(item -> item % 2 != 0)
                .map(item -> item * 3 + 5)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream()
                .filter(item -> item % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        double median;
        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        } else {
            median = list.get(list.size() / 2);
        }

        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {

        return arrayList.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::byteValue)
                .average()
                .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> list = new ArrayList<>();
        arrayList.forEach(item -> {
            if (!list.contains(item)) {
                list.add(item);
            }
        });

        return list.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {

        Collections.sort(arrayList);
        List<Integer> list = arrayList.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());

        Collections.reverse(arrayList);
        list.addAll(arrayList.stream()
                .filter(item -> item % 2 != 0)
                .collect(Collectors.toList()));

        return list;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arrayList.size() - 1; i++) {
            list.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }

        return list;
    }
}
