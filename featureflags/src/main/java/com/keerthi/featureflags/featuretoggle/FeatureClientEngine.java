package com.keerthi.featureflags.featuretoggle;

import com.keerthi.featureflags.config.LocalProperties;
import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class FeatureClientEngine {

    @Value( "${ld.key}" )
    private String ldKey;

    @Autowired
    private LocalProperties localProperties;

    private Map<String, Boolean> configMap;

    public LDClient ldClient;
    public LDUser ldUser;

    @PostConstruct
    public void load() {
        //configMap = localProperties.getFeatureToggleProps();
        ldClient = new LDClient(ldKey);
    }

    public boolean isFeatureFlagEnabled(String featureName) {
        /**
         * We need to get the userId from OAuth token and pass to LDUser to validate against LDClient.
         */
        LDUser user = new LDUser("user@test.com");
        return ldClient.boolVariation(featureName, user, false);
    }
}
