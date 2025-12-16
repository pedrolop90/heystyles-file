package com.heystyles.common.service.impl;

import com.heystyles.common.service.ConverterService;
import com.heystyles.common.service.Service;
import com.heystyles.common.service.ValidationService;
import com.heystyles.common.types.DomainBean;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class ServiceImpl<D, E, ID extends Serializable> implements Service<D, ID> {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private ValidationService validationService;

    private Class<D> dtoClass;
    private Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public ServiceImpl() {
        this.dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected abstract CrudRepository<E, ID> getDao();

    @Override
    @Transactional(readOnly = true)
    public D findById(ID id) {
        E entity = getDao().findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        return converterService.convert(entity, dtoClass);
    }

    @Override
    @Transactional
    public ID insert(D d) {
        validationService.validate(d);
        E entity = converterService.convert(d, entityClass);
        E saved = getDao().save(entity);
        return ((DomainBean<ID>) saved).getId();
    }
}
