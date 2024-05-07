package org.sortapp.resource;

import org.sortapp.ConfigurationManager;

class ResourceStrategyFactory {
  private final JsonParser jsonParser;
  private final ConfigurationManager configManager;

  ResourceStrategyFactory(ConfigurationManager configManager) {
    this.configManager = configManager;
    this.jsonParser = new JsonParser();
  }

  ResourceStrategy createLocalFileStrategy() {
    return new LocalFileResourceStrategy(configManager.getLocalFilePath(), jsonParser);
  }

  ResourceStrategy createHttpStrategy() {
    return new HttpResourceStrategy(configManager.getResourceUrl(), jsonParser);
  }
}
