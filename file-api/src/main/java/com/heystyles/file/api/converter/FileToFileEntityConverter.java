package com.heystyles.file.api.converter;

import com.heystyles.common.exception.APIExceptions;
import com.heystyles.file.api.dao.FileDao;
import com.heystyles.file.api.entity.FileEntity;
import com.heystyles.file.api.message.MessageKeys;
import com.heystyles.file.core.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Component
public class FileToFileEntityConverter implements Converter<File, FileEntity> {

    @Autowired
    private FileDao fileDao;

    @Autowired
    private MessageSource messageSource;

    @Override
    public FileEntity convert(File bean) {
        FileEntity document = null;
        if (bean.getId() == null) {
            document = new FileEntity();
        }
        else {
            document = Optional.ofNullable(fileDao.findOne(bean.getId()))
                    .orElseThrow(() -> APIExceptions.objetoNoEncontrado(
                            messageSource.getMessage(MessageKeys.FILE_NOT_FOUND,
                                    new String[]{String.valueOf(bean.getId())},
                                    getLocale())
                    ));
        }
        document.setBase64(bean.getBase64());
        document.setExtension(bean.getExtension());
        return document;
    }
}
