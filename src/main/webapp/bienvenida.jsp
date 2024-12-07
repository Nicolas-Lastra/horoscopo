<%@ page import="dto.UsuarioResponseDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="modelo.Horoscopo" %>
<%@ page import="dto.HoroscopoResponseDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login");
        return;
    }

    UsuarioResponseDTO usuarioActual = (UsuarioResponseDTO) session.getAttribute("usuarioActual");
    HoroscopoResponseDTO horoscopoActual = (HoroscopoResponseDTO) session.getAttribute("horoscopoActual");

%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body class="bg-light">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center mb-4">Bienvenid@ <%= usuarioActual.getUsername() %></h2>

                    <% if ("success".equals(request.getParameter("logout"))) { %>
                    <div class="alert alert-success" role="alert">
                        La sesión se ha cerrado correctamente.
                    </div>
                    <% } %>

                    <% if (request.getParameter("error") != null) { %>
                    <div class="alert alert-danger" role="alert">
                        Usuario o contraseña incorrectas
                    </div>
                    <% } %>

                    <!-- Información del usuario actual -->
                    <div class="card mb-4">
                        <div class="card-header">
                            Tu información
                        </div>

                        <div class="card-body">
                            <p><strong>Username:</strong> <%= usuarioActual.getUsername() %></p>
                            <p><strong>Email:</strong> <%= usuarioActual.getEmail() %></p>
                            <p><strong>Id asociada a tu horóscopo:</strong> <%= usuarioActual.getAnimal() %></p>
                            <p><strong>Tu animal interior:</strong> <%= horoscopoActual.getAnimal() %></p>
                        </div>

                        <!-- Botón cerrar sesión -->
                        <div class="d-grid gap-2 mt-4">
                            <a href="logout" class="btn btn-danger">Cerrar sesión</a>
                        </div>

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