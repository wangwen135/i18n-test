package com.wwh.i18n.test.common.i18n;

import com.wwh.i18n.test.model.entity.I18nMessage;
import com.wwh.i18n.test.service.I18nMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class I18nInitApplicationRunner implements ApplicationRunner {

    @Autowired
    private I18nMessageService i18nMessageService;

    @Autowired
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Autowired
    private I18nUtils i18nUtils;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始初始化国际化配置文件...");
        List<I18nMessage> allmsg = i18nMessageService.getAll();
        allmsg.stream().forEach(System.out::println);

        log.info("开始生成某语言【zh_CN】");

        log.info("国际化文件创建成功");

    }
}
