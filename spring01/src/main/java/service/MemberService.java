package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import domain.MemberDTO;
import model.MemberDAO;


//@Component
@Service
public class MemberService {
	
	@Autowired
	MemberDAO dao;
	// IOC/DI 적용, 자동주입 -> 어딘가에서 이미 생성되어 있어야 한다(@ or xml or jc)
	
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
