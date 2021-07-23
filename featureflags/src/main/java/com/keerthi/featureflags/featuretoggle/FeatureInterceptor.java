package com.keerthi.featureflags.featuretoggle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class FeatureInterceptor implements HandlerInterceptor {

    @Autowired
    private FeatureClientEngine client;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            FeatureFlagEnabled annotation = method.getMethodAnnotation(FeatureFlagEnabled.class);
            if (annotation == null) {
                annotation = method.getBeanType().getAnnotation(FeatureFlagEnabled.class);
            }
            if (annotation != null && !client.isFeatureFlagEnabled(annotation.value())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
        return true;
    }
}
