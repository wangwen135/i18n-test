package com.wwh.i18n.test.dao;

import com.wwh.i18n.test.common.Mapper.BaseMapper;
import com.wwh.i18n.test.model.entity.I18nMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface I18nMessageDao extends BaseMapper<I18nMessage> {
}
