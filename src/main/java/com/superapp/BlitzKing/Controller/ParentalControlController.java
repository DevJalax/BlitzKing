package com.superapp.BlitzKing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.BlitzKing.Service.ParentalControlService;

@RestController
@RequestMapping("/parental-control")
public class ParentalControlController {
	
    private final ParentalControlService parentalControlService;

    @Autowired
    public ParentalControlController(ParentalControlService parentalControlService) {
        this.parentalControlService = parentalControlService;
    }

    @GetMapping("/restricted-content/{age}")
    public List<String> getRestrictedContentForAge(@PathVariable int age) {
        return parentalControlService.getRestrictedContentForAge(age);
    }
}
