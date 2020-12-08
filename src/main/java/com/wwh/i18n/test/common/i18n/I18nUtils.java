package com.wwh.i18n.test.common.i18n;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Slf4j
@Service
public class I18nUtils {
    @Autowired
    private MessageSource messageSource;

    public String getProperties(String i18nCode) {
        if (StringUtils.isBlank(i18nCode)) {
            return null;
        } else {
            try {
                Locale locale = LocaleContextHolder.getLocale();
                return this.messageSource.getMessage(i18nCode, (Object[]) null, locale);
            } catch (NoSuchMessageException var3) {
                log.info("获取配置异常!异常信息:{}", var3.getMessage());
                return null;
            }
        }
    }
}