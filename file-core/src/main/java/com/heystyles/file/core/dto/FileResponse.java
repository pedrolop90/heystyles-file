package com.heystyles.file.core.dto;

import com.heystyles.common.types.ObjectResponse;
import com.heystyles.file.core.domain.File;

public class FileResponse extends ObjectResponse<File> {

    public FileResponse() {
        super();
    }

    public FileResponse(File file) {
        super(file);
    }
}
