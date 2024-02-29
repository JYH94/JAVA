package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	private final MemberRepository repository;

	// ** Password_Update
	public void updatePassword(String id, String password) {
		repository.updatePassword(id, password);
	};

	// ** selectList
	public List<Member> selectList() {
		return repository.findAll();
	}

	// ** selectOne
	public Member selectOne(String id) {
		Optional<Member> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	// ** insert & update
	public Member save(Member entity) {
		return repository.save(entity);
	}

	// ** delete
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public List<Member> findByJno(int jno) {
		return repository.findByJno(jno);
	}

	// ** Join
	@Override
	public List<MemberDTO> findMemberJoin() {
		return repository.findMemberJoin();
	}

	public List<MemberDTO> findMemberJoin2() {
		return repository.findMemberJoin();
	}
}
