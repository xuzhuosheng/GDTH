package com.example.gdtheurekaproviderxtgn.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GdthEurekaComsumerWebController {


    @RequestMapping("/getMessage")
    public String getMessage() {
        return "this is GdthEurekaComsumerWebController ";
    }
}
