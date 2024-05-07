package org.sortapp;

public class Utils {
  private Utils() {}

  public static String arrayToString(int[] array) {
    StringBuilder builder = new StringBuilder("[");
    for (int i = 0; i < array.length; i++) {
      builder.append(array[i]);
      if (i < array.length - 1) {
        builder.append(", ");
      }
    }
    builder.append("]");
    return builder.toString();
  }
}
