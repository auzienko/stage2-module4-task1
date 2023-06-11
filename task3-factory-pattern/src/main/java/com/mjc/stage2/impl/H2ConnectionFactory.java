package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() throws SQLException {
        Properties properties = getConnectionProperties();
        return DriverManager.getConnection(
                properties.getProperty("db_url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );
    }

    @SneakyThrows
    private Properties getConnectionProperties() {
        Properties properties = new Properties();
        properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
        return properties;
    }
}

