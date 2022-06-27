package com.chaohong.VO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MonitorQueryVO {
    private long size;
    private long current;
    private String ip;
    private String requestUrl;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
