package aop03;

public class Boy implements Programmer {

	public void doStudying() throws Exception {

		System.out.println("열심히 회원관리를 만듭니다 => 핵심적 관심사항");
		
		
		// if(new Random().nextBoolean()) {
		// ** Test를 위해 늘 성공으로 처리
		// => 항상 false 가 되도록
		if (1 == 2) {
			throw new Exception("~~ Error 500*100 => 예외발생");
		}
	}

}
