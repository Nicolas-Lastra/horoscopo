package servlet;

import dto.HoroscopoResponseDTO;
import dto.UsuarioResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.HoroscopoService;
import service.HoroscopoServiceImpl;
import service.UsuarioService;
import service.UsuarioServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UsuarioService usuarioService;
    private final HoroscopoService horoscopoService;

    public LoginServlet() {
        this.usuarioService = new UsuarioServiceImpl();
        this.horoscopoService = new HoroscopoServiceImpl();
    }

    // Solicitud que presentara la vista del login
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (usuarioService.autenticarUsuario(username, password)) {
            Optional<UsuarioResponseDTO> usuarioAutenticado = usuarioService.findUsuarioByUsername(username);

            List<UsuarioResponseDTO> listaUsuarios = usuarioService.findAllUsuarios();

            int horoscopoId = usuarioAutenticado.get().getAnimal();
            Optional<HoroscopoResponseDTO> horoscopo = horoscopoService.findHoroscopoById(horoscopoId);

            HttpSession session = req.getSession();
            session.setAttribute("username", usuarioAutenticado.get().getUsername());
            session.setAttribute("listaUsuarios", listaUsuarios);
            session.setAttribute("usuarioActual", usuarioAutenticado.get());

            horoscopo.ifPresent(h -> session.setAttribute("horoscopoActual", h));

            resp.sendRedirect("bienvenida.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
