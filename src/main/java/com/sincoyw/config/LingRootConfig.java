package com.sincoyw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Sincoyw on 2016/6/30.
 */
@Configuration
@ComponentScan(basePackages = {"com.sincoyw"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class LingRootConfig {
}
