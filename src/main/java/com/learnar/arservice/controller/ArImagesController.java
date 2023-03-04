package com.learnar.arservice.controller;

import com.learnar.arservice.api.ArImagesApi;
import com.learnar.arservice.entity.ArImagesEntity;
import com.learnar.arservice.model.ArImages;
import com.learnar.arservice.service.ArImagesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ArImagesController implements ArImagesApi {

    @Autowired
    private ArImagesService arImagesService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ArImagesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> save (ArImages arImages) {
        return ArImagesApi.super.save(arImages);
    }

    @Override
    public ResponseEntity<List<ArImages>> getAll() {
        List<ArImagesEntity> arImagesEntityList = arImagesService.getAll();

        return new ResponseEntity<>(arImagesEntityList.stream()
                .map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ArImages>> getById(Long id) {
        return ArImagesApi.super.getById(id);
    }

    private ArImages convertToDto(ArImagesEntity arImagesEntity) {
        return modelMapper.map(arImagesEntity, ArImages.class);
    }

    private ArImagesEntity convertToEntity(ArImages arImages) {
        return modelMapper.map(arImages, ArImagesEntity.class);
    }

}
