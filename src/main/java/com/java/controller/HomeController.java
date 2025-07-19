package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.service.HomeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final HomeService  homeService;
	
	@GetMapping("/")
	public String findlist(Model model, HttpServletRequest req) {
		return homeService.findlist(model, req);
	}
	@GetMapping("/detail")
	public String detail(Model model, HttpServletRequest req) {
		return homeService.detail(model,req);
	}
	@PostMapping("/edit")
	public String edit(HttpServletRequest req) {
		return homeService.edit(req);
	}
	
	@GetMapping("/input")
	public String input() {
		return "input";
	}
	@PostMapping("/input")
	public String input(HttpServletRequest req) {
		return homeService.input(req);
	}
	
	@GetMapping("/accept")
	public String accept(HttpServletRequest req) {
		return homeService.accept(req);
	}
	
		

}
