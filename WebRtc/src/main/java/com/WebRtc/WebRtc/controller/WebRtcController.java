package com.WebRtc.WebRtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebRtcController {

    @GetMapping("/")
    public String index() {
        return "index"; // Refers to src/main/resources/templates/index.html
    }
}