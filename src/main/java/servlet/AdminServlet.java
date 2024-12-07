package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AdminService;
import service.AdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {

    private final AdminService adminService;

    public AdminServlet() {
        this.adminService = new AdminServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        adminService.autenticarAdmin(username, password)
                .ifPresentOrElse(admin -> {
                    HttpSession session = req.getSession();
                    session.setAttribute("admin", admin);
                    try {
                        resp.sendRedirect("admin/admin_dashboard.jsp");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, () -> {
                    try {
                        resp.sendRedirect("admin/admin_login.jsp?error=1");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
