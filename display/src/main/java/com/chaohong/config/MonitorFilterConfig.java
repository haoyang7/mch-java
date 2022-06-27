package com.chaohong.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "chaohong.filter.monitor-filter", ignoreInvalidFields = true)
public class MonitorFilterConfig {
    private List<String> exclusionList;

    public List<String> getExclusionList() {
        return exclusionList;
    }

    public void setExclusionList(List<String> exclusionList) {
        this.exclusionList = exclusionList;
    }
}
