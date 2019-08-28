/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springjpa.entites;

import java.security.AuthProvider;
import java.util.Properties;
import javax.sql.DataSource;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"net.itta.springjpa.entites"})
public class JpaSpringConfig {
    
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
        lcemf.setDataSource(dataSource());
        lcemf.setPackagesToScan("net.itta.springjpa.entites");
        
        lcemf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
        Properties prop = new Properties();
        prop.put("show-sql", "true");
        prop.put(PersistenceUnitProperties.WEAVING, "false");
        prop.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
        prop.put(PersistenceUnitProperties.PROFILER,"PerformanceProfiler");
        lcemf.setJpaProperties(prop);
        lcemf.afterPropertiesSet();
        return lcemf;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ittamaria?zeroDateTimeBehavior=convertToNull");
        ds.setUsername("root");
        ds.setPassword("Pa$$w0rd");
        return ds;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtm;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
     @Bean
     public PersonnesService personnesService(){
         return new PersonnesService();
     }
    @Bean
     public VoitureService voitureService(){
         return new VoitureService();
     }
    
    
    
}
