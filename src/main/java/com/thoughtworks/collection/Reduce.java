package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public int getIndexOfFirstEven() throws BusinessException {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        throw new BusinessException("没有找到偶数下标");
    }

    public boolean isEqual(List<Integer> arrayList) {
        return Arrays.deepEquals(this.arrayList.toArray(), arrayList.toArray());
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        if (arrayList.size() % 2 == 0) {
            double number1 = Double.parseDouble(singleLink.getNode(arrayList.size() / 2).toString());
            double number2 = Double.parseDouble(singleLink.getNode(arrayList.size() / 2 + 1).toString());
            return (number1 + number2) / 2;
        } else {
            return Double.parseDouble(singleLink.getNode(arrayList.size() / 2 + 1).toString());
        }
    }

    public int getLastOdd() throws BusinessException {
        for (int i = arrayList.size() - 1; i > 0; i++) {
            if (arrayList.get(i) % 2 != 0) {
                return arrayList.get(i);
            }
        }

        throw new BusinessException("没有找到偶数下标");
    }

    public int getIndexOfLastOdd() throws BusinessException {

        for (int i = arrayList.size() - 1; i > 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                return i;
            }
        }

        throw new BusinessException("没有找到偶数下标");
    }
}
