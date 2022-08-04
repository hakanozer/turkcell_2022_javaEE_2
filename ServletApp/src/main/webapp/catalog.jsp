<%@ page import="services.CatalogService" %>
<%@ page import="java.util.List" %>
<%@ page import="props.Catalog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CatalogService service = new CatalogService();
    List<Catalog> ls = service.allCatalog();
%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <jsp:include page="inc/navbar.jsp"></jsp:include>
    <h3>Welcome Catalog</h3>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">COMMON</th>
            <th scope="col">BOTANICAL</th>
            <th scope="col">ZONE</th>
            <th scope="col">LIGHT</th>
            <th scope="col">PRICE</th>
        </tr>
        </thead>
        <tbody>
        <%
            for( Catalog item : ls ) {
        %>
            <tr>
                <th scope="row"> <%=item.getCOMMON()%> </th>
                <td> <%=item.getBOTANICAL()%> </td>
                <td> <%=item.getZONE()%> </td>
                <td> <%=item.getLIGHT()%> </td>
                <td> <%=item.getPRICE()%> </td>
            </tr>
        <%}%>

        </tbody>
    </table>



</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
