package com.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.pro.model.LayoutConfiguration;
import com.pro.repository.LayoutConfigurationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LayoutConfigurationService {

	@Autowired
	private LayoutConfigurationRepository layoutConfigurationRepository;

	// Cache de escrita (atualiza a cor e invalida o cache)
	@CacheEvict(value = "layoutColor", key = "'color'")
	public LayoutConfiguration setColor(String color) {
		LayoutConfiguration lc = layoutConfigurationRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
		lc.setColor(color);
		return layoutConfigurationRepository.save(lc);
	}

	@Bean
	@Cacheable(value = "layoutColor", key = "'color'", unless = "#result == null", cacheManager = "cacheManager")
	public String getColor() {
		return layoutConfigurationRepository.findById(1L).orElseThrow(EntityNotFoundException::new).getColor();
	}
}