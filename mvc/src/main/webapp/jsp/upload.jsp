<%--
  Created by IntelliJ IDEA.
  User: zhangtao
  Date: 2022/9/13
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/user/quick17" method="post" enctype="multipart/form-data">
            <input type="file" name="uploadFile">
            <input type="file" name="uploadFile1">
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
