package org.sortapp;

import org.sortapp.resource.ResourceException;
import org.sortapp.resource.ResourceManagerFacade;
import org.sortapp.sorting.SortingServiceFacade;

public class DataProcessingFacade {
  private final ResourceManagerFacade resourceManager;
  private final SortingServiceFacade sortingService;

  public DataProcessingFacade(ConfigurationManager configManager) {
    this.resourceManager = new ResourceManagerFacade(configManager);
    this.sortingService = new SortingServiceFacade();
  }

  public void setSortingAlgorithm(String algorithmType) {
    sortingService.setAlgorithm(algorithmType);
  }

  public int[] fetchData() throws ResourceException {
    return resourceManager.fetchData();
  }

  public SortingResult sortData(int[] data) {
    return sortingService.sortWithTiming(data);
  }
}
