package ej.documentgeneratorapi.unit.service;

import ej.documentgeneratorapi.dto.InvoiceDetails;
import ej.documentgeneratorapi.service.DocumentService;
import ej.documentgeneratorapi.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static ej.documentgeneratorapi.unit.dto.InvoiceDetailsTest.createInvoiceDetails;
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
        when(fileService.generatePdf(any(), anyString())).thenReturn(new byte[1]);

        byte[] content = documentService.generateDocument(invoiceDetails);

        assertNotNull(content);
    }

}
