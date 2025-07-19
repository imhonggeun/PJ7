package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.dao.HomeDao;
import com.java.dto.HomeDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeServiceImp implements HomeService{

	private final HomeDao homeDao;
	
	@Override
	public String findlist(Model model, HttpServletRequest req) {
		//List<HomeDTO> homeDTO = homeDao.findlist(model,req); 전체 리스트만 
		//model.addAttribute("result",homeDTO); 전체 리스트만
		
		//String accept = req.getParameter("accept");
		//if(accept == null || accept =="") accept="2";
		//List<HomeDTO> homeDTO = HomeDTO.builder().accept(accept).build();
		//model.addAttribute("result",homeDTO);
		String accept = req.getParameter("accept");
		if(accept == null || accept == "") accept ="2";
		List<HomeDTO> homeDTO = homeDao.findlist(accept);
		model.addAttribute("result", homeDTO);
		
		return "findlist";
	}

	@Override
	public String detail(Model model, HttpServletRequest req) {
		int no = Integer.parseInt(req.getParameter("no"));
		//String title = req.getParameter("title");
		//String content = req.getParameter("content");
		//HomeDTO homeDTO = HomeDTO.builder().no(no).title(title).content(content).build();
		HomeDTO homeDTO = homeDao.detail(no);
		model.addAttribute("result", homeDTO);
		return "detail";
	}

	@Override
	public String edit(HttpServletRequest req) {
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		HomeDTO homeDTO = HomeDTO.builder().no(no).title(title).content(content).build();
		homeDao.edit(homeDTO);
		return "redirect:/";
	}

	@Override
	public String input(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		HomeDTO homeDTO = HomeDTO.builder().title(title).content(content).build();
		homeDao.input(homeDTO);
		return "redirect:/";
	}

	@Override
	public String accept(HttpServletRequest req) {
		int no = Integer.parseInt(req.getParameter("no"));
		boolean accept = (req.getParameter("accept").equals("0")) ? true :false;
		HomeDTO homeDTO = HomeDTO.builder().no(no).accept(accept).build();
		homeDao.accept(homeDTO);
		return "redirect:/";
	}

}
