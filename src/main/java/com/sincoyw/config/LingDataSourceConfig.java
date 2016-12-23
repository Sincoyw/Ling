package com.sincoyw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * Created by Sincoyw on 2016/8/16.
 * Desc: use profile to config data source in different environments.
 */
@Configuration
public class LingDataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ling?serverTimezone=UTC");
        driverManagerDataSource.setUsername("ling_man");
        driverManagerDataSource.setPassword("ling_man");
        return driverManagerDataSource;
    }

    //
    @Bean
    @Profile("alpha")
    public DataSource alphaDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ling?serverTimezone=UTC");
        driverManagerDataSource.setUsername("ling_man");
        driverManagerDataSource.setPassword("ling_man");
        return driverManagerDataSource;
    }

    //
    @Bean
    @Profile("beta")
    public JndiObjectFactoryBean betaJndiObjectFactoryBean() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("java:comp/env/jdbc/Ling");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return jndiObjectFactoryBean;
    }

    //
    @Bean
    @Profile("release")
    public JndiObjectFactoryBean releaseJndiObjectFactoryBean() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("java:comp/env/jdbc/Ling");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return jndiObjectFactoryBean;
    }

}
