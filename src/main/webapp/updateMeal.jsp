<%@ page import="java.time.LocalDateTime" %>
<%@ page import="ru.javawebinar.topjava.util.FoodHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jfm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Meal</title>

</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h3>Add Meal</h3>
<hr>
<%--<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal"/>--%>
<c:set var="meal" scope="page" value="${meal}"/>
<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal"/>
<form method="post"  >
    <p><input name="id" value="${meal.id}" type="hidden"></p>
    <p><input type="datetime-local" name="date" value="${meal.dateTime}" > дата  </p>
    <p><input type="text" name="description" value="${meal.description}"> описание  </p>
    <p><input type="number" name="calories" value="${meal.calories}"> калории  </p>
    <p>
        <button type="submit">ok</button>
        <button type="button" onclick="window.history.back()">cancel</button>
    </p>
</form>
</body>
</html>
