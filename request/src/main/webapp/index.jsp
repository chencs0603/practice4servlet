<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
    <a href="<%=request.getContextPath()%>/parameter?username=chencs">get方式传输数据</a>

    <form action="<%=request.getContextPath()%>/parameter" method="post" enctype="application/x-www-form-urlencoded" >
        用户名：<input type="text" name="username">
        密码：<input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>