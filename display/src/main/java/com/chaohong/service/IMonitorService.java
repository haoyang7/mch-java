package com.chaohong.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaohong.VO.MonitorQueryVO;
import com.chaohong.entity.Monitor;

import java.util.List;

public interface IMonitorService {
    Integer saveMonitor(Monitor monitor);

    Page<Monitor> showMonitor(MonitorQueryVO monitorQueryVO);

    List<String> getIpList();

    List<String> getRequestUrlList();
}
