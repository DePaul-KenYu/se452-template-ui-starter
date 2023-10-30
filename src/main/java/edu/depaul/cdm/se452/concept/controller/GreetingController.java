package edu.depaul.cdm.se452.concept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/personal-greeting")
    public String personalGreetng(
        @RequestParam(name="name", defaultValue = "Daniel") String name, 
        Model model) {
            
        model.addAttribute("name", name);
        return "greetme";
    }
}
