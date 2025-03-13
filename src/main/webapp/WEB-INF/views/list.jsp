<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
<h1>게시판 목록</h1>

<!-- 글쓰기 버튼 -->
<div style="margin-bottom: 10px;">
    <a href="write" style="display: inline-block; padding: 10px 20px; background-color: blue; color: white; text-decoration: none; border-radius: 5px;">
        글쓰기
    </a>
</div>

<table border="1">
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach var="board" items="${boardList}">
        <tr>
            <td>${board.id}</td>
            <td><a href="view?id=${board.id}">${board.title}</a></td>
            <td>${board.author}</td>
            <td>${board.createdAt}</td>
            <td><a href="edit?id=${board.id}">수정</a></td>
            <td><a href="delete?id=${board.id}" onclick="return confirm('삭제하시겠습니까?')">삭제</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
