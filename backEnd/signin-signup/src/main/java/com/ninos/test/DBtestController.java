package com.ninos.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class DBtestController {


    @GetMapping("/data")
    public String home(){
        return "My Data";
    }

    @GetMapping("/user")
    public String user(){
        return "My Data user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "My Data admin";
    }

}
