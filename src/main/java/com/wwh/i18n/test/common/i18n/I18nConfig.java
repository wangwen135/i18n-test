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
import org.springframework.web.servlet.LocaleResolver;

import java.io.File;


@Slf4j
@Configuration
public class I18nConfig {
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
        return messageSource;
    }
}

