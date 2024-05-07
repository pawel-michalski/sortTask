package org.sortapp.facade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sortapp.ConfigurationManager;
import org.sortapp.DataProcessingFacade;
import org.sortapp.SortingResult;

class DataProcessingFacadeTest {

  private static final String BUBBLE_SORT = "bubble";
  private static final String MERGE_SORT = "merge";
  private static final String INVALID_ALGORITHM = "invalid_algorithm";

  @Test
  void fetchData_shouldReturnNonNullArray() throws Exception {
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(BUBBLE_SORT);
    int[] data = facade.fetchData();

    assertNotNull(data, "Data array should not be null");
    assertTrue(data.length > 0, "Data array should contain elements");
  }

  @Test
  void sortData_withBubbleSort_shouldSortCorrectly() {
    int[] unsorted = {5, 3, 1, 4, 2};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(BUBBLE_SORT);
    SortingResult result = facade.sortData(unsorted);

    assertArrayEquals(
        new int[] {1, 2, 3, 4, 5},
        result.sortedData(),
        "Should sort array in ascending order using BubbleSort");
    assertTrue(result.sortingTime() >= 0, "Sorting time should be >= 0");
  }

  @Test
  void sortData_withMergeSort_shouldSortCorrectly() {
    int[] unsorted = {10, 2, 8, 6, 4};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(MERGE_SORT);
    SortingResult result = facade.sortData(unsorted);

    assertArrayEquals(
        new int[] {2, 4, 6, 8, 10},
        result.sortedData(),
        "Should sort array in ascending order using MergeSort");
    assertTrue(result.sortingTime() >= 0, "Sorting time should be >= 0");
  }

  @Test
  void sortData_withInvalidAlgorithm_shouldDefaultToBubbleSort() {
    int[] unsorted = {9, 5, 7};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(INVALID_ALGORITHM);
    SortingResult result = facade.sortData(unsorted);

    assertArrayEquals(
        new int[] {5, 7, 9},
        result.sortedData(),
        "Should default to BubbleSort when unknown algorithm is provided");
  }

  @Test
  void sortData_shouldHandleEmptyArray() {
    int[] empty = {};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(MERGE_SORT);
    SortingResult result = facade.sortData(empty);

    assertArrayEquals(
        new int[] {}, result.sortedData(), "Should return empty array when input is empty");
  }

  @Test
  void sortData_shouldHandleSingleElementArray() {
    int[] single = {42};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(BUBBLE_SORT);
    SortingResult result = facade.sortData(single);

    assertArrayEquals(
        new int[] {42},
        result.sortedData(),
        "Should return the same array when only one element is present");
  }

  @Test
  void sortData_shouldHandleAlreadySortedArray() {
    int[] sorted = {1, 2, 3, 4, 5};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(MERGE_SORT);
    SortingResult result = facade.sortData(sorted);

    assertArrayEquals(sorted, result.sortedData(), "Should return the same sorted array");
  }

  @Test
  void sortData_shouldHandleReverseSortedArray() {
    int[] reverse = {9, 7, 5, 3, 1};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(BUBBLE_SORT);
    SortingResult result = facade.sortData(reverse);

    assertArrayEquals(
        new int[] {1, 3, 5, 7, 9},
        result.sortedData(),
        "Should sort descending array into ascending order");
  }

  @Test
  void sortData_shouldHandleArrayWithDuplicates() {
    int[] withDuplicates = {3, 5, 3, 1, 2};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(MERGE_SORT);
    SortingResult result = facade.sortData(withDuplicates);

    assertArrayEquals(
        new int[] {1, 2, 3, 3, 5},
        result.sortedData(),
        "Should correctly handle duplicates during sorting");
  }

  @Test
  void sortData_shouldHandleNegativeNumbers() {
    int[] negatives = {-3, -1, -7, 2, 0};
    ConfigurationManager configManager = new ConfigurationManager();
    DataProcessingFacade facade = new DataProcessingFacade(configManager);
    facade.setSortingAlgorithm(BUBBLE_SORT);
    SortingResult result = facade.sortData(negatives);

    assertArrayEquals(
        new int[] {-7, -3, -1, 0, 2},
        result.sortedData(),
        "Should correctly sort negative numbers");
  }
}
