package com.ncs.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.spring02.domain.JoDTO;
import com.ncs.spring02.model.JoDAO;

@Service
public class JoService {
	
	@Autowired
	JoDAO dao;
	
	public List<JoDTO> selectList() {
		return dao.selectList();
	}
	
	public JoDTO selectOne(int jno) {
		return dao.selectOne(jno);
	}
	
	public int insert(JoDTO dto) {
		return dao.insert(dto);
	}
	
	public int update(JoDTO dto) {
		return dao.update(dto);
	}
	
	public int delete(int jno) {
		return dao.delete(jno);
	}
	
}
