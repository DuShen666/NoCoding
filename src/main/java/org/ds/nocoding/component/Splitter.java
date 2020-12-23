package org.ds.nocoding.component;

import com.dd.Component;

import java.util.List;

public interface Splitter extends Component {

    Component getFrom();

    void setFrom(Component from);

    List<Component> getTo();

    void setTo(List<Component> tos);
}
