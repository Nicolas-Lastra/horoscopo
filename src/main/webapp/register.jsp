<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body class="bg-light">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center mb-4">Registro de Usuario</h2>

                    <% if (request.getParameter("error") != null) { %>
                    <div class="alert alert-danger" role="alert">
                        Error en el registro. Por favor, intente nuevamente.
                    </div>
                    <% } %>

                    <% if ("fecha_invalida".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger" role="alert">
                        La fecha de nacimiento ingresada no es válida. Por favor, verifica el formato.
                    </div>
                    <% } %>

                    <% if ("fecha_invalida".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger" role="alert">
                        La fecha de nacimiento ingresada no es válida. Por favor, verifica el formato.
                    </div>
                    <% } %>

                    <% if ("campos_vacios".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger" role="alert">
                        Todos los campos son obligatorios. Por favor, complete el formulario.
                    </div>
                    <% } %>

                    <% if ("password_no_coincide".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger" role="alert">
                        Las contraseñas no coinciden. Intente nuevamente.
                    </div>
                    <% } %>

                    <form action="register" method="post">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>

                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="fechaNacimiento" class="form-label">Fecha de nacimiento</label>
                            <input type="datetime-local" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>

                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">Confirmar Contraseña</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Registrarse</button>
                        </div>

                        <div class="text-center mt-3">
                            <p>¿Ya tienes una cuenta? <a href="login" class="text-decoration-none">Iniciar Sesión</a></p>
                        </div>

                        <!-- Botón adicional para redirigir a la página principal -->
                        <div class="text-center mt-4">
                            <a href="index.jsp" class="btn btn-secondary">Volver a la Página Principal</a>
                        </div>

                    </form>
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