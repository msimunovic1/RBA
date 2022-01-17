package com.msimunovic.RBA.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@UtilityClass
public class DocumentUtil {

  private static final String DELIMITER = "\n";

  public static byte[] readBytes(final List<String> values) {
    final var documentContent = String.join(DELIMITER, values);
    final var inputStream = new ByteArrayInputStream(documentContent.getBytes(StandardCharsets.UTF_8));

    return inputStream.readAllBytes();
  }

}
