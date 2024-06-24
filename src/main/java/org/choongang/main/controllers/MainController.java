package org.choongang.main.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping //http://localhost:3000/project/main/index.jsp
    public String index() { //main 화면
        return "main/index";
    }
}
