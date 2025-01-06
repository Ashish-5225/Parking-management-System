<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Parking Status</title></head>
<body>
    <h1>Parking Lot Status</h1>
    <table border="1">
        <tr>
            <th>Spot Number</th>
            <th>Status</th>
            <th>License Plate</th>
        </tr>
        <c:forEach var="spot" items="${parkingSpots}">
            <tr>
                <td>${spot.spotNumber}</td>
                <td><c:choose>
                    <c:when test="${spot.occupied}">Occupied</c:when>
                    <c:otherwise>Empty</c:otherwise>
                </c:choose></td>
                <td>${spot.licensePlate}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
