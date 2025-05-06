package com.viongJewellery.util;

import java.beans.PropertyDescriptor;

import org.springframework.stereotype.Component;



@Component("beanUtil")
public class BeanUtil {
    public Object getValue(Object bean, String fieldName) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(fieldName, bean.getClass());
            return pd.getReadMethod().invoke(bean);
        } catch (Exception e) {
            return null;
        }
    }
}
