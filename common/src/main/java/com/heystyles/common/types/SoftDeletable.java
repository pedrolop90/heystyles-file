package com.heystyles.common.types;

public interface SoftDeletable {
    void setDeleted(boolean deleted);
    boolean isDeleted();
    default void markAsDeleted() {
        setDeleted(true);
    }
}
