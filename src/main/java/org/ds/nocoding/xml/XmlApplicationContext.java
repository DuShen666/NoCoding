package org.ds.nocoding.xml;

import org.ds.nocoding.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlApplicationContext implements ApplicationContext {

    protected XmlParser xmlParser = new XmlParser();

    protected ApplicationDefinition applicationDefinition;

    protected Map<String, Component> components = new HashMap<>();

    protected Map<String,Map<String,Point>> points = new HashMap<>();

    protected ComponentFactory componentFactory = new DefaultComponentFactory();


    public XmlApplicationContext(String filePath) {
        applicationDefinition = xmlParser.parse(filePath);
        createComponents();
    }

    @Override
    public Component getComponent(String id) {
        return components.get(id);
    }

    @Override
    public boolean containsComponent(String id) {
        return components.get(id) != null;
    }

    private void createComponents() {
        // 1. 根据配置信息构造所有的组件
        List<ApplicationDefinition.Component> componentDefinitions = applicationDefinition.getComponents();
        for (ApplicationDefinition.Component componentDefinition:componentDefinitions) {
            String id = componentDefinition.getId();
            if (getComponent(id) == null) {
                String className =componentDefinition.getClassName();
                List<ApplicationDefinition.Option> options = componentDefinition.getOptions();
                Component component = createComponent(id,className);
                for (ApplicationDefinition.Option option : options) {
                    component.properties().setProperty(option.getName(),option.getValue());
                }
            }
        }
        // 2. 获取所有点
        for (Component component : components.values()) {
            points.put(component.name(),component.getPoints());
        }

        // 3.根据线连接所有点
        List<ApplicationDefinition.Line> lineDefinitions = applicationDefinition.getLines();
        for (ApplicationDefinition.Line lineDefinition : lineDefinitions) {
            Map<String, Point> pointMap = points.get(lineDefinition.getComponentId());
            Point point = pointMap.get(lineDefinition.getPointName());
            List<ApplicationDefinition.To> tos = lineDefinition.getTos();
            for (ApplicationDefinition.To to : tos) {
                Map<String, Point> pointToMap = points.get(to.getComponentId());
                Point pointTo = pointToMap.get(to.getPointName());
                point.connect(pointTo);
            }
        }
    }

    private Component createComponent(String id,String className) {
        Component component = componentFactory.create(id, className);
        components.put(id, component);
        return component;
    }
}
