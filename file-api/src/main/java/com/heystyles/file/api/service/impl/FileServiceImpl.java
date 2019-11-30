package com.heystyles.file.api.service.impl;

import com.heystyles.common.exception.APIExceptions;
import com.heystyles.common.service.impl.ServiceImpl;
import com.heystyles.file.api.dao.FileDao;
import com.heystyles.file.api.entity.FileEntity;
import com.heystyles.file.api.message.MessageKeys;
import com.heystyles.file.api.service.FileService;
import com.heystyles.file.core.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Service
public class FileServiceImpl
        extends ServiceImpl<File, FileEntity, Long> implements FileService {

    @Autowired
    private FileDao fileDao;

    @Autowired
    private MessageSource messageSource;

    @Override
    protected CrudRepository<FileEntity, Long> getDao() {
        return fileDao;
    }

    @Override
    public File getFile(Long fileId) {
        return Optional.ofNullable(findById(fileId))
                .orElseThrow(() -> APIExceptions.objetoNoEncontrado(
                        messageSource.getMessage(MessageKeys.FILE_NOT_FOUND,
                                new String[]{String.valueOf(fileId)},
                                getLocale())
                ));
    }
}
