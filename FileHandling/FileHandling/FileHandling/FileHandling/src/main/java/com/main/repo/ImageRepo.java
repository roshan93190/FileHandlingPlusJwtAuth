package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Image;

public interface ImageRepo extends JpaRepository<Image, String> {

}
