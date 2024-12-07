<%--
  Created by IntelliJ IDEA.
  User: nlast
  Date: 07-12-2024
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inicio</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-light">
<div class="container text-center mt-5">
  <h1 class="mb-4">Bienvenido al Sistema de Horóscopos</h1>
  <p class="lead mb-5">Seleccione una de las siguientes opciones:</p>

  <div class="row justify-content-center">
    <!-- Iniciar sesión como usuario -->
    <div class="col-md-4">
      <a href="login.jsp" class="btn btn-primary btn-lg btn-block mb-3">Iniciar Sesión como Usuario</a>
    </div>
    <!-- Iniciar sesión como administrador -->
    <div class="col-md-4">
      <a href="admin/admin_login.jsp" class="btn btn-secondary btn-lg btn-block mb-3">Iniciar Sesión como Administrador</a>
    </div>
    <!-- Registrarse como usuario -->
    <div class="col-md-4">
      <a href="register.jsp" class="btn btn-success btn-lg btn-block mb-3">Registrarse como Usuario</a>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
