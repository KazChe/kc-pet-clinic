package com.petclinic.kcpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping("/owner")
    public String getOwnerList() {

        return "owners/index";
    }
}
