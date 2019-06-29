package com.app2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("spanish")
public class SpanishLangImpl implements LanguageService {

    @Override
    public String printHello() {
        return "hola";
    }
}
