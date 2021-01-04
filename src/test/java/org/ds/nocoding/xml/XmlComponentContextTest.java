package org.ds.nocoding.xml;

import org.ds.nocoding.Component;
import org.ds.nocoding.RequestProcessor;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class XmlComponentContextTest {

    @Test
    void getComponent() {
        XmlApplicationContext xmlComponentContext = new XmlApplicationContext("D:\\workspace\\NoCoding\\src\\main\\resources\\app.xml");
        Component reveiver = xmlComponentContext.getComponent("reveiver");
        assertNotNull(reveiver);
    }

    @Test
    void containsComponent() {
    }

    @Test
    void JAXB() {
        try {
            String path = "D:\\workspace\\NoCoding\\src\\main\\resources\\app.xml";
            JAXBContext jc = JAXBContext.newInstance(ApplicationDefinition.class);
            Unmarshaller u = jc.createUnmarshaller();
            ApplicationDefinition app = (ApplicationDefinition) u.unmarshal(new File(path));
            System.out.println(app);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void request(){

        XmlApplicationContext xmlComponentContext = new XmlApplicationContext("app.xml");
        RequestProcessor requestProcessor = new RequestProcessor(xmlComponentContext);
        requestProcessor.process(null,null);
    }
}
