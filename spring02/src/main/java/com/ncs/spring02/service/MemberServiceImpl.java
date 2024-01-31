package com.ncs.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.spring02.domain.MemberDTO;
import com.ncs.spring02.model.MemberDAO;

//** Service
//=> 요청클래스 와 DAO클래스 사이의 연결(완충지대) 역할
//=> 요청클래스(컨트롤러) 와 DAO클래스 사이에서 변경사항이 생기더라도 서로 영향	받지않도록해주는 역할
// 결합도는 낮추고, 응집도는 높인다

//** interface 자동완성 
//=> Alt + Shift + T  
//=> 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...

@Service
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	@Autowired
	MemberDAO dao;
	//MemberDAO dao = new MemberDAO();
	
	// ** selectJoList
	// => 조별 맴버 검색
	@Override
	public List<MemberDTO> selectJoList(int jno) {
		return dao.selectJoList(jno);
	}
	
	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}
	// ** selectOne
	@Override
	public MemberDTO selectOne(String id) {
		return dao.selectOne(id);
	}
	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	// ** update
	@Override
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
	// ** delete
	@Override
	public int delete(String id) {
		return dao.delete(id);
	}
	
} //class
