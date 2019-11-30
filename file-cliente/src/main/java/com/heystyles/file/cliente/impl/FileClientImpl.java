package com.heystyles.file.cliente.impl;

import com.heystyles.common.types.IdResponse;
import com.heystyles.file.cliente.FileClient;
import com.heystyles.file.core.domain.File;
import com.heystyles.file.core.dto.FileResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class FileClientImpl implements FileClient {


    private final RestTemplate client;

    private final String urlBase;

    private interface SegmentPaths {
        String FILE = "files";
    }

    public FileClientImpl(String urlBase, RestTemplate client) {
        this.client = client;
        this.urlBase = urlBase;
    }


    @Override
    public Long save(File file) {
        UriComponentsBuilder urlBuilder = getUriClase();
        return client.postForEntity(urlBuilder.toUriString(), file, IdResponse.class).getBody().getData();
    }

    @Override
    public File getFile(Long fileId) {
        UriComponentsBuilder urlBuilder = getUriClase()
                .pathSegment(String.valueOf(fileId));
        return client.getForEntity(urlBuilder.toUriString(), FileResponse.class).getBody().getData();
    }


    private UriComponentsBuilder getUriClase() {
        return UriComponentsBuilder.fromHttpUrl(urlBase).pathSegment(SegmentPaths.FILE);
    }

}
