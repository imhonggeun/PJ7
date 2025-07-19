package com.java.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.java.dto.HomeDTO;
import com.java.mapper.HomeMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HomeDaoImp implements HomeDao{
	
	private final HomeMapper homeMapper;
	
	@Override
	public List<HomeDTO> findlist(String accept) {
		return homeMapper.findlist(accept);
	}

	@Override
	public HomeDTO detail(int no) {
		return homeMapper.detail(no);
	}

	@Override
	public int edit(HomeDTO homeDTO) {
		return homeMapper.edit(homeDTO);
	}

	@Override
	public int input(HomeDTO homeDTO) {
		return homeMapper.input(homeDTO);
	}

	@Override
	public int accept(HomeDTO homeDTO) {
		return homeMapper.accept(homeDTO);
	}

}
