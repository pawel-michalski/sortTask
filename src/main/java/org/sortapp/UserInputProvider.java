package org.sortapp;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class UserInputProvider {

  String selectSortingAlgorithm() {
    log.info("Choose sorting algorithm:");
    log.info("1 - BubbleSort");
    log.info("2 - MergeSort");
    log.info("Your choice (default is 1): ");

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine().trim();

    return switch (input) {
      case "2" -> "merge";
      case "1", "" -> "bubble";
      default -> {
        log.info("Unknown input. Defaulting to BubbleSort.");
        yield "bubble";
      }
    };
  }
}
