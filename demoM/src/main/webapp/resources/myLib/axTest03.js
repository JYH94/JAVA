'use strict'
// => Axios 메서드형식 적용 (00_AJAX(공유).pptx 16p)
/* 
   - GET   : axios.get( url[, config] )
   - POST  : axios.post( url, data[, config] )
   - PUT   : axios.put( url, data[, config] )
   - PATCH : axios.patch( url[, data[, config]] )
   - DELETE: axios.delete( url[, config] )  
// 표기는 대괄호 블럭으로 되어있지만
// axTest02.js 보면 중괄호 두개로 감싸있는 모습이 예시로 있다. 확인하자   
*/

// ** Ajax_REST API, Axios Test **
// => Axios 메서드형식 적용
// => 1. List 출력
//   - axiMList : MemberController, Page response ( axMemberList.jsp )
//   - idbList(id별 boardList) : RTestController, List_Data response 
// => 2. 반복문에 이벤트 적용하기
//   - Delete, JoDetail
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



// 1. List 출력 
//   - axiMList : MemberController, Page response ( axMemberList.jsp )
// => response 를 area1 에 출력하기
// => 요청명 : /member/aximlist
// => response : axMemberList.jsp
// 1.1) Page response
function axiMList() {
	let url = "/member/aximlist";
	axios.get(url)
	.then(response => {
		alert('** response : memberList 성공 ');
		document.getElementById('resultArea1').innerHTML = response.data;
	}).catch(err => {
		alert(`response memberList 실패 => ${err.massage}`)
	})
	document.getElementById('resultArea2').innerHTML = '';
}


function axiMBlist(ele) {
	let url = "board/boardlist";
	let keyw = ele.value;
	axios.get(url,keyw)
	.then(response => {
		document.getElementById('resultArea2').innerHTML = response.data;
	}).catch(err => {
		alert(`response memberList 실패 => ${err.massage}`)
	})
}