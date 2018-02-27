<html>
<header>
    <meta charset="UTF-8">
</header>
<body>
<a href="/parameter?username=chencs">get方式传输数据</a>

<form action="/parameter" method="post" enctype="multipart/form-data" >
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>
