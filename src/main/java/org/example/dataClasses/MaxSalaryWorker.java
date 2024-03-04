package org.example.dataClasses;

public class MaxSalaryWorker {
    private String name;
    private int salary;

    public MaxSalaryWorker(String name, String salary) {
        this.name = name;
        this.salary = Integer.parseInt(salary);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", salary=" + salary;
    }
}