package org.payment.gui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SystemPropertyConfig {

    @Value("${equens.bil.param.base_path}")
    private String basePath;

    @Value("${java.net.preferIPv4Stack}")
    private boolean preferIPv4Stack;

    @Value("${ES_PASSWORD}")
    private String esPassword;


    @Value("${ES_USERNAME}")
    private String esUsername;


    @Value("${equens.zvs.tenant.id}")
    private String tenantId;

    @Value("${com.arjuna.ats.arjuna.allowMultipleLastResources}")
    private String allowMultipleLastResources;

    @Value("${APP_HOME}")
    private String appHome;

    @PostConstruct
    public void init() {
        // Set system properties
        System.setProperty("equens.bil.param.base_path", basePath);
        System.setProperty("java.net.preferIPv4Stack", String.valueOf(preferIPv4Stack));
        System.setProperty("ES_PASSWORD", esPassword);
        System.setProperty("ES_USERNAME", esUsername);
        System.setProperty("equens.zvs.tenant.id", tenantId);
        System.setProperty("com.arjuna.ats.arjuna.allowMultipleLastResources", allowMultipleLastResources);
        System.setProperty("APP_HOME", appHome);
    }
}
