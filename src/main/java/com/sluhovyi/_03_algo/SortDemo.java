package com.sluhovyi._03_algo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SortDemo {

  public static void main(String[] args) {
    var arr = generateArray(20);
    System.out.println(Arrays.toString(arr));
    
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
    
  }

  private static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      var pickedCard = arr[i];
      var currPosition = i;
      while (currPosition > 0 && pickedCard < arr[currPosition - 1]) {
        arr[currPosition] = arr[currPosition - 1];
        currPosition--;
      }
      arr[currPosition] = pickedCard;
    }

    
  }
  private static int[] generateArray(int n) {
    var arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ThreadLocalRandom.current().nextInt(n);
    }
    return arr;
  }

}
