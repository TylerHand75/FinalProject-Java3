package Games;

import dataAccess.ValorantDAO_CSV;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GameServlet", value = "/valorant")
public class ValorantServlet extends HttpServlet {
    private List<Valorant> pros;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(pros == null) {
            pros = ValorantDAO_CSV.getAll(request, response);
        }

        // Clone the list to avoid modifying the original list
        List<Valorant> prosCopy = new ArrayList<>(pros.size());
        for(Valorant pro: pros) {
            try {
                prosCopy.add((Valorant)pro.clone());
            } catch(CloneNotSupportedException e) {

            }
        }

        String show = request.getParameter("show");
        if(show == null) {
            show = "all";
        }

        if(!show.equalsIgnoreCase("all")) {
            String finalShow = show.replaceAll("\\+", " "); // An effectively final variable that can be used with a lambda expression
            prosCopy.removeIf(pro -> !pro.getRegion().equals(finalShow));
        }

        String search = request.getParameter("search");
        if(search != null){
            String finalSearch = search;
            prosCopy.removeIf(pro -> !pro.getPlayer().toLowerCase().contains(finalSearch.toLowerCase()));
        }
        else {
            search = "";
        }

        request.setAttribute("search", search);
        request.setAttribute("show", show);

        request.setAttribute("pros", prosCopy);

        request.getRequestDispatcher("WEB-INF/Valorant.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
