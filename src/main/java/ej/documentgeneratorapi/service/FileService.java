package ej.documentgeneratorapi.service;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileService {

    public byte[] generatePdf(Object data, String documentTemplateName) {
        try (InputStream config = this.getClass().getResourceAsStream("/fop.xconf")) {
            String xsltPath = "src/main/resources/xslt/" + documentTemplateName + ".xsl";
            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();

            FopFactory fopFactory = createFopFactoryInstanceWithConfig(config);
            FOUserAgent foUserAgent = userAgentConfiguration(fopFactory);

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, pdfOutStream);
            Transformer transformer = createTransformer(xsltPath);

            Source sourceData = castRequestToJaxbSource(data);
            Result resultAfterTransformation = new SAXResult(fop.getDefaultHandler());
            transformer.transform(sourceData, resultAfterTransformation);

            return pdfOutStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static FopFactory createFopFactoryInstanceWithConfig(InputStream config) {
        try {
            return FopFactory.newInstance(new File(".").toURI(), config);
        } catch (SAXException | IOException e) {
            throw new RuntimeException("An error occurred while creating FOP Factory with given configuration", e);
        }
    }

    private Transformer createTransformer(String xsltPath) {
        Transformer transformer = null;
        try {
            //XSLT processor should be able to resolve any relative imports or includes.
            StreamSource transformSource = new StreamSource(xsltPath);
            TransformerFactory factory = TransformerFactory.newInstance();
            transformer = factory.newTransformer(transformSource);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException("An error occurred while creating FOP Transformer", e);
        }
        return transformer;
    }

    private FOUserAgent userAgentConfiguration(FopFactory fopFactory) {
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        return foUserAgent;
    }

    private Source castRequestToJaxbSource(Object object) {
        Source source = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            source = new JAXBSource(jaxbMarshaller, object);
        } catch (JAXBException e) {
            throw new RuntimeException("An error occurred while marshalling request data", e);
        }

        return source;
    }

}
