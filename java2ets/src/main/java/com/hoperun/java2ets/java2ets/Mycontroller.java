package com.hoperun.java2ets.java2ets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my")
public class Mycontroller {

    @GetMapping("firstget")
    public String firstGet(){
        return "hello";
    }
    
}
