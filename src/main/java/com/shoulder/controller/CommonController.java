package com.shoulder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @RequestMapping(value = "/index")
    public String toIndex() {
        return "common/index";
    }
}
