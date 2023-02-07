package com.arsen.repositories;

import com.arsen.entity.NewsMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsMSRepository extends JpaRepository<NewsMS, Long> {}
