package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Member;

public interface MyRepository {
	
	public List<Member> emMemberList();
	public Member emMemberDetail(String id);
}
