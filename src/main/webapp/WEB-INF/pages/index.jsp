<html>
<body>
	<h2>Welcome page!</h2>

	<h4>Message : ${message}</h4>

	<form name="input" action="/assignment1_bdher/send" method="get">
		Message content: <input type="text" name="content"> <input
			type="submit" value="Submit">
	</form>
	<p>
		<a href="/assignment1_bdher/read">Get last message</a>
	</p>

	<a href="<%=request.getContextPath()%>/hello">say hello !</a>

</body>
</html>