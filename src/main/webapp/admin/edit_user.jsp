<%--
  Created by IntelliJ IDEA.
  User: nlast
  Date: 07-12-2024
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Usuarios" %>
<%@ page import="repository.UsuarioRepository" %>
<%@ page import="repository.UsuarioRepositoryImpl" %>
<%
  String userIdParam = request.getParameter("id");
  if (userIdParam == null || userIdParam.trim().isEmpty()) {
    response.sendRedirect("user_management.jsp?error=invalid_user");
    return;
  }

  int userId = Integer.parseInt(userIdParam);
  UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
  Usuarios usuario = usuarioRepository.findById(userId).orElse(null); // Cambiado para usar findById

  if (usuario == null) {
    response.sendRedirect("user_management.jsp?error=user_not_found");
    return;
  }
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Usuario</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Editar Usuario</h1>
  <a href="user_management.jsp" class="btn btn-secondary mb-4">Volver a Gestión de Usuarios</a>

  <form action="../edit_user" method="post">
    <input type="hidden" name="id" value="<%= usuario.getId() %>">

    <div class="mb-3">
      <label for="nombre" class="form-label">Nombre</label>
      <input type="text" class="form-control" id="nombre" name="nombre" value="<%= usuario.getNombre() %>" required>
    </div>

    <div class="mb-3">
      <label for="username" class="form-label">Nombre de Usuario</label>
      <input type="text" class="form-control" id="username" name="username" value="<%= usuario.getUsername() %>" required>
    </div>

    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" class="form-control" id="email" name="email" value="<%= usuario.getEmail() %>" required>
    </div>

    <div class="mb-3">
      <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
      <input type="datetime-local" class="form-control" id="fechaNacimiento" name="fechaNacimiento"
             value="<%= usuario.getFechaNacimiento().toString().replace('T', ' ') %>" required>
    </div>

    <div class="mb-3">
      <label for="password" class="form-label">Contraseña</label>
      <input type="password" class="form-control" id="password" name="password" value="<%= usuario.getPassword() %>" required>
    </div>

    <div class="d-grid gap-2">
      <button type="submit" class="btn btn-success">Guardar Cambios</button>
    </div>
  </form>

</div>
</body>
</html>
