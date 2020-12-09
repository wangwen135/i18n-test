package com.wwh.i18n.test.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locale")
public class LocaleController {

    @GetMapping("/default")
    public Locale getDefault() {
        return Locale.getDefault();
    }

    @GetMapping("/getAll")
    public Locale[] getAll() {
        Locale[] locales = Locale.getAvailableLocales();
        return locales;
    }

}
