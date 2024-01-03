package org.woofteam.immortalcultivationplan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class ResourceBundleMessageSourceConfig {
    @Bean
    public ResourceBundleMessageSource get(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("i18n/mesages");
        resourceBundleMessageSource.setDefaultEncoding("utf-8");
        return resourceBundleMessageSource;
    }

}
