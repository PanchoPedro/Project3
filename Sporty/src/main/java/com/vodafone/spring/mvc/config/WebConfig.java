package com.vodafone.spring.mvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan ({"com.vodafone.spring.mvc.config","com.vodafone.spring.mvc.config.controller","SportyShoes.Ecommerce.database","SportyShoes.Ecommerce.entity"})
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${driver}")
	private String driver;
	@Value("${url}")
	private String url;
	@Value("${dbusername}")
	private String username;
	@Value("${password}")
	private String password;
	
	public WebConfig() {
		System.out.println("web config constructor");
	}
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		vr.setPrefix("/WEB-INF/views/");
		return vr;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	@Bean
	public DataSource dataSource()
	{
		System.out.println("datasource conenction parameters");
		System.out.println(driver);
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	@Bean
	public JdbcTemplate template()
	{
		return new JdbcTemplate(dataSource());
	}
	
}
