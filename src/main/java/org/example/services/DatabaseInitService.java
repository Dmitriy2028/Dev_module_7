package org.example.services;

import org.example.dbConfig.MysqlDatabase;


public class DatabaseInitService {
    public static void main(String[] args) {
        MysqlDatabase mysqlDatabase = MysqlDatabase.getInstance();
        mysqlDatabase.executeUpdate("src/main/resources/sql/init_db.sql");
    }
}
