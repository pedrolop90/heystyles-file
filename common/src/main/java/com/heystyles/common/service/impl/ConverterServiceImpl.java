package com.heystyles.common.service.impl;

import com.heystyles.common.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

    @Autowired
    private ConversionService conversionService;

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        if (source == null) {
            return null;
        }
        return conversionService.convert(source, targetType);
    }
}
