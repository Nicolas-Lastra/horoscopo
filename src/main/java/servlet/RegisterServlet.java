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
        LocalDateTime fechaNacimiento = LocalDateTime.parse(req.getParameter("fechaNacimiento"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        // Construir DTO en base a parametros
        UsuarioCreateDTO usuario = new UsuarioCreateDTO(
                nombre,
                username,
                email,
                fechaNacimiento,
                password
        );
        System.out.println(usuario);
        System.out.println(fechaNacimiento);

        // Confirmar registro de nuevo usuario con confirmPassword
        if (usuarioService.registrarUsuario(usuario, confirmPassword)) {
            resp.sendRedirect("login");
        } else {
            resp.sendRedirect("index.jsp?error=1");
        }

    }
}
