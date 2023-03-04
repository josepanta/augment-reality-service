package com.learnar.arservice.service;

import com.learnar.arservice.entity.ArImagesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ArImagesService {

    List<ArImagesEntity> getAll();

    Optional<ArImagesEntity> getById(Integer id);

    void uploadFile (MultipartFile file);

    void downloadFile (MultipartFile file);

}
