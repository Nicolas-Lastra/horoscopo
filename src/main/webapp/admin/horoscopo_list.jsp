<%--
  Created by IntelliJ IDEA.
  User: nlast
  Date: 07-12-2024
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Horoscopo" %>
<%@ page import="repository.HoroscopoRepository" %>
<%@ page import="repository.HoroscopoRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%
  HoroscopoRepository horoscopoRepository = new HoroscopoRepositoryImpl();
  List<Horoscopo> listaHoroscopos = horoscopoRepository.findAllAnimals();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Lista de Horóscopos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Lista de Horóscopos</h1>
  <a href="admin_dashboard.jsp" class="btn btn-secondary mb-4">Volver al Dashboard</a>

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
</div>
</body>
</html>

