package com.heystyles.common.service;

import java.io.Serializable;

public interface Service<T, ID extends Serializable> {
    ID insert(T t);
    T findById(ID id);
}
