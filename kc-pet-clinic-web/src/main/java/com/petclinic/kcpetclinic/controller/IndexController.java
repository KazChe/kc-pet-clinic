package com.petclinic.kcpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public IndexController() {
    }

    @RequestMapping({"", "/", "index.html", "index"})
    public String index() {
        return "index";
    }

}
