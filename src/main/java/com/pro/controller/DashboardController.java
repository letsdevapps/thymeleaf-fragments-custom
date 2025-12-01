package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.service.LayoutConfigurationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private LayoutConfigurationService layoutConfigurationService;

	@GetMapping({ "", "/" })
	public String index(Model model) {
		log.info("----- Dashboard Controller | Index -----");
		String layoutColor = layoutConfigurationService.getColor();
		model.addAttribute("layoutColor", layoutColor);
		return "web/dashboard/dashboard";
	}

	@PostMapping("/layout-color")
	public String layoutColor(@RequestParam String cor, Model model) {
		String layoutColor = layoutConfigurationService.setColor(cor).getColor();
		model.addAttribute("layoutColor", layoutColor);
		return "web/dashboard/dashboard";
	}
}