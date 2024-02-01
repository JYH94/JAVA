/**
** 입력값의 무결성 확인
** member 무결성 확인사항
// ID : 길이(4~10), 영문자,숫자 로만 구성
// Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Password2: 재입력후 Password 와 일치성 확인
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )  
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 실수 ( 구간설정 100 ~ 10000 까지만 가능 )
// Jno : select 를 이용 (X)
// Info : (X)

** 작성 규칙
   => JavaScript function 으로 정의 하고 
      결과를 true or false 로 return
   => 정규식을 활용한다.
   
** match Test
   => 아래 조건에 true -> not (!)  match 적용해보면
   => 정확하지 않으므로 (부적절, replace 를 사용)
        ...       
        } else if (!id.match(/[a-z.0-9]/gi)) {
            alert(' ID는 영문자와 숫자로만 입력하세요. !!!')
            return false;
        }    
 */

"use strict"

// 1) ID (길이, 영문과 숫자만 가능)
// => 영문과 숫자로만 입력했는지 :
//	  id 에서 영문과 숫자를 모두 '' 로 변경했을때 length 가 0 이면 OK 
/*function idCheck() {
	let id = document.getElementById('id').value;
	if (id.length < 4 || id.length > 10) {
		document.getElementById('iMessage').innerHTML = 'id 4~10 글자 입니다';
		return false;
	} else if( id.replace(/[a-z.0-9]/gi,'').length > 0 ) {
		document.getElementById('iMessage').innerHTML = 'id 4~10 글자 입니다';
		return false;
	} else {
		document.getElementById('iMessage').innerHTML = '';
		return true;
	}
}*/
/*=======================================================*/
// => test(검사대상문자열) 메서드 활용
// 정규식에 정의된 문자가 아닌 문자가 있다면 false
function idCheck() {
	let special = /[a-z.0-9]/gi;
	let id = document.getElementById('id').value;
	if (id.length < 4 || id.length > 10) {
		document.getElementById('iMessage').innerHTML = 'id 4~10 글자 입니다';
		return false;
	} else if( id.replace(special,"").length > 0 ) {
		document.getElementById('iMessage').innerHTML = 'id 특수문자,한글 X';
		return false;
	} else {
		document.getElementById('iMessage').innerHTML = '';
		return true;
	}
}
//=========================================================
// 2) password
function pwCheck() {
	let special = /[a-z.0-9.!-*.@]/gi;
	let pw = document.getElementById('password').value;
	
	if (pw.length < 4 || pw.length > 10) {
		document.getElementById('pMessage').innerHTML = 'password 4~10 글자 입니다';
		return false;
	} else if ( pw.replace( /[a-z.0-9.!-*.@]/gi , '' ).length > 0 ) {
		document.getElementById('pMessage').innerHTML = 'password 영문,숫자,특문만 가능';
		return false;
	} else if( pw.replace( /[!-*.@]/gi , '' ).length >= pw.length ) {
		document.getElementById('pMessage').innerHTML = 'password 특문 반드시 포함';
		return false;
		// => 특수문자는 반드시 포함
	} else {
		document.getElementById('pMessage').innerHTML = '';
		return true;
	}
	
}

// 3) password2
function pw2Check() {
	let pw2 = document.getElementById('password2').value;
	let pw = document.getElementById('password').value;
	
	if( pw2 != pw ) {
		document.getElementById('p2Message').innerHTML = 'password 다릅니다';
		return false;
	} else {
		document.getElementById('p2Message').innerHTML = '';
		return true;
	}
}


// 4) name
function nmCheck() {
	//let check = /[a-z.ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/gi;
	let check = /[a-z.가-힣]/gi;
	let name = document.getElementById('name').value;
	if(name.replace(check,'').length > 0) {
		document.getElementById('nMessage').innerHTML = 'name 한글,영어만';
		return false;
	} else if(name.length < 2 ) {
		document.getElementById('nMessage').innerHTML = 'name 2글자 이상';
		return false;
	} else {
		document.getElementById('nMessage').innerHTML = '';
		return true;
	}
}

