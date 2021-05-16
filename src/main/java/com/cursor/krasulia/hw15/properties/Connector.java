package com.cursor.krasulia.hw15.properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static final String POSTGRE_DB_PROPERTIES = "postgre_db.properties";
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final HikariConfig config = new HikariConfig();

    public static Connection getConnection() throws SQLException {
        setConfig();
        DataSource dataSource = new HikariDataSource(config);
        return dataSource.getConnection();
    }

    private static void setConfig() {
        Properties configProperties = new Properties();
        try {
            configProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(POSTGRE_DB_PROPERTIES));
//            Class.forName(configProperties.getProperty(DRIVER));

        } catch (IOException e) {
            e.printStackTrace();
        }

        config.setJdbcUrl(configProperties.getProperty(URL));
        config.setUsername(configProperties.getProperty(USERNAME));
        config.setPassword(configProperties.getProperty(PASSWORD));

        config.setMaximumPoolSize(10);
        config.setAutoCommit(false);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }
}
