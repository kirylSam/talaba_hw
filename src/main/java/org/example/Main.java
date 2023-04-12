package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Random rand = new Random();
        int[] arrayToBeSorted = new int[10];
        for (int i = 0; i < arrayToBeSorted.length; i++) {
            arrayToBeSorted[i] = rand.nextInt(100);
        }

        System.out.println("Array before sorting: ");
        printArray(arrayToBeSorted);

        mergeSort(arrayToBeSorted);

        System.out.println("Array after sorting: ");
        printArray(arrayToBeSorted);
    }

    public static void mergeSort(int[] inputArray) {
        int arrayLength = inputArray.length;

        //if our array is having 0 or 1 elements - do nothing. It's already sorted
        if (arrayLength < 2) {
            return;
        }

        //then we are finding the middle of our array and creating new arrays
        int midIndex = arrayLength / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[arrayLength - midIndex];

        //populating the leftArray
        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = inputArray[i];
        }

        //populating the rightArray
        for (int i = midIndex; i < arrayLength; i++) {
            rightArray[i - midIndex] = inputArray[i];
        }

        //calling the method recursively until we have arrays of just one element
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(inputArray, leftArray, rightArray);
    }

    public static void merge(int[] inputArray, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k] = leftArray[i];
                i++;
            } else {
                inputArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //cleanup of leftover values in the right of left arrays
        while (i < leftSize) {
            inputArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inputArray[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void printArray(int[] arrayToBePrinted) {
        for (int element : arrayToBePrinted) {
            System.out.println(element);
        }
    }
}