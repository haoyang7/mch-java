package com.chaohong.config;

import com.chaohong.Utils.CorsUtils;
import com.chaohong.filter.MyCorsFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "chaohong.filter.cors-filter", ignoreInvalidFields = true)
public class CorsFilterConfig {

    private List<String> allowOrigin;

    /**
     * cors跨域配置
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<MyCorsFilter> getCorsFilter() {
        CorsUtils.setServerAddressList(allowOrigin);
        FilterRegistrationBean bean = new FilterRegistrationBean(new MyCorsFilter());
        bean.setOrder(0);
        return bean;
    }

    public List<String> getAllowOrigin() {
        return allowOrigin;
    }

    public void setAllowOrigin(List<String> allowOrigin) {
        this.allowOrigin = allowOrigin;
    }
}

