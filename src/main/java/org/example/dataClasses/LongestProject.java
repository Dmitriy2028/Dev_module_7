package org.example.dataClasses;

public class LongestProject {
    private int id;
    private int monthCount;

    public LongestProject(String id, String monthCount) {
        this.id = Integer.parseInt(id);
        this.monthCount = Integer.parseInt(monthCount);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", monthCount=" + monthCount;
    }
}
