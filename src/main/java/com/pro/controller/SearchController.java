package com.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/search")
public class SearchController {

	@GetMapping({ "", "/" })
	public String index(Model model) {
		log.info("----- Search Controller | Index -----");
		return "web/search/search";
	}
}