// 5) age
// => Number.isInterger(n) 정수일때만 true
//	단, n 은 숫자타입이어야 한다.
//	parseInt 이용
//	단 사용시 주의 사항 :
//		실수의 경우에는 정수만 사용 ( 123.56 -> 123)
//		숫자 뒤쪽에 문자가 포함되면 앞쪽 숫자만 가져오는 상항(123ab -> 123)
//		문자로 시작하면 문자로 취급, NaN 리턴
//		숫자가 아닌값이 있는지 확인,
//		
function agCheck() {
	let age = document.getElementById('age').value;
	let check = /[^0-9]/gi;
	let test = Number.parseInt(age);
	
	if(age.replace(check,'').length < age.length 
		|| Number.isInteger(test) == false) {
		document.getElementById('aMessage').innerHTML = 'age 정수만';
		return false;
	} else {
		document.getElementById('aMessage').innerHTML = '';
		return true;
	}
}

// 6) point
// 정수, 실수 모두 허용
function poCheck() {
	let point = document.getElementById('point').value;
	let test = Number.parseFloat(point);
	let check = /[^0-9.\.]/g;
	//	0~9, '.' 
	let message = document.getElementById('oMessage').innerHTML;

	// => 숫자 아닌값이 있는지 확인
	// => 단, 소수점은 허용
	//		( 비교값으로 소숫점을 사용하기 위해 /. 표기함)
	if ( point.replace(check,'').length < point.length ||
		Number.isNaN(test)) {
		document.getElementById('oMessage').innerHTML = '정수, 실수만 입력가능합니다';
		return false;
	} else if( test < 100 || test > 10000 ) {
		document.getElementById('oMessage').innerHTML = '포인트값이 범위(100~10000)를 벗어납니다';
		return false;
	} else if (point.length - point.replace('.','').length > 1   )  {
		document.getElementById('oMessage').innerHTML = '점 두개 찍었다';
		return false;
	} else {
		document.getElementById('oMessage').innerHTML = '';
		return true;
	}
}

// 7) birthday
function bdCheck() {
	let birthday = document.getElementById('birthday').value;
	
	if(birthday.length != 10) {
		document.getElementById('bMessage').innerHTML = '생일 입력 확인하세요';
		return false;
	} else {
		document.getElementById('bMessage').innerHTML = '';
		return true;
	}
	
}



/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 <!-- 
 ** Good 정리
 => https://inpa.tistory.com/entry/JS-📚-정규식-RegExp-누구나-이해하기-쉽게-정리
 
** 정규 표현식 (정규식:Regular Expression) 객체 : RegExp
=> 자바스크립트의 기본 내장 객체 중의 하나
=> 특정한 규칙을 가진 문자열 집합을 표현하는데 사용하는 형식
* 생성
   let regExp1= new RegExp('text') ;
   let regExp2= /text/ ; 
* 메서드   
   test() : 정규식과 일치하는 문자열이 있으면 true 아니면  false 를 return 
   exec() : 정규식과 일치하는 문자열을 return 
* 예제   
   let regExp= /script/ ; 
   let s='Javascript jQuery Ajax';
   
   let output = regExp.test(s) ;
   alert(output) ; 
* 그러나 주로 문자열의 메서드와 같이 사용됨
    
/.../ : 정규식 RegExp 의 리터럴

** 플래그 문자 
g : global, 전역비교
i : 대문자는 소문자 변환후 비교 (대/소문자 구분 없음)
m : 여러줄의 검사 수행
   ( 각줄을 개별문자로 인식하고 검사해줌
    예 : 'JavaScript\njQuery\nAjax' )

\. : . 문자 (. 는 한 문자를 의미하나 \. 는 . 문자를 의미함)
a-z : abcdefghijklmnopqrstuvwxyz 와 같음
0-9 : 0123456789 와 같음
: : : 문자
_ : _ 문자
- : - 문자
[~.~] : ~ 와 ~ , Or 의 묶음
[..] : Or 의 묶음. 안에 기록된 1가지외 중복 적용됨.
[^...] : 내부내용의 부정. 기록된 이외의 것을 찾음.
+ : 하나 이상의 반복적용. (단어(?) 찾음)

*/




