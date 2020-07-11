package ej.documentgeneratorapi.unit.service;

import ej.documentgeneratorapi.document.Document;
import ej.documentgeneratorapi.document.DocumentFactory;
import ej.documentgeneratorapi.document.DocumentType;
import ej.documentgeneratorapi.dto.InvoiceDetails;
import ej.documentgeneratorapi.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static ej.documentgeneratorapi.unit.dto.InvoiceDetailsTest.createInvoiceDetails;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {

    @InjectMocks
    private FileService fileService;

    @Test
    public void generatePdf_DocumentData_ByteArray() {
        InvoiceDetails invoiceDetails = createInvoiceDetails();
        DocumentFactory documentFactory = new DocumentFactory();
        Document document = documentFactory.getDocument(invoiceDetails);
        Object data = document.createDocumentContext(invoiceDetails);

        byte [] content = fileService.generatePdf(data, DocumentType.INVOICE.getTemplateName());

        assertNotNull(content);
    }

}
