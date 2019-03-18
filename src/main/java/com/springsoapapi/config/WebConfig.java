package com.springsoapapi.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Created by Dang Dim
 * Date     : 3/18/2019, 11:57 AM
 * Email    : d.dim@gl-f.com
 */
@EnableWs
@Configuration
public class WebConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean registrationBean(ApplicationContext applicationContext) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "employees")
    public DefaultWsdl11Definition wsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("EmployeePort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://springsoapapi.com/employee/");
        definition.setSchema(schema);
        return definition;
    }

    @Bean
    public XsdSchema empSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employees.xsd"));
    }
}


