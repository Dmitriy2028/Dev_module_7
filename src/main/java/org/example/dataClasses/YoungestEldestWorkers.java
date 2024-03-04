package org.example.dataClasses;

public class YoungestEldestWorkers {
    private String name;
    private String type;

    public YoungestEldestWorkers(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", type='" + type + '\'';
    }
}
