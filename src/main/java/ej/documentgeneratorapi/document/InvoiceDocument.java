package ej.documentgeneratorapi.document;

import ej.documentgeneratorapi.domain.Car;
import ej.documentgeneratorapi.domain.Invoice;
import ej.documentgeneratorapi.dto.CarDetails;
import ej.documentgeneratorapi.dto.InvoiceDetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceDocument implements Document {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Object createDocument(Object data) {
        Invoice invoice = mapDtoToEntity((InvoiceDetails) data);
        return invoice;
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.INVOICE;
    }

    private Invoice mapDtoToEntity(InvoiceDetails invoiceDetails) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceNo(invoiceDetails.getInvoiceNo());
        invoice.setCustomerNo(invoiceDetails.getCustomerNo());
        invoice.setVatIdNo(invoiceDetails.getVatIdNo());
        invoice.setDate(DATE_FORMAT.format(invoiceDetails.getDate() == null ? new Date() : invoiceDetails.getDate()));
        invoice.setCars(mapDtoToEntity(invoiceDetails.getCars()));
        return invoice;
    }

    private List<Car> mapDtoToEntity(List<CarDetails> carDetails) {
        return carDetails.stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());
    }

    private Car mapDtoToEntity(CarDetails carDetails) {
        Car car = new Car();
        car.setKz(carDetails.getKz());
        car.setReferenceNo(carDetails.getReferenceNo());
        car.setVin(carDetails.getVin());
        car.setCount(carDetails.getCount());
        car.setMonotonic(carDetails.getMonotonic());
        car.setVat(carDetails.getVat());
        car.setPriceWithoutVat(carDetails.getPriceWithoutVat());
        car.setPriceWithVat(carDetails.getPriceWithVat());
        return car;
    }

}
