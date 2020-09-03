package com.petclinic.kcpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    public VetController() {
    }

    @RequestMapping("/vet")
    public String vetIndex() {
        return  "vets/index";
    }
}
