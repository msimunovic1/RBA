package com.msimunovic.RBA.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@UtilityClass
public class HttpHeadersUtil {

  public static HttpHeaders getHttpHeaders(final byte[] document, final String filename) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    headers.setContentLength(document.length);
    return headers;
  }

}
