package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuarios;
import repository.UsuarioRepository;
import repository.UsuarioRepositoryImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "EditUserServlet", value = "/edit_user")
public class EditUserServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository;

    public EditUserServlet() {this.usuarioRepository = new UsuarioRepositoryImpl();}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Capturar parámetros enviados desde el formulario
            int id = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // Parsear la fecha de nacimiento al formato adecuado
            LocalDateTime fechaNacimiento = LocalDateTime.parse(req.getParameter("fechaNacimiento"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            // Crear el objeto Usuario con los datos nuevos
            Usuarios usuario = new Usuarios();
            usuario.setId(id); // Es necesario para identificar qué usuario actualizar
            usuario.setNombre(nombre);
            usuario.setUsername(username);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setFechaNacimiento(fechaNacimiento);

            // Llamar al metodo update en el repositorio
            boolean actualizado = usuarioRepository.update(usuario);

            // Redirigir según el resultado de la operación
            if (actualizado) {
                resp.sendRedirect("admin/user_management.jsp?success=updated");
            } else {
                resp.sendRedirect("admin/user_management.jsp?error=update_failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("admin/user_management.jsp?error=invalid_data");
        }
    }
}
