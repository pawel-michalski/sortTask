package org.sortapp.resource;

import java.util.ArrayList;
import java.util.List;
import org.sortapp.ConfigurationManager;

public class ResourceManagerFacade {
  private final List<ResourceStrategy> resourceStrategies;
  private final ResourceStrategyFactory strategyFactory;

  public ResourceManagerFacade(ConfigurationManager configManager) {
    this.strategyFactory = new ResourceStrategyFactory(configManager);
    this.resourceStrategies = new ArrayList<>();
    initializeStrategies();
  }

  private void initializeStrategies() {
    resourceStrategies.add(strategyFactory.createLocalFileStrategy());
    resourceStrategies.add(strategyFactory.createHttpStrategy());
  }

  public int[] fetchData() throws ResourceException {
    for (ResourceStrategy strategy : resourceStrategies) {
      if (strategy.canFetch()) {
        return strategy.fetchData();
      }
    }
    throw new ResourceException("Failed to retrieve data from any available source");
  }
}
