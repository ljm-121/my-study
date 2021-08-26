<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- css -->
    <link rel="stylesheet" href="/css/common/reset.css">
    <link rel="stylesheet" href="/css/user/signup.css">
    <!-- webfont -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <title>아이디 찾기</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function aligo() {
	
   var formData = new FormData($('#findIdForm')[0]);
   $.ajax({
       type: "post",
       contentType: false,
       enctype: 'multipart/form-data',
       processData: false,
       url: "/aligo",
       data: formData,
       success: function (data){
          alert(data);
       }
   })
}
</script>
<body>
	<form id="findIdForm">
	사용자 이름 : <input type="text" name="memUsername">
	사용자 패스워드 : <input type="text" name="memPassword">
	<input type="button" value="인증" class="btn_small btn_primary" onclick="aligo();">
	</form>
</body>
</html>