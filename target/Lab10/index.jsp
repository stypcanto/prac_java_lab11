<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="styp.com.lab10.Profesor" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Profesores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h1 class="mb-4 text-primary">📚 Lista de Profesores</h1>

    <%-- Mostrar error si existe --%>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <div class="alert alert-danger"><%= error %></div>
    <%
        }
    %>

    <%
        List<Profesor> profesores = (List<Profesor>) request.getAttribute("profesores");
        if (profesores != null && !profesores.isEmpty()) {
    %>
    <table class="table table-bordered table-hover table-striped shadow-sm">
        <thead class="table-dark">
        <tr>
            <th>#</th>
            <th>Ap. Paterno</th>
            <th>Ap. Materno</th>
            <th>Nombres</th>
            <th>Nacimiento</th>
            <th>Dirección</th>
            <th>Referencia</th>
            <th>Género</th>
            <th>Estado</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Profesor p : profesores) {
        %>
        <tr>
            <td><%= p.getIdProfesor() %></td>
            <td><%= p.getApPaterno() %></td>
            <td><%= p.getApMaterno() %></td>
            <td><%= p.getNombres() %></td>
            <td><%= p.getNacimiento() %></td>
            <td><%= p.getDireccion() %></td>
            <td><%= p.getReferencia() != null ? p.getReferencia() : "" %></td>
            <td><%= p.getGenero() %></td>
            <td><%= p.getEstado() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <div class="alert alert-warning text-center">
        <strong>No hay profesores registrados.</strong>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
