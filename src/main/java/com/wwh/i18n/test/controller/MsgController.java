package com.wwh.i18n.test.controller;

import com.wwh.i18n.test.common.i18n.I18nUtils;
import com.wwh.i18n.test.model.entity.I18nMessage;
import com.wwh.i18n.test.service.I18nMessageService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private I18nMessageService i18nMessageService;

    @Autowired
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Autowired
    private I18nUtils i18nUtils;

    @GetMapping("/getAll")
    public List<I18nMessage> getAll() {
        return i18nMessageService.getAll();
    }

    @GetMapping("/test")
    public Map<String, String> getMsg() {
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("random", RandomStringUtils.randomAlphabetic(22));
        msgMap.put("key1", "bbbbbb");
        return msgMap;
    }

    @GetMapping("/getLang")
    public String getLang() {
        Locale locale = LocaleContextHolder.getLocale();
        return locale.toString();
    }

    @GetMapping("/baseName")
    public Set<String> getAllByLang() {
        return reloadableResourceBundleMessageSource.getBasenameSet();
    }

    public void xxx(){

    }

    @GetMapping("/getByKey")
    public String getByKey(String key) {
        return i18nUtils.getProperties(key);
    }
}
