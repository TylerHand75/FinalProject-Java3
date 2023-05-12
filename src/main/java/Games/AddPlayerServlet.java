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
        if(user.getPrivileges().equals("premium")) {
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
        String  acs = request.getParameter("acs");
        String kd = request.getParameter("kd");
        String kast = request.getParameter("kast");
        String hs = request.getParameter("hs");
        String  clutches = request.getParameter("clutches");
        String  k = request.getParameter("k");
        String d = request.getParameter("d");
        String a = request.getParameter("a");
        String openingDuelWinRate = request.getParameter("openingDuelWinRate");
        Map<String, String> results = new HashMap<>();
        Valorant newPro = new Valorant();
        try {
            newPro.setRegion(region);
        } catch(IllegalArgumentException e) {
            results.put("regionError", e.getMessage());

        }
        try {
            newPro.setTeam(team);
        } catch(IllegalArgumentException e) {
            results.put("teamError", e.getMessage());

        }
        try {
            newPro.setPlayer(player);
        } catch(IllegalArgumentException e) {
            results.put("playerError", e.getMessage());

        }

        try {
            newPro.setAcs(acs);
        } catch (NumberFormatException e) {
            results.put("acsError", e.getMessage());

        }
        try {
            newPro.setKd(kd);
        } catch (NumberFormatException e) {
            results.put("kdError", e.getMessage());

        }
        try {
            newPro.setKast(kast);
        } catch (NumberFormatException e) {
            results.put("kastError",e.getMessage());

        }
        try {
            newPro.setHs(hs);
        } catch (NumberFormatException e) {
            results.put("hsError", e.getMessage());

        }
        try {
            newPro.setClutches(clutches);
        } catch (NumberFormatException e) {
            results.put("clutchesError", e.getMessage());

        }
        try {
            newPro.setK(k);
        } catch (NumberFormatException e) {
            results.put("kError", e.getMessage());

        }
        try {
            newPro.setD(d);
        } catch (NumberFormatException e) {
            results.put("dError", e.getMessage());

        }
        try {
            newPro.setA(a);
        } catch (NumberFormatException e) {
            results.put("aError", e.getMessage());
            ;
        }
        try {
            newPro.setOpeningDuelWinRate(openingDuelWinRate);
        } catch (NumberFormatException e) {
            results.put("openingDuelWinRateError", e.getMessage());

        }

        if (!results.isEmpty()) {
            request.setAttribute("results", results);
            request.getRequestDispatcher("WEB-INF/addPlayer.jsp").forward(request, response);
            return;
        }
        if(!results.containsKey( "regionError") &&
                !results.containsKey("teamError") &&
                !results.containsKey("playerError") &&
                !results.containsKey("acsError") &&
                !results.containsKey("kdError") &&
                !results.containsKey("kastError") &&
                !results.containsKey("hsError") &&
                !results.containsKey("clutchesError") &&
                !results.containsKey("kError") &&
                !results.containsKey("dError") &&
                !results.containsKey("aError") &&
                !results.containsKey("openingDuelWinRateError")
        ) {
            ValorantDAO_CSV dao = new ValorantDAO_CSV();
            int numRowsAffected = dao.add(newPro);
            if(numRowsAffected == 1) {
                results.put("success", "Player added successfully!");
                // TO DO
            }
        } else {
            results.put( "region", region);
            results.put("team", team);
            results.put("player", player);
            results.put("acs", String.valueOf(acs));
            results.put("kd", String.valueOf(kd));
            results.put("kast", String.valueOf(kast));
            results.put("hs", String.valueOf(hs));
            results.put("clutches", String.valueOf(clutches));
            results.put("k", String.valueOf(k));
            results.put("d", String.valueOf(d));
            results.put("a", String.valueOf(a));
            results.put("openingDuelWinRate", String.valueOf(openingDuelWinRate));

        }

        request.setAttribute("results", results);
        request.setAttribute("playerAdded", "Player added successfully!");
        request.getRequestDispatcher("WEB-INF/appPlayer.jsp").forward(request, response);
    }

}
