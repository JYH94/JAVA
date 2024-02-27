'use strict'



// ** Ajax Member_PageList *********************
// => axiMList 에 Paging + 검색기능 추가
// => 검색조건 & Paging , Ajax 구현
//    -> 입력된 값들을 서버로 전송요청: axios
//   -> url 완성후 axios 호출

// => 1) 검색조건 입력 후 버튼클릭
//   -> jsp  문서내무의 script 구문을 외부문서로 작성 : EL Tag 적용안됨
//    ${pageMaker.makeQuery(1)} -> ?currPage=1&rowsPerPage=5 
function searchDB() {
	let url = 'axmcri'
		+ '?currPage=1&rowsPerPage=5'
		+ '&searchType=' + document.getElementById('searchType').value
		+ '&keyword=' + document.getElementById('keyword').value;
	axiMListCri(url);
}

// 2) searchType 을 '전체' 로 변경하면 keyword는 clear 
function keywordClear() {
	if (document.getElementById('searchType').value == "all") {
		document.getElementById('keyword').value = "";
	}
}

// 3) axios code
function axiMListCri(url2) {
	let url = "/member/" + url2;
	alert(`axiMListCri url =${url}`);

	axios.get(url)
		.then(response => {
			alert('** response : memberList 성공 ');
			document.getElementById('resultArea1').innerHTML = response.data;
		}).catch(err => {
			alert(`response memberList 실패 => ${err.massage}`)
		})
	document.getElementById('resultArea2').innerHTML = '';

}

function axiMListCheck() {
	// => 첫요청 url 생성
	// url=/axmcheck?currPage=1&rowsPerPage=5&check=1&check=2&check=3

	let checkAll = document.querySelectorAll(".check");
	console.log(checkAll[0].value);
	let checkData = "";
	for (let i = 0; i < checkAll.length; i++) {
		if (checkAll[i].checked)
			checkData += "&check=" + checkAll[i].value;
	}


	let url = 'axmcheck'
		+ '?currPage=1&rowsPerPage=5'
		+ checkData;
	axiMListCri(url); // axios 호출   
} //axiMListCheck



function axiMList() {
	let url = "member/aximlist";

	axios.get(url)
		.then(response => {
			document.getElementById('resultArea1').innerHTML = response.data;
		}).catch(err => {
			alert(`response memberList 실패 => ${err.massage}`)
		})
	document.getElementById('resultArea2').innerHTML = '';
}


