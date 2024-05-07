package org.sortapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class UserInterfaceFacade {
  private final UserInputProvider inputProvider;
  private final ResultPresenter presenter;

  UserInterfaceFacade() {
    this.inputProvider = new UserInputProvider();
    this.presenter = new ResultPresenter();
  }

  String getAlgorithmChoice() {
    return inputProvider.selectSortingAlgorithm();
  }

  void displayFetchedData(int[] data) {
    presenter.showFetchedData(data);
  }

  void displaySortingResult(String algorithm, SortingResult result) {
    presenter.showSortedResult(algorithm, result);
  }

  void displayError(Exception e) {
    log.error("Error: {}", e.getMessage());
  }
}
