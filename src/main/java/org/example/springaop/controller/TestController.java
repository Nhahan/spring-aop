package org.example.springaop.controller;

import org.example.springaop.annotation.AopTarget;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @AopTarget
    @GetMapping("/around")
    public void testAopAround() {
        System.out.println("/around");
    }

    @GetMapping("/before")
    public void testAopBefore() {
        System.out.println("/before");
    }

    @GetMapping("/after")
    public void testAopAfter() {
        System.out.println("/after");
    }
} 
