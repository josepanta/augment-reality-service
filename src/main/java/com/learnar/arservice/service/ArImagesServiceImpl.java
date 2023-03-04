package com.learnar.arservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.learnar.arservice.entity.ArImagesEntity;
import com.learnar.arservice.model.ArImages;
import com.learnar.arservice.repository.ArImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ArImagesServiceImpl implements ArImagesService {

    @Autowired
    private ArImagesRepository arImagesRepository;

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public List<ArImagesEntity> getAll() {
        List<ArImagesEntity> arImagesEntityList = arImagesRepository.findAll();

        return arImagesEntityList;
    }

    @Override
    public Optional<ArImagesEntity> getById(Integer id) {
        Optional<ArImagesEntity> arImagesEntity = arImagesRepository.findById(id);

        return arImagesEntity;
    }

    @Override
    public void uploadFile(MultipartFile file) {
        File mainFile = new File(file.getOriginalFilename());

        try (FileOutputStream stream = new FileOutputStream(mainFile)){
            stream.write(file.getBytes());
            PutObjectRequest request = new PutObjectRequest(bucketName, file.getOriginalFilename(), mainFile);
            amazonS3.putObject(request);
        } catch (IOException e) {

        }
    }

    @Override
    public void downloadFile(MultipartFile file) {

    }
}
