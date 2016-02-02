<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<body>


<!-- JSP -->
<h1>${modelAttributeName}</h1>

<!-- Thymeleaf -->
<h1 th:test="${modelAttributeName}">Some title</h1>

</body>
</html>