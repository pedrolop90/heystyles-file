package com.heystyles.file.cliente;

import com.heystyles.file.core.domain.File;

public interface FileClient {

    Long save(File file);

    File getFile(Long fileId);

}
