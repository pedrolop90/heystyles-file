package com.heystyles.file.api.converter;

import com.heystyles.file.api.entity.FileEntity;
import com.heystyles.file.core.domain.File;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FileEntityToFileConverter implements Converter<FileEntity, File> {

    @Override
    public File convert(FileEntity document) {
        File bean = new File();
        bean.setId(document.getId());
        bean.setBase64(document.getBase64());
        bean.setExtension(document.getExtension());
        return bean;
    }
}
