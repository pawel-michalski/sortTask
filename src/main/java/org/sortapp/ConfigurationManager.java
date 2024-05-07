package org.sortapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationManager {
  private final Properties properties;

  public ConfigurationManager() {
    properties = new Properties();
    loadProperties();
  }

  private void loadProperties() {
    try (InputStream input =
        getClass().getClassLoader().getResourceAsStream("application.properties")) {
      if (input == null) {
        log.warn("Unable to find application.properties");
        return;
      }
      properties.load(input);
    } catch (IOException e) {
      log.error("Failed to load configuration", e);
    }
  }

  public String getResourceUrl() {
    return properties.getProperty("url", "https://zaiks.org.pl/dane/lista.json");
  }

  public String getLocalFilePath() {
    return properties.getProperty("local.file.path", "Z:/dane/lista.json");
  }
}
