package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
//@Table(name="guestbook") // 클래스이름과 동일하다면 생략가능
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Guestbook extends BaseEntity {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Auto_increment(sql) 할 대상에게 주는 애노테이션
	private Long gno; // Auto_increment 할 대상은 Long로 설정
	
	@Column(length = 100, nullable = false)
	private String title;
	@Column(length = 2000, nullable = false)
	private String content;
	@Column(length = 50, nullable = false)
	private String writer;
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public void changeContent(String content) {
		this.content = content;
	}
}
