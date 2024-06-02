/**
 * 
 */
package com.example.twodatabasesource.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * @author Ramesh Fadatare
 * 
 */
@Configuration
public class WebMvcConfig
{
	
	@Bean
    public OpenEntityManagerInViewFilter datasource1EntityManagerInViewFilter()
    {
    	OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
    	osivFilter.setEntityManagerFactoryBeanName("dataSource1EntityManagerFactory");
    	return osivFilter;
    }
	
	@Bean
    public OpenEntityManagerInViewFilter datasource2EntityManagerInViewFilter()
    {
    	OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
    	osivFilter.setEntityManagerFactoryBeanName("dataSource2EntityManagerFactory");
    	return osivFilter;
    }
}
