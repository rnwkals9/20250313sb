<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세보기</title>
</head>
<body>
<h1>${board.title}</h1>
<p>작성자: ${board.author}</p>
<p>작성일: ${board.createdAt}</p>
<p>${board.content}</p>
<a href="edit?id=${board.id}">수정</a>
<a href="delete?id=${board.id}" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
<a href="list">목록으로</a>
</body>
</html>
