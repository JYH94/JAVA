package com.example.demo.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookDTO {

	private Long gno; // Auto_increment 할 대상은 Long로 설정
	private String title;
	private String content;
	private String writer;
//	==================================
	private LocalDateTime regDate;
	private LocalDateTime modDate;

}
