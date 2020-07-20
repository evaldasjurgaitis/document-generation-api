package ej.documentgeneratorapi.service;

import ej.documentgeneratorapi.domain.document.DocumentFactory;
import ej.documentgeneratorapi.dto.InvoiceDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static ej.documentgeneratorapi.dto.InvoiceDetailsTest.createInvoiceDetails;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private DocumentService documentService;

    @Test
    public void generateDocument_Data_ByteArray() {
        InvoiceDetails invoiceDetails = createInvoiceDetails();
        when(fileService.generatePdf(any())).thenReturn(new byte[1]);

        byte[] content = documentService.generateDocument(invoiceDetails.getDocumentType(), invoiceDetails);

        assertNotNull(content);
    }

}
