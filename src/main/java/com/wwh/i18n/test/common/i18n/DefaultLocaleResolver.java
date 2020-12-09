package com.wwh.i18n.test.common.i18n;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class DefaultLocaleResolver implements LocaleResolver {

    @Autowired
    private Locale defaultLocale;

    /**
     * 标记语言的key
     */
    private static final String LANG = "lang";

    /**
     * session
     */
    private static final String LANG_SESSION = "lang_session";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = null != MDC.get(LANG) ? MDC.get(LANG) : request.getHeader(LANG);
        //再从请求参数中取
        lang = lang != null ? lang : request.getParameter(LANG);

        Locale locale = defaultLocale;

        if (StringUtils.isNotBlank(lang)) {
            String[] language = lang.split("_");

            if (language.length == 1) {
                locale = new Locale(language[0]);
            } else {
                locale = new Locale(language[0], language[1]);
            }

            HttpSession session = request.getSession();
            session.setAttribute(LANG_SESSION, locale);
        } else {
            HttpSession session = request.getSession();
            Locale localeInSession = (Locale) session.getAttribute(LANG_SESSION);
            if (localeInSession != null) {
                locale = localeInSession;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
