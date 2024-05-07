package org.sortapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortAppFacade {
  private final UserInterfaceFacade userInterface;
  private final DataProcessingFacade dataProcessor;

  public SortAppFacade() {
    ConfigurationManager configManager = new ConfigurationManager();
    this.userInterface = new UserInterfaceFacade();
    this.dataProcessor = new DataProcessingFacade(configManager);
  }

  public void execute() {
    try {
      String algorithmType = userInterface.getAlgorithmChoice();

      dataProcessor.setSortingAlgorithm(algorithmType);
      int[] data = dataProcessor.fetchData();

      userInterface.displayFetchedData(data);

      SortingResult result = dataProcessor.sortData(data);
      userInterface.displaySortingResult(algorithmType, result);

    } catch (Exception e) {
      log.error("Application execution failed: {}", e.getMessage(), e);
      userInterface.displayError(e);
    }
  }
}
