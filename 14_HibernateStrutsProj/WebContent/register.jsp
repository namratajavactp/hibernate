<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
		<title>Register</title>
	</head>

	<body>
		<form:form action="/register.do">
			User Name :<form:text property="uname"/><br>
			Password  :<form:password property="password1"/><br>
			Confirm Password  :<form:password property="password2"/><br>
			<form:submit value="Register"/>
		</form:form>
	</body>

</html>
