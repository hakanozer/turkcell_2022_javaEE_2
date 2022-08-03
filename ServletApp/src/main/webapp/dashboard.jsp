<%@ page import="services.PersonService" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PersonService service = new PersonService();
    List<Person> ls = service.allPerson(request);
%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <style>
        th, td {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <jsp:include page="inc/navbar.jsp"></jsp:include>

    <div class="row">
        <div class="col-sm-5">
            <h3>Person Add</h3>
            <form action="parsonSave" method="post">
                <div class="mb-3">
                    <input name="name" class="form-control" type="text" placeholder="Name" />
                </div>
                <div class="mb-3">
                    <input name="email" class="form-control" type="email" placeholder="E-Mail" />
                </div>
                <div class="mb-3">
                    <input name="age" class="form-control" type="number" placeholder="Age" />
                </div>
                <div class="mb-3">
                    <input name="phone" class="form-control" type="tel" placeholder="Phone" />
                </div>
                <button type="submit" class="btn btn-success" >Send <i class="bi bi-send"></i> </button>
            </form>
        </div>
        <div class="col-sm-7">
            <h3>Person List</h3>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">E-Mail</th>
                    <th scope="col">Age</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>

                <%
                    for( Person item : ls ) {
                %>
                <tr>
                    <th scope="row"> <%=item.getPid()%> </th>
                    <td> <%=item.getName()%> </td>
                    <td> <%=item.getEmail()%> </td>
                    <td> <%=item.getAge()%> </td>
                    <td> <%=item.getPhone()%> </td>
                    <td>
                        <a href="#" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a>
                    </td>
                </tr>
                <%}%>

                </tbody>
            </table>
        </div>
    </div>



</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
