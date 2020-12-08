package com.wwh.i18n.test.common.i18n;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.messages")
public class MessageConfig {
    /**
     * 国际化文件目录
     */
    private String baseFolder;

    /**
     * 国际化文件名称
     */
    private String basename;

    /**
     * 国际化编码
     */
    private String encoding;

    /**
     * 缓存刷新时间
     */
    private long cacheMillis;
}
