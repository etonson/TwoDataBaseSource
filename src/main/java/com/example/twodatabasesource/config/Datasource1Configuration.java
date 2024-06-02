package com.example.twodatabasesource.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-05-25 下午 12:35
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.twodatabasesource.datasource.source1.repositories",
        entityManagerFactoryRef = "dataSource1EntityManagerFactory",
        transactionManagerRef = "dataSource1TransactionManager"
)
public class Datasource1Configuration {
    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties("app.datasource.a")
    public DataSourceProperties datasource1Properties() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource dataSource1() {
        DataSourceProperties dataSourceProperties = datasource1Properties();
        return DataSourceBuilder.create()
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean dataSource1EntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource1());
        factory.setPackagesToScan(new String[]{"com.example.twodatabasesource.datasource.source1.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);
        factory.setPersistenceUnitName("dataSource1EntityManagerFactory");
        return factory;
    }

    @Bean
    public PlatformTransactionManager dataSource1TransactionManager() {
        EntityManagerFactory factory = dataSource1EntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }


}
