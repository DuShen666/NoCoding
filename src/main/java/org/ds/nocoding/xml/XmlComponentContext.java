package org.ds.nocoding.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.ds.nocoding.*;

import java.util.*;

public class XmlComponentContext implements ApplicationContext {

    protected ElementLoader elementLoader = new ElementLoaderImpl();

    protected DocumentHolder documentHolder = new XMLDocumentHolder();

    protected Map<String, Component> components = new HashMap<>();

    protected List<Point> points = new ArrayList<>();

    protected ComponentFactory componentFactory = new DefaultComponentFactory();

    protected ElementReader elementReader = new ElementReaderImpl();

    public XmlComponentContext(String filePath){
        Document document = documentHolder.getDocument(filePath);
        elementLoader.addElements(document);
        createComponents();

    }

    @Override
    public Component getComponent(String id) {
        return components.get(id);
    }

    @Override
    public boolean containsComponent(String id) {
        Element element = elementLoader.getElement(id);
        return element != null;
    }

    private void createComponents() {
        Collection<Element> elements = elementLoader.getElements();
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String className = element.attributeValue("class");

            if (id!=null&&!"".equalsIgnoreCase(id)&&className!=null&&!"".equalsIgnoreCase(className)){

                String[] split = className.split("\\.");
                if (split.length>0){
                    id = split[0];
                }else {
                    continue;
                }
            }
            Component component = getComponent(id);
            if (component == null) {
                createComponent(id);
            }
        }
        for (Element element : elements){
            String id = element.attributeValue("id");
            String nextId = element.attributeValue("next");
            if (nextId!=null&&!"".equalsIgnoreCase(nextId)){
                Component component = components.get(id);
                if (component!=null){
                    component.setNext(components.get(nextId));
                }
            }
        }
    }

    private void createComponent(String id) {
        Element e = elementLoader.getElement(id);
        if (e == null) {
            throw new RuntimeException("element not found" + id);
        }
        String className = e.attributeValue("class");
        components.put(id,componentFactory.create(className));

    }
}
