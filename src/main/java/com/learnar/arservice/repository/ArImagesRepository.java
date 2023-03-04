package com.learnar.arservice.repository;

import com.learnar.arservice.entity.ArImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArImagesRepository extends JpaRepository<ArImagesEntity, Integer> {
}
