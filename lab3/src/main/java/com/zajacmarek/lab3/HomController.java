package com.zajacmarek.lab3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }
}
