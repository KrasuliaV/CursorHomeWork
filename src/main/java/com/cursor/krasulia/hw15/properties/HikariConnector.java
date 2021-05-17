package com.cursor.krasulia.hw15.properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public enum HikariConnector {
    HIKARI_CONNECTOR() {
        @Override
        public Connection getConnection() throws SQLException {
            return dataSource.getConnection();
        }
    };

    DataSource dataSource;

    HikariConnector() {
        HikariConfig config = new HikariConfig();
        Properties configProperties = new Properties();
        final String DB_PROPERTIES = "postgre_db.properties";
        try {
            configProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(DB_PROPERTIES));

        } catch (IOException e) {
            e.printStackTrace();
        }

        config.setJdbcUrl(configProperties.getProperty("url"));
        config.setUsername(configProperties.getProperty("username"));
        config.setPassword(configProperties.getProperty("password"));

        config.setMaximumPoolSize(10);
        config.setAutoCommit(false);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        this.dataSource = new HikariDataSource(config);
    }

    public abstract Connection getConnection() throws SQLException;

}
