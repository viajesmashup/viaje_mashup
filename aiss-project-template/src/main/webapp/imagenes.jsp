<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Imagenes</title>
</head>
<body>
	<h1>ESTAMOS EN IM�GENES</h1>







	<c:forEach items="${requestScope.photos.value}" var="foto">
		<div>
			<img src="<c:out value="${foto.contentUrl}"></c:out>"
		alt="FotosCiudad" height="40%" width="50%">


		</div>

	</c:forEach>









</body>
</html>