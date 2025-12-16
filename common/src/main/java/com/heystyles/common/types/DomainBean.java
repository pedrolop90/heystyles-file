package com.heystyles.common.types;

import java.io.Serializable;

public abstract class DomainBean<ID extends Serializable> implements Serializable {
    public abstract ID getId();
    public abstract void setId(ID id);
}
