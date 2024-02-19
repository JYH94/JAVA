package aop01;

import java.util.Random;

public class Girl implements Programmer{

	public void doStudying() {
		
		System.out.println("프로젝트 과제를 합니다 => Before단계 준비작업");
		try {
			System.out.println("열심히 게시판을 만듭니다 => 핵심적 관심사항");
			if(new Random().nextBoolean()) {
				// 실패
				throw new Exception("~~ Error 404*100 => 예외발생");
				// 강제로 에러 발생시킴
			} else {
				System.out.println("~~ 글 등록이 잘 됩니다 => 핵심적 관심사항의 정상정료");
			}
		} catch (Exception e) {
			System.out.println("** Girl Exception => " + e.toString());
			System.out.println("** 밤새워 수정 합니다 zz => 핵심적 관심사항의 비정상종료");
		}finally {
			System.out.println("** finally : 무조건 제출합니다 ~~ => After");
		}
				
	}

}
