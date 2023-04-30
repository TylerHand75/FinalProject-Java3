package dataAccess;

import Games.Valorant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;




public class ValorantDAO_CSV {

    public static List<Valorant> getAll(HttpServletRequest request, HttpServletResponse response) {
        List<Valorant> pros = new ArrayList<>();
        String path = request.getServletContext().getRealPath("/WEB-INF/ValorantData.csv");

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String region = values[0];
                String team = values[1];
                String player = values[2];
                int rnd = Integer.parseInt(values[3]);
                int acs = Integer.parseInt(values[4]);
                float kd = Float.parseFloat(values[5]);
                float kast = Float.parseFloat(values[6]);
                float adr = Float.parseFloat(values[7]);
                float kpr = Float.parseFloat(values[8]);
                float apr = Float.parseFloat(values[9]);
                float fkpr = Float.parseFloat(values[10]);
                float fdpr = Float.parseFloat(values[11]);
                float hs = Float.parseFloat(values[12]);
                float cl = Float.parseFloat(values[13]);
                int clutches = Integer.parseInt(values[14]);
                int kmax = Integer.parseInt(values[15]);
                int k = Integer.parseInt(values[16]);
                int d = Integer.parseInt(values[17]);
                int a = Integer.parseInt(values[18]);
                int fk = Integer.parseInt(values[19]);
                int fd = Integer.parseInt(values[20]);
                int fkfd = Integer.parseInt(values[21]);
                float openingDuelWinRate = Float.parseFloat(values[22]);
                float fkfdRatio = Float.parseFloat(values[23]);

                Valorant val = new Valorant( region, team,  player,  rnd,  acs, kd,  kast,  adr,  kpr,  apr,  fkpr,  fdpr,  hs,  cl,  clutches,  kmax,  k, d,  a,  fk,  fd,  fkfd,  openingDuelWinRate,  fkfdRatio);
                pros.add(val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pros;
    }
    }


