/**
 * 
 */
package com.usastores.cfg;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.usastores.bean.StoreBean;
import com.usastores.common.CommonConstants;

/**
 * @author kothu
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.usastores")
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	private Logger LOGGER=Logger.getLogger(SpringConfiguration.class);
	@Bean
	public ViewResolver viewResolver() {
		LOGGER.info("viewResolver method started");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsppages/");
		viewResolver.setSuffix(".jsp");
		LOGGER.info("viewResolver method Exited "+viewResolver);
		return viewResolver;
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		LOGGER.info("DataSource method started");
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(CommonConstants.DRIVER_CLASS_NAME);
		driverManagerDataSource.setUrl(CommonConstants.DB_URL);
		driverManagerDataSource.setUsername(CommonConstants.DB_USER_NAME);
		driverManagerDataSource.setPassword(CommonConstants.DB_PASSWORD);
		LOGGER.info("Datasource method Ended "+driverManagerDataSource);
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LOGGER.info("SessionFactory method started");
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setAnnotatedClasses(StoreBean.class);
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", CommonConstants.HIBERNATE_DIALECT);
		localSessionFactoryBean.setHibernateProperties(properties);
		LOGGER.info("SessionFactory method Ended "+localSessionFactoryBean);
		return  localSessionFactoryBean;
	}
	@Bean
	public HibernateTransactionManager hibernateTransaction() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		LocalSessionFactoryBean localSession = sessionFactory();
		hibernateTransactionManager.setSessionFactory(localSession.getObject());
		return hibernateTransactionManager;
	}
	@Bean	public PersistenceExceptionTranslationPostProcessor persistanceException() {
		PersistenceExceptionTranslationPostProcessor ref = new PersistenceExceptionTranslationPostProcessor();
		return ref;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
