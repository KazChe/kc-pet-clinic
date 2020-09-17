package com.petclinic.kcpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OupsController {

    @RequestMapping("/oups")
    public String oups() {
        return "notimplemented";
    }
}
