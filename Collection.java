package com.hillel.kuchmii.lessons.lesson11;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        ArrayList<Integer> first = firstSlide();
        ArrayList<Integer> firstArray = secondSlide(first, -10, 10);
        thirdSlide(firstArray);
        forthSlide(firstArray);
        fifthSlide(firstArray);
        sixthSlideMin(firstArray);
        sixthSlideMax(firstArray);
        seventhSlide(firstArray);
        eighthSlide(firstArray);
        ninthSlide(firstArray, -3);
        tenthSlide(firstArray, -3);
        reverseOrder(firstArray);
        swapElements(firstArray);
        secondLargestNumber(firstArray);
        palindromeCheck(firstArray);
        slide15TimeCheck();
        slide16TimeCheck();
    }

    static ArrayList<Integer> firstSlide() {
        return new ArrayList<>();
    }

    static ArrayList<Integer> secondSlide(ArrayList<Integer> arrayList, int min, int max) {
        int diff = max - min;
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Random().nextInt(diff + 1) + min);
        }
        System.out.println("New array list with values " + arrayList);
        return arrayList;
    }

    static ArrayList<Integer> thirdSlide(ArrayList<Integer> arrayList) {
        ArrayList<Integer> myNewList = (ArrayList<Integer>) arrayList.clone();
        System.out.println("Copied array list: " + myNewList);
        return myNewList;
    }

    static HashSet<Integer> forthSlide(ArrayList<Integer> arrayList) {
        HashSet<Integer> myNewList = new HashSet<>(arrayList);
        System.out.println("Copied set: " + myNewList);
        return myNewList;
    }

    static void fifthSlide(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        System.out.println("Sorted collection: " + arrayList);
    }

    static void sixthSlideMin(ArrayList<Integer> arrayList) {
        int a = Collections.min(arrayList);
        System.out.println("Min value: " + a);
    }

    static void sixthSlideMax(ArrayList<Integer> arrayList) {
        Collections.max(arrayList);
        System.out.println("Min value: " + Collections.max(arrayList));
    }

    static void seventhSlide(ArrayList<Integer> arrayList) {
        int result = 0;
        for (Integer x : arrayList) {
            result += x;
        }
        System.out.println("Sum value: " + result);
    }

    static void eighthSlide(ArrayList<Integer> arrayList) {
        ArrayList<Integer> positiveValues = new ArrayList<>();
        for (Integer x : arrayList) {
            if (x > 0) {
                positiveValues.add(x);
            }
        }

        System.out.println("Only positive: " + positiveValues);
    }

    static void ninthSlide(ArrayList<Integer> arrayList, int num) {
        System.out.printf("%s is present = %s", num, arrayList.contains(num));

    }

    static void tenthSlide(ArrayList<Integer> arrayList, int num) {
        System.out.println();
        System.out.printf("%s contains %s %s time(s)", arrayList, num, Collections.frequency(arrayList, num));
    }

    static void reverseOrder(ArrayList<Integer> arrayList) {
        Collections.reverse(arrayList);
        System.out.println();
        System.out.println("Reversed collection " + arrayList);
    }

    static void swapElements(ArrayList<Integer> arrayList) {
        Collections.swap(arrayList, 0, 9);
        System.out.println("Swap first and last element " + arrayList);
    }

    static void secondLargestNumber(ArrayList<Integer> arrayList) {
        HashSet<Integer> hashSet = new HashSet<>(arrayList);
        ArrayList<Integer> newArrayList = new ArrayList<>(hashSet);
        Collections.sort(newArrayList);
        System.out.println("The second largest number is " + (newArrayList.get(newArrayList.size() - 2)));
    }

    static void palindromeCheck(ArrayList<Integer> arrayList) {
        if (isPalindrome(arrayList)) {
            System.out.println("Collection is a palindrom");
        } else {
            System.out.println("Collection is not a palindrom");
        }
    }

    static boolean isPalindrome(ArrayList<Integer> arrayList) {
        int length = arrayList.size();
        for (int i = 0; i < length / 2; i++) {
            if (arrayList.get(i) != arrayList.get(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static void slide15TimeCheck() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int min = 0;
        int max = 100;
        int diff = max - min;
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(new Random().nextInt(diff + 1) + min);
            linkedList.add(new Random().nextInt(diff + 1) + min);
        }

        getElements(arrayList, linkedList);
    }

    static void slide16TimeCheck() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int min = 0;
        int max = 100;
        int diff = max - min;
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(new Random().nextInt(diff + 1) + min);
            linkedList.add(new Random().nextInt(diff + 1) + min);
        }

        System.out.println("Time spent on ArrayList " + getTime(arrayList) + " millis");
        System.out.println("Time spent on LinkedList " + getTime(linkedList) + " millis");
    }

    static void getElements(ArrayList arrayList, LinkedList linkedList) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(new Random().nextInt(arrayList.size()));
        }
        System.out.println("Time spent on ArrayList " + (System.currentTimeMillis() - startTime) + " millis");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(new Random().nextInt(linkedList.size()));
        }
        System.out.println("Time spent on LinkedList " + (System.currentTimeMillis() - startTime) + " millis");
    }

    static long getTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.get(new Random().nextInt(list.size()));
        }
        return System.currentTimeMillis() - startTime;
    }
}
