package com.chaohong.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("MONITOR")
public class Monitor {
    private Long id;
    private String ip;
    private String requestUrl;
    private LocalDateTime createTime;

}
