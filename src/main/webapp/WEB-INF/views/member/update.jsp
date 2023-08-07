<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/update.css">
<title>회원 정보 수정</title>
</head>
<body>
<div id="container">
		<div id="header">
			<div id="header-layer1"></div>
			<div id="header-layer2">
				<ul id="header-top">
					<li><a href="/notice/insert.do">고객센터</a></li>
					<li><a href="/member/login.do">로그인/회원가입</a></li>
					<li><a href="/index.jsp">메인으로</a></li>
					<li><input type="text" id="serch"> <input
						type="submit" value="검색"></li>
				</ul>
			</div>
		</div>
		<div id="nav">
			<ul id="menu">
				<li><a href="/content/popularContent.html">인기순위</a></li>
				<li><a href="#">추천</a></li>
				<li><a href="/content/endingContent.html">종료예정작</a></li>
				<li><a href="/member/mypage.do">마이페이지</a></li>
			</ul>
		</div>


		<div id="main">
			<div id="main-layer1">
				<h3>회원정보수정</h3>
			</div>
			<div id="main-layer2">
				<form action="/member/update.do" method="post">
				<fieldset>
					<legend>회원정보수정</legend>
					<ul>
						<li>
							<label for="member-id">아이디 : </label>
							<input id="member-id" name="member-id" type="text" value="${member.memberId }" readonly><br>	
						</li>
						<li>
							<label for="member-pw">비밀번호 : </label>
							<input id="member-pw" name="member-pw" type="password"><br>
						</li>
						<li>
							<label for="member-name">이름 : </label>
							<input id="member-name" name="member-name" type="text" value="${member.memberName }" readonly><br>
						</li>
						<li>
							<label for="member-phone">연락처 : </label>
							<input id="member-phone" name="member-phone" type="text" value="${member.memberAge }"><br>
						</li>
						<li>
							<label for="member-email">이메일 : </label>
							<input id="member-email" name="member-email" type="text" value="${member.memberEmail }"><br>
						</li>
						<li>
							<label for="member-age">나이 : </label>
							<input id="member-age" name="member-age" type="text" value="${member.memberAge }" readonly><br>
						</li>
						<li>
							<label for="member-gender">성별</label>
							<input type="hidden" id="member-gender" name="member-gender" value="${member.memberGender }">
							<c:if test="${member.memberGender eq 'M'}">남자</c:if>
							<c:if test="${member.memberGender eq 'F'}">여자</c:if>
						</li>
					</ul>
					<button type="submit">수정하기</button>
				</fieldset>
				</form>
			</div>
		</div>


		<div id="footer"></div>
	</div>
</body>
</html>