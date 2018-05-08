
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ninja Gold</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="header">
		<h4>Your Gold: <span class="gold">${gold}</span></h4>
		<p>${result}</p>
		<p><a href="/gold/reset"><button>Reset Game</button></a></p>
	</div>
	<br>
	<div class="wrapper">
		<div class="box">
			<form action ="/gold/farm" method="post">
			<h4>Farm</h4>
			<p>(earns 10-20 gold)</p>
			<input type="submit" value="Find Gold!"></input>
			</form>
		</div>
		<div class="box">
			<form action ="/gold/cave" method="post">
			<h4>Cave</h4>
			<p>(earns 5- 10 gold)</p>
			<input type="submit" value="Find Gold!"></input>
			</form>
		</div>
		<div class="box">
			<form action ="/gold/house" method="post">
			<h4>House</h4>
			<p>(earns 2- 5 gold)</p>
			<input type="submit" value="Find Gold!"></input>
			</form>
		</div>
		<div class="box">
			<form action ="/gold/casino" method="post">
			<h4>Casino</h4>
			<p>(earns/takes 0- 50 gold)</p>
			<input type="submit" value="Find Gold!"></input>
			</form>
		</div>
		<div class="box">
			<form action ="/gold/spa" method="post">
			<h4>Spa</h4>
			<p>(takes 5- 20 gold)</p>
			<input type="submit" value="Spend Gold!"></input>
			</form>
		</div>
	</div>
	<div>
		<h4>Activities:</h4>
		<div class="activities_box">
			<c:forEach var="event" items="${history}">
				<c:if test="${result==false}">
					<p class="red"><c:out value="${event}"/></p>
				</c:if>
				<c:if test="${result}">
					<p class="green"><c:out value="${event}"/></p>
				</c:if>
			</c:forEach> 
		</div>
	</div>
</body>
</html>