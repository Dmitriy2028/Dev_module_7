package org.example.dataClasses;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, String projectCount) {
        this.name = name;
        this.projectCount = Integer.parseInt(projectCount);
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", projectCount=" + projectCount;
    }
}
