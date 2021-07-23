package com.keerthi.featureflags.config;

import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties("app.featuretoggle")
public class LocalProperties {

    private final Map<String, Boolean> featureToggleProps = Maps.newHashMap();
}
