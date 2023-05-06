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
        List<Valorant> matchingRegions = new ArrayList<>();
        if(search != null){
            String finalSearch = search.toLowerCase();
            for (Valorant pro: prosCopy) {
                if (pro.getPlayer().toLowerCase().contains(finalSearch)) {
                    matchingRegions.add(pro);
                }
            }
            matchingRegions.sort((p1, p2) -> p1.getPlayer().compareTo(p2.getPlayer()));
        }
        else {
            search = "";
            matchingRegions.addAll(prosCopy);
        }
        String sort = request.getParameter("sort");
        if (sort == null) {
            sort = "alphaAZ";
        }
        switch (sort) {
            case "alphaAZ":
                matchingRegions.sort((p1, p2) -> p1.getPlayer().compareTo(p2.getPlayer()));
                break;
            case "alphaZA":
                matchingRegions.sort((p1, p2) -> p1.getPlayer().compareTo(p2.getPlayer()) * -1);
                break;
            case "regionAZ":
                matchingRegions.sort((p1, p2) -> p1.getRegion().compareTo(p2.getRegion()));
                break;
            case "regionZA":
                matchingRegions.sort((p1, p2) -> p1.getRegion().compareTo(p2.getRegion()) * -1);
                break;
        }


        request.setAttribute("search", search);
        request.setAttribute("show", show);
        request.setAttribute("sort", sort);
        request.setAttribute("pros", matchingRegions);


        request.getRequestDispatcher("WEB-INF/Valorant.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
