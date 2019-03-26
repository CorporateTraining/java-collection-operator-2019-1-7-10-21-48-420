package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.text.resources.ca.CollationData_ca;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return Collections.max(arrayList);
    }

    public double getMinimum() {
        return Collections.min(arrayList);
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public double getOrderedMedian() {
        Collections.sort(arrayList);
        double median;
        if (arrayList.size() % 2 == 0) {
            median = (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2.0;
        } else {
            median = arrayList.get(arrayList.size() / 2);
        }

        return median;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(item -> item % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 == 0){
                return i;
            }
        }
        return 0;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.size() == arrayList.size() && this.arrayList.containsAll(arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        for (Integer item : arrayList) {
            singleLink.addTailPointer(item);
        }
        if (arrayList.size() % 2 == 0) {
            double number1 = Double.parseDouble(singleLink.getNode(arrayList.size() / 2).toString());
            double number2 = Double.parseDouble(singleLink.getNode(arrayList.size() / 2 + 1).toString());
            return (number1 + number2) / 2;
        } else {
            return Double.parseDouble(singleLink.getNode(arrayList.size() / 2 + 1).toString());
        }
    }

    public int getLastOdd() {
        int number = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 != 0){
                number = arrayList.get(i);
            }
        }
        return number;
    }

    public int getIndexOfLastOdd() {
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 != 0){
                index = i;
            }
        }
        return index;
    }
}
