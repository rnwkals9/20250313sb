<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
<h1>새 글 작성</h1>
<form action="save" method="post">
    제목: <input type="text" name="title" required><br>
    작성자: <input type="text" name="author" required><br>
    내용: <br>
    <textarea name="content" rows="5" cols="50" required></textarea><br>
    <input type="submit" value="저장">
</form>
<a href="list">목록으로</a>
</body>
</html>
