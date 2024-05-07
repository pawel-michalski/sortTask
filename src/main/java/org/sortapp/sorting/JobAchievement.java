package org.sortapp.sorting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class JobAchievement {
  private int[] result;
  private long timePeriod;

  public JobAchievement(int[] result) {
    this.result = result;
  }
}
