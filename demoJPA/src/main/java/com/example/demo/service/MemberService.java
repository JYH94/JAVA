package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.MemberDTO;
import com.example.demo.entity.Member;


public interface MemberService {

	
	//** Password_Update
	// => @Query 적용
	public void updatePassword(String id, String password);
	
	//** selectList
	public List<Member> selectList();
	
	//** selectOne
	public Member selectOne(String id);
	
	//** insert & update
	public Member save(Member entity);
	
	//** delete
	public void deleteById(String id);
	
	public List<Member> findByJno(int jno);
	
	   // ** Join
	public List<MemberDTO> findMemberJoin();
	
	public List<MemberDTO> findMemberJoin2();
}
