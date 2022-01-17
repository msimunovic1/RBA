package com.msimunovic.RBA.service.impl;

import com.msimunovic.RBA.entity.Document;
import com.msimunovic.RBA.mapper.DocumentMapper;
import com.msimunovic.RBA.model.DocumentData;
import com.msimunovic.RBA.repository.DocumentRepository;
import com.msimunovic.RBA.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.msimunovic.RBA.util.DocumentUtil.readBytes;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

  private static final String FILE_EXTENSION_TXT = ".txt";

  private final DocumentRepository documentRepository;
  private final DocumentMapper documentMapper;

  @Override
  public Document saveDocument(final DocumentData documentData) {
    final var filename = "DOCUMENT_" + documentData.getOib() + FILE_EXTENSION_TXT;
    final var values = List.of(
            documentData.getFirstname(),
            documentData.getLastname(),
            documentData.getOib());

    final var newDocument = documentMapper.toDocument(filename, readBytes(values));
    return documentRepository.save(newDocument);
  }

}
