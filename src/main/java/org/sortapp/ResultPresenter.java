package org.sortapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ResultPresenter {

  void showFetchedData(int[] data) {
    log.info("Fetched data: {}", Utils.arrayToString(data));
  }

  void showSortedResult(String algorithm, SortingResult result) {
    log.info("Sorted data ({}): {}", algorithm, Utils.arrayToString(result.sortedData()));
    log.info("Sorting time: {} ms", result.sortingTime());
  }
}
