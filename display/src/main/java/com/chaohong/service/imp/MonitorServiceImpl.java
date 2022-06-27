package com.chaohong.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaohong.VO.MonitorQueryVO;
import com.chaohong.dao.IMonitorMapper;
import com.chaohong.entity.Monitor;
import com.chaohong.service.IMonitorService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitorServiceImpl implements IMonitorService {

    @Autowired
    private IMonitorMapper iMonitorMapper;

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Integer saveMonitor(Monitor monitor) {
        return iMonitorMapper.insert(monitor);
    }

    @Override
    public Page<Monitor> showMonitor(MonitorQueryVO monitorQueryVO) {
        Page<Monitor> page = new Page<>();
        page.setCurrent(monitorQueryVO.getCurrent());
        page.setSize(monitorQueryVO.getSize());
        LambdaQueryWrapper<Monitor> monitorLambdaQueryWrapper = Wrappers.<Monitor>lambdaQuery();
        if (StringUtils.isNotEmpty(monitorQueryVO.getIp())) {
            monitorLambdaQueryWrapper.eq(Monitor::getIp, monitorQueryVO.getIp());
        }
        if (StringUtils.isNotEmpty(monitorQueryVO.getRequestUrl())) {
            monitorLambdaQueryWrapper.eq(Monitor::getRequestUrl, monitorQueryVO.getIp());
        }
        if (monitorQueryVO.getStartTime() != null) {
            monitorLambdaQueryWrapper.ge(Monitor::getCreateTime, monitorQueryVO.getStartTime());
        }
        if (monitorQueryVO.getEndTime() != null) {
            monitorLambdaQueryWrapper.le(Monitor::getCreateTime, monitorQueryVO.getEndTime());
        }
        return iMonitorMapper.selectPage(page, monitorLambdaQueryWrapper);
    }

    @Override
    public List<String> getIpList() {
        List<Monitor> list = iMonitorMapper.selectList(new QueryWrapper<Monitor>().select("DISTINCT IP"));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(Monitor::getIp).collect(Collectors.toList());
    }

    @Override
    public List<String> getRequestUrlList() {
        List<Monitor> list = iMonitorMapper.selectList(new QueryWrapper<Monitor>().select("DISTINCT REQUEST_URL"));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(Monitor::getRequestUrl).collect(Collectors.toList());
    }
}
