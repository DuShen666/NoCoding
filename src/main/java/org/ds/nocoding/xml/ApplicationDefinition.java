package org.ds.nocoding.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 12/25/20 4:44 PM
 *
 * @author duwenbo
 */
@XmlRootElement(name = "app")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationDefinition {
    @XmlElementWrapper(name = "components")
    @XmlElement(name = "component")
    private List<Component> components;

    @XmlElementWrapper(name = "lines")
    @XmlElement(name = "line")
    private List<Line> lines;

    public List<Component> getComponents() {
        return components;
    }

    public List<Line> getLines() {
        return lines;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Component {

        @XmlAttribute(name = "id")
        private String id;

        @XmlAttribute(name = "class")
        private String className;

        @XmlElement(name = "option")
        private List<Option> options;

        public String getId() {
            return id;
        }

        public String getClassName() {
            return className;
        }

        public List<Option> getOptions() {
            return options;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Option {
        @XmlAttribute(name = "name")
        private String name;

        @XmlAttribute(name = "value")
        private String value;

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Line {

        @XmlElement(name = "to")
        private List<To> tos;

        @XmlAttribute(name = "component")
        private String componentId;

        @XmlAttribute(name = "point")
        private String pointName;

        public List<To> getTos() {
            return tos;
        }

        public String getComponentId() {
            return componentId;
        }

        public String getPointName() {
            return pointName;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class To {
        @XmlAttribute(name = "component")
        private String componentId;

        @XmlAttribute(name = "point")
        private String pointName;

        public String getComponentId() {
            return componentId;
        }

        public String getPointName() {
            return pointName;
        }
    }
}
