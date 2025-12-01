package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.model.Product;
import com.pro.service.LayoutConfigurationService;
import com.pro.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private LayoutConfigurationService layoutConfigurationService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "", "/" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String index(@RequestParam(defaultValue = "", value = "searchText") String searchText,
			@RequestParam(defaultValue = "0", value = "page") int page, Model model) {
		log.info("----- Search Controller | Index -----");
		String layoutColor = layoutConfigurationService.getColor();
		model.addAttribute("layoutColor", layoutColor);

		Pageable pageable = PageRequest.of(page, 10);
		Page<Product> productsPageable;

		if (!searchText.isEmpty()) {
			productsPageable = productService.findByName(searchText, pageable);
		} else {
			productsPageable = productService.findAll(pageable);
		}

		model.addAttribute("searchText", searchText);
		model.addAttribute("productsPageable", productsPageable);

		return "web/search/search";
	}
}