package com.keerthi.featureflags.config;

import com.keerthi.featureflags.featuretoggle.FeatureInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FeatureToggleConfig implements WebMvcConfigurer {

    @Autowired
    private FeatureInterceptor featureInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(featureInterceptor);
    }
}
