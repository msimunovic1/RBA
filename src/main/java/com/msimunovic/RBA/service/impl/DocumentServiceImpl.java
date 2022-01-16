package com.msimunovic.RBA.service.impl;

import com.msimunovic.RBA.entity.Document;
import com.msimunovic.RBA.mapper.DocumentMapper;
import com.msimunovic.RBA.model.DocumentData;
import com.msimunovic.RBA.repository.DocumentRepository;
import com.msimunovic.RBA.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

import static com.msimunovic.RBA.util.FileUtil.createFile;
import static com.msimunovic.RBA.util.FileUtil.fileToByteArray;
import static com.msimunovic.RBA.util.FileUtil.writeToFile;

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
    final var values = List.of(documentData.getFirstname(),
            documentData.getLastname(), documentData.getOib());

    // create and write to file
    final var file = prepareFile(filename, values);

    // convert file to byte array
    final var content = fileToByteArray(file);

    // transfer data to Document entity
    final var newDocument = documentMapper.toDocument(filename, content);

    return documentRepository.save(newDocument);
  }

  private File prepareFile(final String filename, final List<String> values) {
    // create a file
    final var file = createFile(filename);
    // write to created file
    writeToFile(filename, values);
    return file;
  }

}
