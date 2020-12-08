package com.wwh.i18n.test.service.impl;

import com.wwh.i18n.test.dao.I18nMessageDao;
import com.wwh.i18n.test.model.entity.I18nMessage;
import com.wwh.i18n.test.service.I18nMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class I18nMessageServiceImpl implements I18nMessageService {

    @Autowired
    private I18nMessageDao i18nMessageDao;

    @Override
    public List<I18nMessage> getAll() {
        return i18nMessageDao.selectAll();
    }
}