/*function axiMBList(ele) {
	// 보드컨트롤러를 이용하는 방법
	let id = ele.innerText;
	console.log(id);
	let url = `board/bPageList?currPage=1&rowsPerPage=5&searchType=id&keyword=${id}`
	
	axios.get(url)
	.then(response => {
		document.getElementById('resultArea2').innerHTML = response.data;
	}).catch(err => {
		alert(`response m+b List 실패 => ${err.massage}`)
	})
}

*/
// 1.2) idbList(id별 boardList)
// => RESTController, PathVariable , List_Data response
// => Server : service, sql 구문 작성
// => request : id 를 path로 전송하기
// => response 
//    성공 : 반복문을 통해 Table로 List 출력문 완성, Area2에 출력
//	  출력자료의 유무 : Server status로 (없으면 502)로 처리
//    실패 : Area2 번 clear , 에러메세지 출력
function idbList(id) {
	let url = "rest/idblist/" + id;

	axios.get(url)
		.then(response => {
			alert("** 성공 => resultArea2 에 리스트 작성 **");
			/*document.getElementById('resultArea2').innerHTML = response.data;*/
			let listData = response.data;
			console.log("** result List_Data => " + listData)
			let resultHtml =
				`
		<table style="width: 100%">
			<tr bgcolor="Khaki">
				<th>seq</th>
				<th>id</th>
				<th>title</th>
				<th>regdate</th>
				<th>조회수!</th>
			</tr>
		`;
			// => 반복문 적용
			for (let b of listData) {
				resultHtml +=
					`
				<tr>
					<td>${b.seq}</td>
					<td>${b.id}</td>
					<td>${b.title}</td>
					<td>${b.regdate}</td>
					<td>${b.cnt}</td>
				</tr>
				`
			}
			
		// ** for 간편출력 : of, in
		// => in: undifined 는 통과하고, 배열(index Return), 객체(속성명 Return)
		// => of: undifined 까지 모두출력 (순차출력과 동일), value 를 return, 
		//        ES6 에 for ~ in 의 단점을 보완 개선하여 추가됨.
		//        일반 객체에는 적용안되지만, (오류발생, 개발자모드로 확인가능)
		//         Array, String, Map, Set, function의 매개변수 객체 와
		//        이터러블 규약을 따르는 이터러블 객체 (Iterable Object) 는 적용됨
		// => 이터러블 규약
		//      내부에 Symbol.iterator (줄여서 @@iterator로 표현하기도함) 메서드가 구현되어 있어야 한다는 규약 

			resultHtml += `</table>`;
			document.getElementById('resultArea2').innerHTML = resultHtml;
		}).catch(err => {
			// => response 의 status의 값이 502 일 때 , => "데이터가 없습니다"
			if (err.response.status == '502') {
				alert("** 출력할 데이터가 없다");
				document.getElementById('resultArea2').innerHTML
					= err.response.data;
			} else {
				alert("** 시스템 오류, 잠시 후 다시! => " + err.message);
				document.getElementById('resultArea2').innerHTML = "";
			}
		})

}

/* Delete 기능 추가 */
// => 선택된 id를 function에 전달 (매개변수 활용)
// => 요청명 "rest/axidelete/"+id   @PathVarialbe 적용
// => response : 성공/실패 여부만 전달 : RESTController 로 
// => 성공 : Deleted 로 변경, onclick 이벤트 해제
//
function axiDelete(id, ele) {
	let url = "/rest/axidelete/" + id;
	axios.delete(url)
		.then(response => {
			alert("데이터 삭제 O" + response.data)
			if (response.data > 0) {
				ele.closest('tr').style.color = "gray";
				ele.style.color = "gray";
				ele.removeAttribute('onclick');
				ele.removeAttribute('class');
				ele.innerText = "Deleted";
			}
			// => 삭제성공
			//	  Delete -> Deleted / color=gray, bold / onclick 이벤트 해제
			//    Style 제거
		}).catch(err => {
			if (err.response.status == '502') {
				alert("데이터 삭제 X" + err.response.data);
			} else {
				alert("시스템 오류! 다시 시도하세요" + err.message);
			}
		})
}




function showJoDetail(event, jno) {

	let url = '/rest/mover/' + jno;

	axios.get(url)
		.then(response => {
			let box = document.createElement('div');
			document.getElementById('mBox').appendChild(box);
			box.style.position = 'absolute';
			box.style.left = event.pageX+'px';
			box.style.top = event.pageY+'px';
			box.style.width = '200px';
			box.style.height = '100px';
			box.style.backgroundColor='grey';
			box.style.color='white';
			box.style.padding='10px';
			box.innerText = "slogan : \n"+  response.data.slogan;
		}).catch(err => {
			alert(err.message);
		})
}

function hideJoDetail() {
	document.getElementById('mBox').innerHTML="";
}


function zoomIn(event) {
	let box = document.createElement('div');
	document.getElementById('mBox').appendChild(box);
	box.style.backgroundImage = `url('${event.target.src}')`;
	box.style.background = 'no-reapeat';
	box.style.position = 'absolute';
	box.style.left = event.pageX+'px';
	box.style.top = event.pageY+'px';
	/*box.style.left = event.target.+'px';
	box.style.top = event.pageY+'px';*/
	box.style.height = '100px';
	box.style.width = '100px';
	box.style.border = '2px solid';
	box.style.transform = 'scale(2)'
}