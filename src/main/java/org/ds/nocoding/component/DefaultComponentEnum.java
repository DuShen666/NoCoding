package org.ds.nocoding.component;

public enum DefaultComponentEnum {

    HELLO_WORLD_CONTROLLER("hello world", "");

    private String name;
    private String className;

    private DefaultComponentEnum(String name, String className) {
        this.name = name;
        this.className = className;
    }
}
