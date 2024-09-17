package org.payment.gui.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.apache.tomcat.util.descriptor.web.ContextResourceLink;
import org.apache.tomcat.util.descriptor.web.NamingResources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class SpringBootConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.jndi-name}")
    private String jndiName;


    @Bean
    public ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory() {

            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();
                // Enable JNDI naming in embedded Tomcat

                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {
                // Configure JNDI DataSource

                addResource(context);


            }
        };
    }


    private void addResource(Context context) {
        ContextResource resource = new ContextResource();
        resource.setName(jndiName);
        resource.setType(DataSource.class.getName());
        resource.setProperty("driverClassName", driverClassName); //
        resource.setProperty("url", url);
        resource.setProperty("username", username);
        resource.setProperty("password", password);


        resource.setProperty("jta", "true");
        resource.setProperty("pool-name", "spotDB");
        resource.setProperty("enabled", "true");
        resource.setProperty("use-ccm", "true");
        resource.setProperty("statistics-enabled", "true");


        context.getNamingResources().addResource(resource);


        ContextResourceLink resourceLink = new ContextResourceLink();
        resourceLink.setName("java:/spotDB");
        resourceLink.setGlobal("java:/spotDB");
        resourceLink.setType("javax.sql.DataSource");
        resourceLink.setProperty("auth", "Container");

        context.getNamingResources().addResourceLink(resourceLink);

        NamingResources namingResources = context.getNamingResources();
        System.out.println("namingResources = " + namingResources);


    }

    @Bean
    public DataSource jndiDataSource() throws NamingException {
        // Create and configure JNDI DataSource
        javax.naming.Context ctx = null;
        try {
            ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/spotDB");
            return dataSource;
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }


}