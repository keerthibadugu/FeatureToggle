package com.keerthi.featureflags.controller;

import com.keerthi.featureflags.constants.Constants;
import com.keerthi.featureflags.featuretoggle.FeatureClientEngine;
import com.keerthi.featureflags.featuretoggle.FeatureFlagEnabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/myapp")
public class FeatureFlagController {

    @Autowired
    FeatureClientEngine featureClient;

    @GetMapping
    public String getHelloResponse() {
        return "Hello";
    }


    @FeatureFlagEnabled(Constants.FEATURE_A)
    @GetMapping("/featureFlag")
    public ResponseEntity<String> getFeatureFlags() {
        return new ResponseEntity<>("Feature Flag A Enabled", HttpStatus.OK);
    }

    @GetMapping("/featureFlag1")
    public ResponseEntity<String> getFeatureFlag1() {
        if (featureClient.isFeatureFlagEnabled(Constants.FEATURE_B)) {
            return new ResponseEntity<>("Feature Flag B Enabled", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Feature Flag B Disabled", HttpStatus.NOT_FOUND);
        }
    }

}
