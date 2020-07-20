package ej.documentgeneratorapi.controller;

import ej.documentgeneratorapi.dto.InvoiceDetails;
import ej.documentgeneratorapi.service.DocumentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<byte[]> generateDocument(@RequestBody InvoiceDetails invoiceDetails) {
         return new ResponseEntity<>(
                documentService.generateDocument(invoiceDetails.getDocumentType(), invoiceDetails),
                getHttpHeaders(),
                HttpStatus.OK
        );
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("document.pdf", "document");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return headers;
    }

}
