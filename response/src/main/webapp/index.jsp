<html>
<header>

    <script type="text/javascript">
        function change(image) {
            image.src = image.src + "?" + new Date().getTime();
        }
    </script>

</header>

<body>
<h2>Hello World!</h2>

<img src="/image" onclick="change(this)">

</body>
</html>
