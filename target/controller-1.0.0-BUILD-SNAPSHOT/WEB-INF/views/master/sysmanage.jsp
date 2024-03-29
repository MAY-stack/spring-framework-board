<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 | 게시판</title>
<style>
.menubar{
	width: 100%;
	height: auto;
	background-color:#168;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	text-align:center;
}

.menubar a:link, a:visited, a:active {
	color: white;
	font-weight: bold;
}

.menubar a{
	display:block;
	text-decoration: none;
}

.menubar .main-menu > li {
	float: left;
	width: 20%;
	height: 100%;
	line-height: 50px;
	list-style:none;
	font-weight: bold;
	position: relative;
	margin: 0px;
}

.menubar .main-menu > li > a:hover {
	background-color : #f0f6f9;
	color : #168;
	font-weight: bold;
}
</style>
</head>
<body>

<div class='menubar'>
	<ul class='main-menu'>
		<li><a href='/board/list?page=1'>흠으로</a></li>
		<li><a href='/master/sysinfo'>시스템 정보</a></li>
		<li><a href='/master/filemanage'>첨부파일 관리</a></li>
		<li><a href='#'>메뉴1</a></li>
		<li><a href='#'>메뉴2</a></li>
	</ul>
</div>


</body>
</html>