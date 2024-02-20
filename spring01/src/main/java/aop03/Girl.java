package aop03;

public class Girl implements Programmer {

	public void doStudying() throws Exception {

		System.out.println("열심히 게시판을 만듭니다 => 핵심적 관심사항");

		
		// if(new Random().nextBoolean()) {
		// ** Test를 위해 늘 실패로 처리
		// => 항상 false 가 되도록
		if (true) {
			throw new Exception("~~ Error 404*100 => 예외발생");
		}

	}

}
