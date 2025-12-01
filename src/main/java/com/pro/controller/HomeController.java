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
@RequestMapping({ "", "/" })
public class HomeController {

	@Autowired
	private LayoutConfigurationService layoutConfigurationService;

	@GetMapping({ "", "/", "/home", "/index" })
	public String index(Model model) {
		log.info("----- Home Controller | Index -----");
		String layoutColor = layoutConfigurationService.getColor();
		model.addAttribute("layoutColor", layoutColor);
		return "web/home/home";
	}
}