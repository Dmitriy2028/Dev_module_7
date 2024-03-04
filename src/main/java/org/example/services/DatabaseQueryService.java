package org.example.services;

import org.example.dataClasses.*;
import org.example.dbConfig.MysqlDatabase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    static MysqlDatabase mysqlDatabase = MysqlDatabase.getInstance();

    public static void main(String[] args) throws SQLException {
        System.out.println("MaxProjectCountClient:");
        List<MaxProjectCountClient> maxProjectCountClients = findMaxProjectsClient();
        for (MaxProjectCountClient maxProjectCountClient : maxProjectCountClients){
            System.out.println(maxProjectCountClient.toString());
        }

        System.out.println("\nMaxSalaryWorker:");
        List<MaxSalaryWorker> maxSalaryWorkers = findMaxSalaryWorker();
        for (MaxSalaryWorker maxSalaryWorker : maxSalaryWorkers){
            System.out.println(maxSalaryWorker.toString());
        }

        System.out.println("\nYoungestEldestWorkers:");
        List<YoungestEldestWorkers> youngestEldestWorkers =findYoungestEldestWorkers();
        for (YoungestEldestWorkers youngestEldestWorker : youngestEldestWorkers){
            System.out.println(youngestEldestWorker.toString());
        }

        System.out.println("\nLongestProjects:");
        List<LongestProject> longestProjects =findLongestProject();
        for (LongestProject longestProject : longestProjects){
            System.out.println(longestProject.toString());
        }
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String fileName = "src/main/resources/sql/find_max_projects_client.sql";
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] queries = content.toString().split(";");
        for (String query : queries) {
            for (MysqlDatabase.ExecuteResultObjects objects : mysqlDatabase.executeResult(query, "client_name", "project_count")) {
                result.add(new MaxProjectCountClient(objects.object1, objects.object2));
            }
        }
        return result;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String fileName = "src/main/resources/sql/find_max_salary_worker.sql";
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] queries = content.toString().split(";");
        for (String query : queries) {
            for (MysqlDatabase.ExecuteResultObjects objects : mysqlDatabase.executeResult(query, "name", "salary")) {
                result.add(new MaxSalaryWorker(objects.object1, objects.object2));
            }
        }
        return result;
    }

    public static List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        String fileName = "src/main/resources/sql/find_youngest_eldest_workers.sql";
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] queries = content.toString().split(";");
        for (String query : queries) {
            for (MysqlDatabase.ExecuteResultObjects objects : mysqlDatabase.executeResult(query, "name", "TYPE")) {
                result.add(new YoungestEldestWorkers(objects.object1, objects.object2));
            }
        }
        return result;
    }

    public static List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> result = new ArrayList<>();
        String fileName = "src/main/resources/sql/find_longest_project.sql";
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] queries = content.toString().split(";");
        for (String query : queries) {
            for (MysqlDatabase.ExecuteResultObjects objects : mysqlDatabase.executeResult(query, "id", "month_count")) {
                result.add(new LongestProject(objects.object1, objects.object2));
            }
        }
        return result;
    }
}
