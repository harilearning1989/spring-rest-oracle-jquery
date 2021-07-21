package com.web.demo.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("hello")
    public String helloWorld() {
        return "helloWorld";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

}
