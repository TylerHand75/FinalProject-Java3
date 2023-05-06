package Games;

import UserLogins.User;
import dataAccess.UserDAO_MySQL;
import dataAccess.ValorantDAO_CSV;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddPlayerServlet", value = "/add-player")
public class AddPlayerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        System.out.println(session.getMaxInactiveInterval());
        if(session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }
        UserDAO_MySQL user_data = new UserDAO_MySQL();
        request.setAttribute("users",user_data.getAll());
        User user = (User)session.getAttribute("user");
        if(user.getPrivileges().equals("none")) {
            request.getRequestDispatcher("WEB-INF/addPlayer.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()); // Send them to the homepage
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String region = request.getParameter("region");
        String team = request.getParameter("team");
        String player = request.getParameter("player");
        int acs = Integer.parseInt(request.getParameter("acs"));
        double kd = Double.parseDouble(request.getParameter("kd"));
        double kast = Double.parseDouble(request.getParameter("kast"));
        double hs = Double.parseDouble(request.getParameter("hs"));
        int clutches = Integer.parseInt(request.getParameter("clutches"));
        int k = Integer.parseInt(request.getParameter("k"));
        int d = Integer.parseInt(request.getParameter("d"));
        int a = Integer.parseInt(request.getParameter("a"));
        double openingDuelWinRate = Double.parseDouble(request.getParameter("openingDuelWinRate"));
        Map<String, String> results = new HashMap<>();
        Valorant newPro = new Valorant();
        try {
            newPro.setRegion(region);
        } catch(IllegalArgumentException e) {
            results.put("regionError", e.getMessage());
            results.put("regionInvalid", "is-invalid");
        }
        try {
            newPro.setTeam(team);
        } catch(IllegalArgumentException e) {
            results.put("teamError", e.getMessage());
            results.put("teamInvalid", "is-invalid");
        }
        try {
            newPro.setPlayer(player);
        } catch(IllegalArgumentException e) {
            results.put("playerError", e.getMessage());
            results.put("playerInvalid", "is-invalid");
        }

        try {
            newPro.setAcs(acs);
        } catch (NumberFormatException e) {
            results.put("acsError", "Invalid ACS input");
            results.put("acsInvalid", "is-invalid");
        }
        try {
            newPro.setKd(kd);
        } catch (NumberFormatException e) {
            results.put("kdError", "Invalid KD input");
            results.put("kdInvalid", "is-invalid");
        }
        try {
            newPro.setKast(kast);
        } catch (NumberFormatException e) {
            results.put("kastError", "Invalid KAST input");
            results.put("kastInvalid", "is-invalid");
        }
        try {
            newPro.setHs(hs);
        } catch (NumberFormatException e) {
            results.put("hsError", "Invalid HS input");
            results.put("hsInvalid", "is-invalid");
        }
        try {
            newPro.setClutches(clutches);
        } catch (NumberFormatException e) {
            results.put("clutchesError", "Invalid Clutches input");
            results.put("clutchesInvalid", "is-invalid");
        }
        try {
            newPro.setK(k);
        } catch (NumberFormatException e) {
            results.put("kError", "Invalid K input");
            results.put("kInvalid", "is-invalid");
        }
        try {
            newPro.setD(d);
        } catch (NumberFormatException e) {
            results.put("dError", "Invalid D input");
            results.put("dInvalid", "is-invalid");
        }
        try {
            newPro.setA(a);
        } catch (NumberFormatException e) {
            results.put("aError", "Invalid A input");
            results.put("aInvalid", "is-invalid");
        }
        try {
            newPro.setOpeningDuelWinRate(openingDuelWinRate);
        } catch (NumberFormatException e) {
            results.put("openingDuelWinRateError", "Invalid Opening Duel Win Rate input");
            results.put("openingDuelWinRateInvalid", "is-invalid");
        }

        if (!results.isEmpty()) {
            request.setAttribute("results", results);
            request.getRequestDispatcher("WEB-INF/addPlayer.jsp").forward(request, response);
            return;
        }

        ValorantDAO_CSV valorant_data = new ValorantDAO_CSV();
        valorant_data.add(newPro);


        request.setAttribute("playerAdded", "Player added successfully!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
