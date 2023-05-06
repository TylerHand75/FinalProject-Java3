package dataAccess;

import Games.Valorant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class ValorantDAO_CSV {
    private static final String FILE_NAME = "WEB-INF/CSVFiles/ValorantData.csv";
    private static List<Valorant> daoProPlayers = new ArrayList<>();

    public static List<Valorant> getAll(HttpServletRequest request, HttpServletResponse response) {
        daoProPlayers.clear();

        readInData(request, response);

        Collections.sort(daoProPlayers);
        return daoProPlayers;
    }

    private static void readInData(HttpServletRequest request, HttpServletResponse response) {
        try (Scanner scanner = new Scanner(new File(request.getServletContext().getRealPath("/WEB-INF/CSVFiles/ValorantData.csv")))) {
            int lineCount = 0;
            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(",");
                lineCount++;
                if (lineCount != 1) {
                    String region = values[0];
                    String team = values[1];
                    String player = values[2];
                    String acs = values[3];
                    String kd = values[4];
                    String kast = values[5];
                    String hs = values[6];
                    String clutches = values[7];
                    String k = values[8];
                    String  d = values[9];
                    String  a = values[10];
                    String openingDuelWinRate = values[11];
                    Valorant proPlayers = new Valorant(region, team, player, acs, kd, kast, hs, clutches, k, d, a, openingDuelWinRate);
                    daoProPlayers.add(proPlayers);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static boolean add(Valorant proPlayer, HttpServletRequest request, HttpServletResponse response) {
        daoProPlayers.add(proPlayer);

        return addPlayer(request);
    }

    private static boolean addPlayer(HttpServletRequest request) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(request.getServletContext().getRealPath("/WEB-INF/CSVFiles/ValorantData.csv"))));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(request.getServletContext().getRealPath("/WEB-INF/CSVFiles/ValorantData.csv")), true))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            Valorant newPro = daoProPlayers.get(daoProPlayers.size() - 1);
            writer.write(
                    newPro.getRegion() + ","
                    + newPro.getTeam() + ","
                    + newPro.getPlayer() + ","
                    + newPro.getAcs() + ","
                    + newPro.getKd() + ","
                    + newPro.getKast() + ","
                    + newPro.getHs() + ","
                    + newPro.getClutches()
                    + "," + newPro.getK()
                    + "," + newPro.getD()
                    + "," + newPro.getA()
                    + "," + newPro.getOpeningDuelWinRate());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean remove(String playerName, HttpServletRequest request, HttpServletResponse response) {
        Valorant proPlayer = null;
        for (Valorant p : daoProPlayers) {
            if (p.getPlayer().equals(playerName)) {
                proPlayer = p;
                break;
            }
        }
        if (proPlayer != null) {
            daoProPlayers.remove(proPlayer);
            return updateFile(request);
        }
        return false;
    }

    private static boolean updateFile(HttpServletRequest request) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(request.getServletContext().getRealPath("/WEB-INF/CSVFiles/ValorantData.csv"))))) {
            writer.write("Region,Team,Player,ACS,K/D,KAST,HS%,Clutches,Kills,Deaths,Assists,Opening Duel Win Rate");
            writer.newLine();
            for (Valorant p : daoProPlayers) {
                writer.write(p.getRegion() + "," + p.getTeam() + "," + p.getPlayer() + "," + p.getAcs() + "," + p.getKd() + "," + p.getKast() + "," + p.getHs() + "," + p.getClutches() + "," + p.getK() + "," + p.getD() + "," + p.getA() + "," + p.getOpeningDuelWinRate());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int add(Valorant newPro) {
        if (daoProPlayers.add(newPro) )
            return 1;
        else{
            return 0;
        }
    }
}



