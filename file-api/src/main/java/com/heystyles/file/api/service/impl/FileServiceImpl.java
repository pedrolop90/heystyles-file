package com.heystyles.file.api.service.impl;

import com.heystyles.common.service.impl.ServiceImpl;
import com.heystyles.file.api.dao.FileDao;
import com.heystyles.file.api.entity.FileEntity;
import com.heystyles.file.api.service.FileService;
import com.heystyles.file.core.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class FileServiceImpl
        extends ServiceImpl<File, FileEntity, Long> implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    protected CrudRepository<FileEntity, Long> getDao() {
        return fileDao;
    }

    @Override
    public File getFile(Long fileId) {
        return findById(fileId);
    }
}
