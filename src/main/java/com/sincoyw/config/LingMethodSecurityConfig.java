package com.sincoyw.config;

import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by heaven on 17-1-17.
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LingMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        //TODO: next step.
        return super.createExpressionHandler();
    }
}
