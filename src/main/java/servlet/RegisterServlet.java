package servlet;

import dto.UsuarioCreateDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuarioService;
import service.UsuarioServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    private final UsuarioService usuarioService;

    public RegisterServlet() {this.usuarioService = new UsuarioServiceImpl();}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Capturar parametros del REQUEST
        String nombre = req.getParameter("nombre");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        LocalDateTime fechaNacimiento;

        try {
            fechaNacimiento = LocalDateTime.parse(req.getParameter("fechaNacimiento"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (Exception e) {
            System.out.println("Error al parsear fecha de nacimiento: " + e.getMessage());
            resp.sendRedirect("register.jsp?error=fecha_invalida");
            return;
        }

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        // validacion
        if (nombre == null || nombre.trim().isEmpty() ||
                username == null || username.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                confirmPassword == null || confirmPassword.trim().isEmpty()) {

            System.out.println("Error: Campos vacíos detectados");
            resp.sendRedirect("register.jsp?error=campos_vacios");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Error: Las contraseñas no coinciden");
            resp.sendRedirect("register.jsp?error=password_no_coincide");
            return;
        }

        // Construir DTO en base a parametros
        UsuarioCreateDTO usuario = new UsuarioCreateDTO(
                nombre,
                username,
                email,
                fechaNacimiento,
                password
        );
        System.out.println(usuario);
        System.out.println("Fecha de nacimiento procesada: " + fechaNacimiento);

        // Confirmar registro de nuevo usuario con confirmPassword
        if (usuarioService.registrarUsuario(usuario, confirmPassword)) {
            resp.sendRedirect("login");
        } else {
            resp.sendRedirect("register.jsp?error=1");
        }

    }
}
