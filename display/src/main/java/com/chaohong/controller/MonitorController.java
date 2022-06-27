package com.chaohong.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaohong.VO.MonitorQueryVO;
import com.chaohong.entity.Monitor;
import com.chaohong.service.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/display/monitor")
public class MonitorController {

    @Autowired
    private IMonitorService iMonitorService;

    @RequestMapping("/")
    public String monitor() {
        return "monitor";
    }

    @RequestMapping("/getIpList")
    public List<String> getIpList() {
        return iMonitorService.getIpList();
    }
    @RequestMapping("/getRequestUrlList")
    public List<String> getRequestUrlList() {
        return iMonitorService.getRequestUrlList();
    }

    @PostMapping("/showMonitor")
    public Page<Monitor> showMonitor(@RequestBody MonitorQueryVO monitorQueryVO) {
        return iMonitorService.showMonitor(monitorQueryVO);
    }
}
