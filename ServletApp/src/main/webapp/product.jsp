<%@ page import="services.ProductService" %>
<%@ page import="props.Bilgiler" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductService service = new ProductService();
    List<Bilgiler> ls = service.allProduct();
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
    <h3>Welcome Product</h3>
    <div class="row">
        <% for ( Bilgiler item : ls ) {  %>
        <div class="col-sm-4">
            <div class="card">
                <img src="<%=item.getImages().get(0).getNormal()%>" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"><%=item.getProductName()%></h5>
                    <p class="card-text"><%=item.getBrief()%></p>
                    <a href="#" class="btn btn-primary">Goto Detail</a>
                </div>
            </div>
        </div>
        <%}%>
    </div>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
