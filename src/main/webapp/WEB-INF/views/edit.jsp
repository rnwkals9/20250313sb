<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>
</head>
<body>
<h1>게시글 수정</h1>
<form action="update" method="post">
    <input type="hidden" name="id" value="${board.id}">
    제목: <input type="text" name="title" value="${board.title}" required><br>
    작성자: <input type="text" name="author" value="${board.author}" required><br>
    내용: <br>
    <textarea name="content" rows="5" cols="50" required>${board.content}</textarea><br>
    <input type="submit" value="수정">
</form>
<a href="list">목록으로</a>
</body>
</html>
