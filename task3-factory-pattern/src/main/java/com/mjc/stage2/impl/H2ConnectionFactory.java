package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class H2ConnectionFactory implements ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(H2ConnectionFactory.class.getName());

    @Override
    public Connection createConnection() {
        try {
            Properties properties = new Properties();
            properties.load(
                    H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));

            return DriverManager.getConnection(properties.getProperty("db_url"), properties.getProperty("user"), properties.getProperty("password"));
        } catch (IOException | SQLException e) {
            LOGGER.warning("Failed to get connection to database!");
        }
        return null;
    }
}

