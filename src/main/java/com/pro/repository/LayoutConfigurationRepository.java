package com.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.LayoutConfiguration;

@Repository
public interface LayoutConfigurationRepository extends JpaRepository<LayoutConfiguration, Long> {

}