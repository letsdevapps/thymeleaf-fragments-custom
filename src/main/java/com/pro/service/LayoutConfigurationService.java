package com.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.pro.model.LayoutConfiguration;
import com.pro.repository.LayoutConfigurationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LayoutConfigurationService {

	@Autowired
	private LayoutConfigurationRepository layoutConfigurationRepository;

	public LayoutConfiguration setColor(String color) {
		LayoutConfiguration lc = layoutConfigurationRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
		lc.setColor(color);
		return layoutConfigurationRepository.save(lc);
	}

	@Bean
	public String getColor() {
		return layoutConfigurationRepository.findById(1L).orElseThrow(EntityNotFoundException::new).getColor();
	}
}