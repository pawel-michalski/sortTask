package org.sortapp.sorting;

import lombok.Setter;

@Setter
class SortingContext {
  private SortingStrategy sortingStrategy;

  SortingContext(SortingStrategy strategy) {
    this.sortingStrategy = strategy;
  }

  public int[] executeSort(int[] data) {
    return sortingStrategy.sort(data).getResult();
  }
}
