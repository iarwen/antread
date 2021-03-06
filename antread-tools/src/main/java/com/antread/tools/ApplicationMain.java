package com.antread.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages="com.antread")
@ConfigurationProperties(prefix = "spring.application")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ApplicationMain {
	private static Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

	private static String desc;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
		logger.debug(desc + " started success");
	}

	public static void setDesc(String desc) {
		ApplicationMain.desc = desc;
	}
	public static String getDesc() {
		return desc;
	}
	

}
