package com.msimunovic.RBA.mapper;

import com.msimunovic.RBA.entity.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

  public Document toDocument(final String filename, final byte[] content) {
    Document document = new Document();
    document.setName(filename);
    document.setContent(content);
    return document;
  }

}
