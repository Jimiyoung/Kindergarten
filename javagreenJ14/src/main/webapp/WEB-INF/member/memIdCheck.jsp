<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>memIdCheck.jsp</title>
  <%@ include file="/include/bs4.jsp" %>
  <script>
  	function sendCheck() {
			opener.window.document.myForm.mid.value = '${mid}';
			opener.window.document.myForm.pwd.focus();
			window.close();
		}
  	
  	//중복 아이디를 다시 체크
  	function idCheck() {
  		let mid = childForm.mid.value;
		
			if(mid==""){
				alert("아이디를 입력하세요.");
				childForm.pwd.focus();
			}
			else {
				childForm.submit();
			}
		}
  	 </script>
</head>
<body>
<%@ include file="/include/header_home.jsp" %>
<p><br/></p>
<div class="container text-center">
  <h3>아이디 체크 폼</h3>
  <c:if test="${res == 1}">
  	<h4>"<font color="blue">${mid}</font>" 아이디는 사용 가능합니다.</h4>
  	<p><input type="button" value="창닫기" onclick="sendCheck()"/></p>
  </c:if>
  <c:if test="${res != 1}">
  	<h4>"<font color="blue">${mid}</font>" 아이디는 이미 사용중인 아이디입니다.</h4>
  	<form name="childForm" method="post" action="${ctp}/memIdCheck.mem">
  		<p>
  			<input type="text" name="mid"/>
  			<input type="button" value="아이디검색" onclick="idCheck()"/>
  		</p>
  	</form>
  </c:if>
</div>
<p><br/></p>
</body>
</html>