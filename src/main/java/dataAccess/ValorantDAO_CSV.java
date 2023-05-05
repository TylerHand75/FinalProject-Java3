package dataAccess;

import Games.Valorant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class ValorantDAO_CSV {

    public static List<Valorant> getAll(HttpServletRequest request, HttpServletResponse response) {

        List<Valorant> pros = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(request.getServletContext().getRealPath("/WEB-INF/CSVFiles/ValorantData.csv")))) {
            int lineCount = 0;
            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(",");
                lineCount++;
                if (lineCount != 1) {
                    String region = values[0];
                    String team = values[1];
                    String player = values[2];
                    int rnd = Integer.parseInt(values[3]);
                    int acs = Integer.parseInt(values[4]);
                    double kd = Double.parseDouble(values[5]);
                    double kast = Double.parseDouble(values[6]);
                    double adr = Double.parseDouble(values[7]);
                    double kpr = Double.parseDouble(values[8]);
                    double apr = Double.parseDouble(values[9]);
                    double fkpr = Double.parseDouble(values[10]);
                    double fdpr = Double.parseDouble(values[11]);
                    double hs = Double.parseDouble(values[12]);
                    double cl = Double.parseDouble(values[13]);
                    int clutches = Integer.parseInt(values[14]);
                    int kmax = Integer.parseInt(values[15]);
                    int k = Integer.parseInt(values[16]);
                    int d = Integer.parseInt(values[17]);
                    int a = Integer.parseInt(values[18]);
                    int fk = Integer.parseInt(values[19]);
                    int fd = Integer.parseInt(values[20]);
                    int fkfd = Integer.parseInt(values[21]);
                    double openingDuelWinRate = Double.parseDouble(values[22]);
                    double fkfdRatio = Double.parseDouble(values[23]);

                    Valorant val = new Valorant(region, team, player, rnd, acs, kd, kast, adr, kpr, apr, fkpr, fdpr, hs, cl, clutches, kmax, k, d, a, fk, fd, fkfd, openingDuelWinRate, fkfdRatio);
                    pros.add(val);
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return pros;
    }
}


