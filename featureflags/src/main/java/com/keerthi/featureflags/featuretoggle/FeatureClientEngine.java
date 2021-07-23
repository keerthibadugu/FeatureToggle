package com.keerthi.featureflags.featuretoggle;

import com.keerthi.featureflags.config.LocalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class FeatureClientEngine {

    @Autowired
    private LocalProperties localProperties;

    private Map<String, Boolean> configMap;

    @PostConstruct
    public void load() {
        configMap = localProperties.getFeatureToggleProps();
    }

    public boolean isFeatureFlagEnabled(String value) {
        if (configMap.containsKey(value)) {
            return configMap.get(value);
        }
        return false;
    }
}
