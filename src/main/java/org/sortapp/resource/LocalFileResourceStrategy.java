package org.sortapp.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class LocalFileResourceStrategy implements ResourceStrategy {

  private final String path;
  private final JsonParser jsonParser;

  LocalFileResourceStrategy(String path, JsonParser jsonParser) {
    this.path = path;
    this.jsonParser = jsonParser;
  }

  @Override
  public int[] fetchData() throws ResourceException {
    try {
      String content = Files.readString(Paths.get(path));
      return jsonParser.parse(content);
    } catch (IOException e) {
      throw new ResourceException("Failed to read the file: " + path, e);
    }
  }

  @Override
  public boolean canFetch() {
    return Files.exists(Paths.get(path));
  }
}
