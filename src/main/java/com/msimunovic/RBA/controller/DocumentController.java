package com.msimunovic.RBA.controller;

import com.msimunovic.RBA.model.DocumentData;
import com.msimunovic.RBA.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.msimunovic.RBA.util.HttpHeadersUtil.getHttpHeaders;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/document")
public class DocumentController {

  private final DocumentService documentService;

  @PostMapping
  public HttpEntity<byte[]> saveDocument(final @RequestBody DocumentData documentData) {
    final var document = documentService.saveDocument(documentData);
    final var headers = getHttpHeaders(document.getContent(), document.getName());
    return new HttpEntity<>(document.getContent(), headers);
  }

}
