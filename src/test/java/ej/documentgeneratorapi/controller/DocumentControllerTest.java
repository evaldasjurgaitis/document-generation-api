package ej.documentgeneratorapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ej.documentgeneratorapi.dto.InvoiceDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static ej.documentgeneratorapi.dto.InvoiceDetailsTest.createInvoiceDetails;
import static ej.documentgeneratorapi.util.TextExtractionUtil.extractPdfText;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void generateDocument_Data_InvoicePdf() throws Exception {
        InvoiceDetails invoiceDetails = createInvoiceDetails();

        ResultActions resultActions = mockMvc.perform(post("/api/documents")
                .content(asJsonString(invoiceDetails))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        String pdfContent = extractPdfText(resultActions.andReturn()
                .getResponse()
                .getContentAsByteArray());

        assertTrue(pdfContent.contains(invoiceDetails.getCustomerNo()));
        assertTrue(pdfContent.contains(invoiceDetails.getVatIdNo()));
        assertTrue(pdfContent.contains(invoiceDetails.getInvoiceNo()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getKz()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getMonotonic()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getReferenceNo()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getVin()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getCount().toString()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getPriceWithoutVat().toString()));
        assertTrue(pdfContent.contains(invoiceDetails.getCars().get(0).getPriceWithVat().toString()));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
