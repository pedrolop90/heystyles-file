package com.heystyles.file.core.dto;

import com.heystyles.common.types.ListResponse;
import com.heystyles.file.core.domain.File;

import java.util.List;

public class FileListResponse extends ListResponse<File> {

    public FileListResponse() {
        super();
    }

    public FileListResponse(List<File> files) {
        super(files);
    }
}
