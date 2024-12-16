package io.github.stefanodpc.libraryapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;
    
    @Bean
    public DataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10); // maximum connection pool
        config.setMinimumIdle(1); // minimun connection pool
        // raises as necessary, until hits max pool size
        config.setPoolName("library-db-pool");
        config.setMaxLifetime(600000); // 10 min in ms
        config.setConnectionTimeout(60000); // 1 min in ms
        config.setConnectionTestQuery("select 1"); // quick query to check connection

        return new HikariDataSource(config);
    }
}
