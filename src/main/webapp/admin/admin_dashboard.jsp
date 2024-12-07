<%--
  Created by IntelliJ IDEA.
  User: nlast
  Date: 07-12-2024
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dto.AdminResponseDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Horoscopo" %>
<%@ page import="repository.HoroscopoRepository" %>
<%@ page import="repository.HoroscopoRepositoryImpl" %>
<%
  AdminResponseDTO admin = (AdminResponseDTO) session.getAttribute("admin");
  if (admin == null) {
    response.sendRedirect("admin_login.jsp");
    return;
  }

  // Obtener la lista de horóscopos
  HoroscopoRepository horoscopoRepository = new HoroscopoRepositoryImpl();
  List<Horoscopo> listaHoroscopos = horoscopoRepository.findAllAnimals();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard Admin</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Bienvenido, <%= admin.getNombre() %></h1>
  <a href="../admin_logout" class="btn btn-danger mb-4">Cerrar Sesión</a>

  <h2>Lista de Horóscopos</h2>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Animal</th>
      <th>Fecha Inicio</th>
      <th>Fecha Fin</th>
    </tr>
    </thead>
    <tbody>
    <% for (Horoscopo horoscopo : listaHoroscopos) { %>
    <tr>
      <td><%= horoscopo.getId() %></td>
      <td><%= horoscopo.getAnimal() %></td>
      <td><%= horoscopo.getFechaInicio() %></td>
      <td><%= horoscopo.getFechaFin() %></td>
    </tr>
    <% } %>
    </tbody>
  </table>

  <h2 class="mt-5">Gestión de Usuarios</h2>
  <a href="user_management.jsp" class="btn btn-primary">Ir a Gestión de Usuarios</a>
</div>
</body>
</html>

