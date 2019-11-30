package com.heystyles.file.api.dao;

import com.heystyles.file.api.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao extends JpaRepository<FileEntity, Long> {
}
