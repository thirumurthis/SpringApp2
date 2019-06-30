package com.app2.controller;

import com.app2.service.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    public void sayHello(){
        System.out.println(languageService.printHello());
    }
}
