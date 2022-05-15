package com.sluhovyi._03_algo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class AlgoDemo {

  public static void main(String[] args) {
    for (int n = 1; n < 1_000_000_000; n*=2) {
      var arr = generateArray(n);
//    System.out.println(Arrays.toString(arr));
      var attempts = 10;
      var totalTime = 0;
      for (int i = 0; i < attempts; i++) {
        var start = System.nanoTime();
        var min = findMin(arr);
        var execTime = System.nanoTime() - start;
        totalTime += execTime;
      }
      var avgTime = totalTime / attempts;
      System.out.printf("%12d %12d\n", n, avgTime);
    }




  }

  private static int findMin(int[] arr) {
    var min = arr[0];
    for (int i : arr) {
      if (i < min) {
        min = i;
      }
    }
    return min;
  }

  private static int[] generateArray(int n) {
    var arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ThreadLocalRandom.current().nextInt(n);
    }
    return arr;
  }
}
