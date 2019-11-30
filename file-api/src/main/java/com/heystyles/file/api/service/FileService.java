package com.heystyles.file.api.service;

import com.heystyles.common.service.Service;
import com.heystyles.file.core.domain.File;

public interface FileService extends Service<File, Long> {

    File getFile(Long fileId);
}
