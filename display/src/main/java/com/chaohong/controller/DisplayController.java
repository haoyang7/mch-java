package com.chaohong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/display")
public class DisplayController {

    @RequestMapping("/crone")
    public String crone() {
        return "crone";
    }

    @RequestMapping("/conveyor")
    public String conveyor() {
        return "conveyor";
    }

}
