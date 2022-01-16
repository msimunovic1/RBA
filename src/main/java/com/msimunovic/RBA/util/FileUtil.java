package com.msimunovic.RBA.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@UtilityClass
public class FileUtil {

  private static final String DELIMITER = "\n";
  private static final String ERROR_MSG = "An error occurred.";
  private static final String FILE_PATH = "src/main/resources/files/";

  public static File createFile(final String fileName) {
    File file = new File(FILE_PATH + fileName);
    try {
      if (file.createNewFile()) {
        log.info("File created: " + file.getName());
      } else {
        log.info("File already exists.");
      }
    } catch (IOException e) {
      log.error(ERROR_MSG);
    }
    return file;
  }

  public static void writeToFile(final String filename, final List<String> values) {
    try {
      FileWriter fileWriter = new FileWriter(FILE_PATH + filename);
      values.forEach(value -> {
        try {
          fileWriter.write(value + DELIMITER);
        } catch (IOException e) {
          log.error(ERROR_MSG);
        }
      });
      fileWriter.close();
      log.info("Successfully wrote to the file.");
    } catch (IOException e) {
      log.error(ERROR_MSG);
    }
  }

  public static byte[] fileToByteArray(final File file) {
    byte[] content = null;
    try {
      content = Files.readAllBytes(file.toPath());
    } catch (IOException e) {
      log.error(ERROR_MSG);
    }
    return content;
  }

}
