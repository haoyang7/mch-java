package com.chaohong.filter;

import com.chaohong.Utils.NetUtils;
import com.chaohong.config.MonitorFilterConfig;
import com.chaohong.entity.Monitor;
import com.chaohong.service.IMonitorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter
@Slf4j
public class MonitorFilter extends HttpFilter {
    @Autowired
    private IMonitorService iMonitorService;
    @Autowired
    private MonitorFilterConfig monitorFilterConfig;


    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info(request.getRemoteAddr() + " " + request.getMethod() + " " + request.getRequestURI());
        if (!monitorFilterConfig.getExclusionList().contains(request.getRequestURI())) {
            String ipAddr = NetUtils.getIpAddr(request);
            if (StringUtils.isNotEmpty(ipAddr)) {
                Monitor monitor = new Monitor();
                monitor.setCreateTime(LocalDateTime.now());
                monitor.setRequestUrl(request.getRequestURI());
                monitor.setIp(ipAddr);
                iMonitorService.saveMonitor(monitor);
            }
        }
        chain.doFilter(request, response);
    }
}