package org.sortapp.resource;

interface ResourceStrategy {
  int[] fetchData() throws ResourceException;

  boolean canFetch();
}
