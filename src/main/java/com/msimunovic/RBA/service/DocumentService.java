package com.msimunovic.RBA.service;

import com.msimunovic.RBA.entity.Document;
import com.msimunovic.RBA.model.DocumentData;

public interface DocumentService {

  Document saveDocument(DocumentData documentData);

}
