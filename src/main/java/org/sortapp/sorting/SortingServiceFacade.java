package org.sortapp.sorting;

import org.sortapp.SortingResult;

public class SortingServiceFacade {
  private final SortingContext sortingContext;
  private final TimedSortingService timedSortingService;
  private final SortingStrategyFactory strategyFactory;

  public SortingServiceFacade() {
    this.strategyFactory = new SortingStrategyFactory();
    this.sortingContext = new SortingContext(strategyFactory.createDefault());
    this.timedSortingService = new TimedSortingService(sortingContext);
  }

  public void setAlgorithm(String algorithmType) {
    SortingStrategy strategy = strategyFactory.createStrategy(algorithmType);
    sortingContext.setSortingStrategy(strategy);
  }

  public SortingResult sortWithTiming(int[] data) {
    JobAchievement achievement = timedSortingService.sort(data);
    return new SortingResult(achievement.getResult(), achievement.getTimePeriod());
  }
}
