<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:forEach items="${exampleValues}" var="value">
    <h1>${value}</h1>
</c:forEach>
</body>
</html>