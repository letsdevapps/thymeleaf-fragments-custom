package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.service.LayoutConfigurationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/about")
public class AboutController {

	@Autowired
	private LayoutConfigurationService layoutConfigurationService;

	@GetMapping({ "", "/" })
	public String index(Model model) {
		log.info("----- About Controller | Index -----");
		String layoutColor = layoutConfigurationService.getColor();
		model.addAttribute("layoutColor", layoutColor);
		return "web/about/about";
	}
}