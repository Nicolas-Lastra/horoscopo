package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UsuarioRepository;
import repository.UsuarioRepositoryImpl;

import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/delete_user")
public class DeleteUserServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository;

    public DeleteUserServlet() {
        this.usuarioRepository = new UsuarioRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Capturar el ID del usuario a eliminar
            int id = Integer.parseInt(req.getParameter("id"));

            // Llamar al metodo delete en el repositorio
            boolean eliminado = usuarioRepository.deleteById(id);

            // Redirigir según el resultado
            if (eliminado) {
                resp.sendRedirect("admin/user_management.jsp?success=deleted");
            } else {
                resp.sendRedirect("admin/user_management.jsp?error=delete_failed");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("admin/user_management.jsp?error=invalid_id");
        }
    }
}
