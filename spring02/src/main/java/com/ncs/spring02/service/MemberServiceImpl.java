package com.ncs.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.spring02.domain.MemberDTO;
import com.ncs.spring02.model.MemberDAO;



@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;
	// IOC/DI 적용, 자동주입 
	// -> 어딘가에서 이미 생성되어 있어야 한다(@ or xml or jc)
	
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}
	@Override
	public List<MemberDTO> selectList(int jno) {
		return dao.selectList(jno);
	}
	
	@Override
	public List<MemberDTO> selectJoList(int jno) {
		return dao.selectJoList(jno);
	}
	
	@Override
	public MemberDTO selectOne(String id) {
		return dao.selectOne(id);
	}
	
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	
	@Override
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(String id) {
		return dao.delete(id);
	}
	
	
}
