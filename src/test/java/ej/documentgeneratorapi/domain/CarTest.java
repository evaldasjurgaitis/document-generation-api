package ej.documentgeneratorapi.domain;

import org.custommonkey.xmlunit.XMLTestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;

import static org.custommonkey.xmlunit.XMLUnit.setIgnoreWhitespace;

@RunWith(MockitoJUnitRunner.class)
public class CarTest extends XMLTestCase {

    private final static Long COUNT = 1L;
    private final static Double VAT = 0.00;
    private final static String KZ = "KZ";
    private final static String MONOTONIC = "ST";
    private final static String VIN_NO = "VIN_NO";
    private final static String REFERENCE_NO = "REFERENCE_NO";
    private final static BigDecimal PRICE_WITHOUT_VAT = BigDecimal.TEN;
    private final static BigDecimal PRICE_WITH_VAT = BigDecimal.TEN;

    private Marshaller marshaller;

    @Before
    public void setup() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        setIgnoreWhitespace(true);
    }

    @Test
    public void mapCar_Data_Car() {
        Car car = createCar();
        assertEquals(COUNT, car.getCount());
        assertEquals(KZ, car.getKz());
        assertEquals(MONOTONIC, car.getMonotonic());
        assertEquals(REFERENCE_NO, car.getReferenceNo());
        assertEquals(VIN_NO, car.getVin());
        assertEquals("10,00", car.getFormattedPriceWithoutVat());
        assertEquals("10,00", car.getFormattedPriceWithVat());
        assertEquals("0,00", car.getFormattedVat());
    }

    @Test
    public void parseObjectToXml_Data_Xml() throws IOException, SAXException, JAXBException {
        File file = new ClassPathResource("testCar.xml").getFile();
        String expectXml = new String(Files.readAllBytes(file.toPath()));
        StringWriter actualXml = new StringWriter();
        Car car = createCar();

        marshaller.marshal(car, actualXml);

        assertXMLEqual(expectXml, actualXml.toString());
    }

    public static Car createCar() {
        Car car = new Car();
        car.setCount(COUNT);
        car.setKz(KZ);
        car.setMonotonic(MONOTONIC);
        car.setPriceWithoutVat(PRICE_WITHOUT_VAT);
        car.setPriceWithVat(PRICE_WITH_VAT);
        car.setReferenceNo(REFERENCE_NO);
        car.setVat(VAT);
        car.setVin(VIN_NO);
        return car;
    }

}
