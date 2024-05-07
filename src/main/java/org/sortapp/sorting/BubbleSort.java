package org.sortapp.sorting;

import java.util.Arrays;

class BubbleSort implements SortingStrategy {
  @Override
  public JobAchievement sort(int[] data) {
    int[] result = Arrays.copyOf(data, data.length);
    int n = result.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (result[j] > result[j + 1]) {
          int temp = result[j];
          result[j] = result[j + 1];
          result[j + 1] = temp;
        }
      }
    }

    return new JobAchievement(result);
  }
}
