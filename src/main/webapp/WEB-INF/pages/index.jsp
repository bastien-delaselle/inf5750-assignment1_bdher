<html>
<body>
	<h2>Welcome page!</h2>


	<h4>${info}</h4>

	<h4>Last message:</h4><h5>${message}</h5><br>
	<h4>Author:</h4><h5>${author}</h5>

	<form name="input" action="/assignment1_bdher/send" method="get">
		Author: <input type="text" name="author"><br>
		Message	content: <input type="text" name="content"><br>
		<input type="submit" value="Submit">
	</form>
	<p>
		<a href="/assignment1_bdher/read">Get last message</a>
	</p>

	<a href="<%=request.getContextPath()%>/hello">Say hello!</a>

</body>
</html>