package com.wwh.i18n.test.common.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.io.File;
import java.util.Locale;


@Slf4j
@Configuration
public class SpringI18nConfig {

    /**
     * 默认为英语
     */
    private static final String DEFAULT_LANG = "en";

    /**
     * 应用名称
     */
    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private MessageConfig messageConfig;

    /**
     * 注册国际化解析器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new DefaultLocaleResolver();
    }

    /**
     * 配置消息资源管理器
     *
     * @return
     */
    @Primary
    @Bean(name = "messageSource")
    @DependsOn(value = "messageConfig")
    public ReloadableResourceBundleMessageSource messageSource() {
        String path = ResourceUtils.FILE_URL_PREFIX + System.getProperty("user.dir") + File.separator + messageConfig.getBaseFolder() + File.separator + messageConfig.getBasename();
        log.info("国际化配置内容:{}", messageConfig);
        log.info("国际化配置路径:{}", path);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(path);
        messageSource.setDefaultEncoding(messageConfig.getEncoding());
        messageSource.setCacheMillis(messageConfig.getCacheMillis());
        messageSource.setDefaultLocale(defaultLocal());
        return messageSource;
    }

    /**
     * 默认语言
     *
     * @return
     */
    @Bean(name = "defaultLocal")
    public Locale defaultLocal() {
        return new Locale(messageConfig.getDefaultLang() == null ? DEFAULT_LANG : messageConfig.getDefaultLang());
    }
}

