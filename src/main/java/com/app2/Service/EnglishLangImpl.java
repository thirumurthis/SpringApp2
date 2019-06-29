package com.app2.Service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default","english"})
public class EnglishLangImpl implements LanguageService {
    @Override
    public String printHello() {
        return "hello";
    }
}
