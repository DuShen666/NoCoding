package org.ds.nocoding.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {
    /**
     * 缓存，避免多次解析
     */
    private final Map<String, ApplicationDefinition> cache = new HashMap<>();

    public ApplicationDefinition parse(String filePath) {
        if (cache.get(filePath) != null) {
            return cache.get(filePath);
        }
        ApplicationDefinition applicationDefinition;
        try {
            JAXBContext jc = JAXBContext.newInstance(ApplicationDefinition.class);
            Unmarshaller u = jc.createUnmarshaller();
            applicationDefinition = (ApplicationDefinition) u.unmarshal(new File(filePath));
            if (applicationDefinition != null) {
                cache.put(filePath, applicationDefinition);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return applicationDefinition;
    }
}
