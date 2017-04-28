<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> ESTAMOS EN WEATHER.JSP</h1>

	<div style="border: 2px solid black">
		<p> Ciudad: <c:out value="${weathers.city.name}"></c:out> </p>
		<p> País: <c:out value="${weathers.city.country}"></c:out> </p>
		
		<c:forEach items="${requestScope.weathers.list}" var="lista">
			<div style="border: 2px solid black">
				<p> Fecha y hora: <c:out value="${lista.dt_txt}"></c:out> </p>
				<p> Temperatura: <c:out value="${lista.main.temp}"></c:out> Cº </p>
				<p> Temperatura min: <c:out value="${lista.main.temp_min}"></c:out> Cº </p>
				<p> Temperatura max: <c:out value="${lista.main.temp_max}"></c:out> Cº </p>
				
			</div>
				
				
			
			
		</c:forEach>
	
	</div>

</body>
</html>