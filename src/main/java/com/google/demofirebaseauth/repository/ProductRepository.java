package com.google.demofirebaseauth.repository;

import com.google.demofirebaseauth.repository.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {}