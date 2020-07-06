package ej.documentgeneratorapi.service;

import ej.documentgeneratorapi.document.Document;
import ej.documentgeneratorapi.document.DocumentFactory;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final FileService fileService;

    public DocumentService(FileService fileService) {
        this.fileService = fileService;
    }

    public byte[] generateDocument(Object data) {
        DocumentFactory documentFactory = new DocumentFactory();
        Document document = documentFactory.getDocument(data);

        return fileService.generatePdf(
                document.createDocument(data),
                document.getDocumentType().getTemplateName()
        );
    }

}
