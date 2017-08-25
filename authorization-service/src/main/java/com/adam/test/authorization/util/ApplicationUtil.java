package com.adam.test.authorization.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
@Component
public class ApplicationUtil implements ApplicationContextAware {

    static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
