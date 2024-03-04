package org.example.dbConfig;

import org.example.propertyReader.PropertyReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlDatabase {
    private static final MysqlDatabase INSTANCE = new MysqlDatabase();

    private static Connection mysqlConnection;

    private MysqlDatabase() {

        try {
            String mysqlConnectionUrl = PropertyReader.getConnectionUrlForMysql();
            this.mysqlConnection = DriverManager.getConnection(mysqlConnectionUrl,
                    PropertyReader.getUserForMysql(),
                    PropertyReader.getPasswordForMysql());
        } catch (SQLException e) {
            throw new RuntimeException("Create connection exception ==> " + e.getMessage());
        }
    }

    public static MysqlDatabase getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        return mysqlConnection;
    }

    public class ExecuteResultObjects{
        public String object1;
        public String object2;

        public ExecuteResultObjects(String object1, String object2){
            this.object1 = object1;
            this.object2 = object2;
        }
    }

    public List<ExecuteResultObjects> executeResult(String query, String label1, String label2 ) {
        List<ExecuteResultObjects> result = new ArrayList<>();
        try (PreparedStatement statement = mysqlConnection.prepareStatement(query)) {
            ResultSet resultSet = null;
            if (!query.trim().isEmpty()) {
                resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        result.add(new ExecuteResultObjects(resultSet.getObject(label1).toString(), resultSet.getString(label2).toString()));
                    }
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
        return result;
    }

    public void executeUpdate(String fileName) {
        try (Statement statement = mysqlConnection.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] queries = content.toString().split(";");
            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    statement.executeUpdate(query);
                }
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            mysqlConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



