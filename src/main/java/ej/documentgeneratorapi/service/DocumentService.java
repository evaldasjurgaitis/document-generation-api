package ej.documentgeneratorapi.service;

import ej.documentgeneratorapi.domain.document.Document;
import ej.documentgeneratorapi.domain.document.DocumentFactory;
import ej.documentgeneratorapi.domain.document.DocumentType;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final FileService fileService;
    private final DocumentFactory documentFactory;

    public DocumentService(FileService fileService) {
        this.fileService = fileService;
        this.documentFactory = new DocumentFactory();
    }

    public <T> byte[] generateDocument(DocumentType documentType, T data) {
        Document document = documentFactory.createDocument(documentType, data);
        return fileService.generatePdf(document);
    }

}
