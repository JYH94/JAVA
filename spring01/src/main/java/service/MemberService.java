package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.MemberDTO;
import model.MemberDAO;


@Component
public class MemberService {
	
	@Autowired
	MemberDAO dao;
	
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}
	
	public MemberDTO selectOne(String id) {
		return dao.selectOne(id);
	}
	
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
	
	public int delete(String id) {
		return dao.delete(id);
	}
}
