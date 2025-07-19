package com.java.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.java.dto.HomeDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface HomeDao {

	List<HomeDTO> findlist(String accept);

	HomeDTO detail(int no);

	int edit(HomeDTO homeDTO);

	int input(HomeDTO homeDTO);

	int accept(HomeDTO homeDTO);

}
