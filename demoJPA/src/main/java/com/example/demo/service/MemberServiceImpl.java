package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberDSLRepositoryImpl;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	private final MemberRepository repository;
	private final MyRepository emrepository;
	private final MemberDSLRepositoryImpl dslRepository;

	// ** Password_Update
	public void updatePassword(String id, String password) {
		repository.updatePassword(id, password);
	};

	// ** selectList
	public List<Member> selectList() {
		//return repository.findAll(); // ver01
		return emrepository.emMemberList(); // ver02 : EntityManager Test
	}

	// ** selectOne
	public Member selectOne(String id) {
//		Optional<Member> result = repository.findById(id);
//		if (result.isPresent()) {
//			return result.get();
//		} else {
//			return null;
//		}
		
		return emrepository.emMemberDetail(id);
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
//		return repository.findByJno(jno); //ver 01
		return dslRepository.findMemberJnoDSL(jno); //ver 02
	}

	// ** Join
	@Override
	public List<MemberDTO> findMemberJoin() {
//		return repository.findMemberJoin(); //ver01
	return dslRepository.findMemberJoinDSL(); //ver02
		
	}

	public List<MemberDTO> findMemberJoin2() {
		return repository.findMemberJoin2();
	}
}
