package com.ncs.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.spring02.domain.JoDTO;
import com.ncs.spring02.model.JoDAO;

@Service
public class JoServiceImpl implements JoService {
	@Autowired
	JoDAO dao;
	
	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return dao.selectList();
	}
	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO dto) {
		return dao.selectOne(dto);
	}
	// ** Insert
	@Override
	public int insert(JoDTO dto) {
		return dao.insert(dto);
	}
	// ** Update
	@Override
	public int update(JoDTO dto) {
		return dao.update(dto);
	}
	// ** Delete
	@Override
	public int delete(JoDTO dto) {
		return dao.delete(dto);
	}

}//class
