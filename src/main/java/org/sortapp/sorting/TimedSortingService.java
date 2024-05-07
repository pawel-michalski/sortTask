package org.sortapp.sorting;

class TimedSortingService implements SortingStrategy {
  private final SortingContext sortingContext;

  TimedSortingService(SortingContext sortingContext) {
    this.sortingContext = sortingContext;
  }

  @Override
  public JobAchievement sort(int[] data) {
    long startTime = System.currentTimeMillis();
    int[] result = sortingContext.executeSort(data);
    JobAchievement jobAchievement = new JobAchievement(result);
    jobAchievement.setTimePeriod(System.currentTimeMillis() - startTime);
    return jobAchievement;
  }
}
