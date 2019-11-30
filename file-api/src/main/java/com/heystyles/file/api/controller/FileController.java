package com.heystyles.file.api.controller;

import com.heystyles.common.response.Responses;
import com.heystyles.common.types.IdResponse;
import com.heystyles.file.api.service.FileService;
import com.heystyles.file.core.domain.File;
import com.heystyles.file.core.dto.FileResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping(value = "/files")
@RestController
@Api(value = "File Controller",
        description = "Controller para el manejo de files")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "Permite Crear una Factura en la base de datos.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "File Creado.")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IdResponse> insert(
            @NotNull @Valid @RequestBody File file) {
        return Responses.responseEntity(new IdResponse(fileService.insert(file)));
    }


    @ApiOperation(value = "Permite Buscar un File de la base de datos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "File Encontrado."),
            @ApiResponse(code = 404, message = "File no encontrado.")
    })
    @GetMapping(value = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FileResponse> getFile(
            @NotNull @PathVariable(name = "fileId") Long fileId) {
        return Responses.responseEntity(new FileResponse(fileService.getFile(fileId)));
    }

}
