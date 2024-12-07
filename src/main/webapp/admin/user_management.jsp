<%--
  Created by IntelliJ IDEA.
  User: nlast
  Date: 07-12-2024
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Usuarios" %>
<%@ page import="repository.UsuarioRepository" %>
<%@ page import="repository.UsuarioRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%
  UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
  List<Usuarios> listaUsuarios = usuarioRepository.findAll();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gestión de Usuarios</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">

  <% if ("deleted".equals(request.getParameter("success"))) { %>
  <div class="alert alert-success" role="alert">
    Usuario eliminado correctamente.
  </div>
  <% } %>

  <% if ("delete_failed".equals(request.getParameter("error"))) { %>
  <div class="alert alert-danger" role="alert">
    No se pudo eliminar el usuario. Intente nuevamente.
  </div>
  <% } %>

  <% if ("invalid_id".equals(request.getParameter("error"))) { %>
  <div class="alert alert-warning" role="alert">
    ID de usuario inválido.
  </div>
  <% } %>

  <h1 class="mb-4">Gestión de Usuarios</h1>
  <a href="admin_dashboard.jsp" class="btn btn-secondary mb-4">Volver al Dashboard</a>

  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Nombre</th>
      <th>Username</th>
      <th>Email</th>
      <th>Fecha de Nacimiento</th>
      <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <% for (Usuarios usuario : listaUsuarios) { %>
    <tr>
      <td><%= usuario.getId() %></td>
      <td><%= usuario.getNombre() %></td>
      <td><%= usuario.getUsername() %></td>
      <td><%= usuario.getEmail() %></td>
      <td><%= usuario.getFechaNacimiento() %></td>
      <td>
        <a href="edit_user.jsp?id=<%= usuario.getId() %>" class="btn btn-warning btn-sm">Editar</a>
        <!-- Formulario para eliminar -->
        <form action="../delete_user" method="post" style="display: inline;">
          <input type="hidden" name="id" value="<%= usuario.getId() %>">
          <button type="submit" class="btn btn-danger">Eliminar</button>
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
</body>
</html>

