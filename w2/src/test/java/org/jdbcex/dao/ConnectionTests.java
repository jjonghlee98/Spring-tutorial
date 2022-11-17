package org.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTests {

    @Test
    public void testConnection() throws SQLException {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("mJjhwanl9825!@%");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtsCacheSize", "250");
        config.addDataSourceProperty("prepStmtsCacheLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);

        Connection connection = ds.getConnection();

    }

}
