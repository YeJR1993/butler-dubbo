package com.tuxiaoer.shanghai.common.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.Assert;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/4/25 15:04
 * @description：spring bean 名称生成规则
 */
public class AnnotationBeanNameGenerator implements BeanNameGenerator {

    /**
     * 通过全类名生成beanName
     * @param beanDefinition
     * @param beanDefinitionRegistry
     * @return
     */
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        String beanClassName = beanDefinition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        return beanClassName;
    }
}
