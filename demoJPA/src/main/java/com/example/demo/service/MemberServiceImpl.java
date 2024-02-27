package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	//** 전역변수 정의
	private final MemberRepository repository;
	
	
	
	//** selectList
	public List<Member> selectList(){
		return repository.findAll();
	}
	
	//** selectOne
	public MemberDTO selectOne(String id) {
		return repository.selectOne(id);
	}
	
	//** insert
	public int insert(MemberDTO dto) {
		return repository.insert(dto);
	}
	//** update
	public int update(MemberDTO dto) {
		return repository.update(dto);
	}
	
	//** Password_Update
	public int pwUpdate(MemberDTO dto) {
		return repository.pwUpdate(dto);
	}
	
	//** delete
	public int delete(String id) {
		return repository.delete(id);
	}
	


}
