package UserLogins;

import dataAccess.UserDAO_MySQL;
import org.mindrot.jbcrypt.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginFailed", false);
        request.getRequestDispatcher("WEB-INF/Login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginFailed", false);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO_MySQL dao = new UserDAO_MySQL();
        User user = dao.getUser(email);
        if(email == null || email.equals("") || password == null || password.equals("") || user == null) {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("WEB-INF/Login/login.jsp").forward(request, response);
        } else {
            // User was found
            if(BCrypt.checkpw(password, String.valueOf(user.getPassword()))) {
                // Match!
                HttpSession session = request.getSession();
                request.changeSessionId();
                user.unsetPassword();
                session.setAttribute("user", user);
                System.out.printf("User %s logged in%n", user.getEmail());
                request.getRequestDispatcher("WEB-INF/addPlayer.jsp").forward(request, response);
            } else {
                // Not match
                request.setAttribute("loginFailed", true);
                System.out.printf("User %s not logged in%n", user.getEmail());
                request.getRequestDispatcher("WEB-INF/Login/login.jsp").forward(request, response);
            }
        }
    }
}
