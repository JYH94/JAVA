package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;



@Transactional
@Repository
public class MyRepositoryImpl implements MyRepository{
	
	private final EntityManager em;
	
	public MyRepositoryImpl(EntityManager em) {
		this.em = em;
		// final 의 경우 선언과 동시에 초기화해줘야 하는것이 맞지만,
		// 생성자를 통한 주입은 가능하다
	}

	public List<Member> emMemberList2() {
		// sql 구문 작성시 테이블명(member)을 엔티티명(Member)으로 줘야한다.
		return em.createQuery("select m from Member m order by m.id asc", Member.class)
				.getResultList();
		// => JPQL 적용
		//    select * from Member order by id asc 오류발생
		//    unexpected token Exception 
		//    위 sql 구문에서 Member란 테이블명이 아니라 엔티티 명이기 때문에
		//    엔티티에Alias 지정해주고, 그 Alias를 통해 접근해야 오류가 나지 않는다.
		
	}
	
	
	public List<Member> emMemberList() {
		
		return em.createQuery("select m from Member m where jno<:jno", Member.class)
				.setParameter("jno", 7)
				.getResultList();
	}
	
	public Member emMemberDetail(String id) {
		return em.createQuery("select m from Member m where id=:id",Member.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
} //class
