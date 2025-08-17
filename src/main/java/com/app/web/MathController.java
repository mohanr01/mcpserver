package com.app.web;

import com.app.service.MathService;
import com.app.service.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application/v1/math")
public class MathController {
    @Autowired
    private MathService mathService;

    @GetMapping("/add")
    public ResponseWrapper add(@RequestParam int a, @RequestParam int b) {
        return mathService.add(a, b);
    }
}
