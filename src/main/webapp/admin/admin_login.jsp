<%--
  Created by IntelliJ IDEA.
  User: nlast
  Date: 07-12-2024
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inicio de Sesión - Administrador</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body class="bg-light">
<div class="container">
  <div class="row justify-content-center mt-5">
    <div class="col-md-6">
      <div class="card">
        <div class="card-body">
          <h2 class="card-title text-center mb-4">Inicio de Sesión - Administrador</h2>

          <% if (request.getParameter("error") != null) { %>
          <div class="alert alert-danger" role="alert">
            Usuario o contraseña incorrectos. Intente nuevamente.
          </div>
          <% } %>

          <% if ("success".equals(request.getParameter("logout"))) { %>
          <div class="alert alert-success" role="alert">
            La sesión se ha cerrado correctamente.
          </div>
          <% } %>


          <form action="../admin" method="post">
            <div class="mb-3">
              <label for="username" class="form-label">Nombre de Usuario</label>
              <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Contraseña</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="d-grid gap-2">
              <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
            </div>
          </form>

          <!-- Botón adicional para ir a la página principal -->
          <div class="text-center mt-4">
            <a href="../index.jsp" class="btn btn-secondary">Volver a la Página Principal</a>
          </div>

        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>

