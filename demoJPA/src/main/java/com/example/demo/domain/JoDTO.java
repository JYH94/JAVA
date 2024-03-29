package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 생성자 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@Data
public class JoDTO{
	//** private으로 멤버변수 정의
	private int jno;
	protected String jname;
	private String captain;
	protected String project;
	private String slogan;
//	private String uploadfile;
	private String cname;


	//** 1) 생성자
	//=> default 생성자, 모든 값을 초기화하는 생성자
	
	//** 2) setter/getter
	//** 3) toString
	

		

}
