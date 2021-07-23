package com.keerthi.featureflags;

import com.keerthi.featureflags.config.LocalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class FeatureflagsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureflagsApplication.class, args);
	}

}
