package com.ncs.spring02.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 필드 전체 초기화 생성자 
@NoArgsConstructor // 디폴트 생성자
@Data
public class JoDTO {
	// ** private 으로 맴버변수 정의
	private int jno;
	private String jname;
	private String captain;
	private String project;
	private String slogan;
	
	private String cname; // 필요시 사용
	// 2) getter/setter
	// 3) toString
	// 롬복 라이브러리 사용으로 인해 오버라이딩 할 필요가 없어진다
	
} //class
