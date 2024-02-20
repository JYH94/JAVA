package aop04;

public class Boy implements Programmer {

	public String doStudying(int n) throws Exception {

		System.out.printf("열심히 회원관리를 %d개 만듭니다 => 핵심적 관심사항\n", n);
		
		
		// if(new Random().nextBoolean()) {
		// ** Test를 위해 늘 성공으로 처리
		// => 항상 false 가 되도록
		if (1 == 2) {
			throw new Exception("~~ Error 500*100 => 예외발생");
		}
		
		
		return "취업성공 연봉 1억" ;
	}

}
