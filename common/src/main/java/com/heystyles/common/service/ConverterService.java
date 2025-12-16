package com.heystyles.common.service;

public interface ConverterService {
    <T> T convert(Object source, Class<T> targetType);
}
