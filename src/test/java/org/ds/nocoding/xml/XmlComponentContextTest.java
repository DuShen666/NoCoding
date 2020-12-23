package org.ds.nocoding.xml;

import org.ds.nocoding.Component;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class XmlComponentContextTest {

    @org.junit.jupiter.api.Test
    void getComponent() {
        XmlComponentContext xmlComponentContext = new XmlComponentContext("D:\\workspace\\NoCoding\\src\\main\\resources\\app.xml");
        Component reveiver = xmlComponentContext.getComponent("reveiver");
        assertNotNull(reveiver);
    }

    @org.junit.jupiter.api.Test
    void containsComponent() {
    }
}