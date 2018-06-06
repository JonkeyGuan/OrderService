package com.test.order;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:META-INF/spring/camel-route.xml" })
public class SimpleBootCxfApplication extends SpringBootServletInitializer{

	@Bean
	public ServletRegistrationBean cxfServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplication(SimpleBootCxfApplication.class).run(args);
		CamelSpringBootApplicationController applicationController = applicationContext
				.getBean(CamelSpringBootApplicationController.class);
		applicationController.run();
	}
}
