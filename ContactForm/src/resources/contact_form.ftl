<html>
<head>
	<title>Simple Contact Form</title>
</head>
<body>
	<form action="/contacts/create" method="POST">	
	<h1>Simple Contact Form</h1>
	<p>Name</p>
	<input type="input" name="name"/>
	<p>Email</p>
	<input type="input" name="email"/>
	<p>Message</p>
	<textarea name="message"></textarea>
	<input type="submit" value="Submit"></input>
	</form>
</body>
</html>