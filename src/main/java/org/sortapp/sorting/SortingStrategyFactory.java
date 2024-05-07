package org.sortapp.sorting;

class SortingStrategyFactory {
  private static final String MERGE = "merge";
  private static final String BUBBLE = "bubble";

  SortingStrategy createStrategy(String algorithmType) {
    return switch (algorithmType.toLowerCase()) {
      case MERGE -> new MergeSort();
      case BUBBLE -> new BubbleSort();
      default -> createDefault();
    };
  }

  public SortingStrategy createDefault() {
    return new BubbleSort();
  }
}
