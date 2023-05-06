package Games;

import dataAccess.ValorantDAO_CSV;

import java.util.List;

public class Valorant implements Comparable<Valorant>, Cloneable {
    private String region;
    private String team;
    private String player;
    private String acs;
    private String kd;
    private String kast;
    private String hs;
    private String clutches;
    private String k;
    private String d;
    private String a;
    private String openingDuelWinRate;


    public Valorant() {
        this("Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown");
    }

    public Valorant(String region,String team,String player, String acs, String kd, String kast, String hs, String clutches, String k,String d,String a, String openingDuelWinRate) {
        this.region = region;
        this.team   = team;
        this.player = player;
        this.acs    = acs;
        this.kd     = kd;
        this.kast   = kast;
        this.hs     = hs;
        this.clutches = clutches;
        this.k      = k;
        this.d      = d;
        this.a      = a;
        this.openingDuelWinRate = openingDuelWinRate;

    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }

    public String getKd() {
        return kd;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }


    public String getAcs() {
        return acs;
    }

    public void setAcs(String acs) {
        this.acs = acs;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }

    public String getKast() {
        return kast;
    }

    public void setKast(String kast) {
        this.kast = kast;
    }

    public String getHs() {
        return hs;
    }

    public void setHs(String hs) {
        this.hs = hs;
    }

    public String getClutches() {
        return clutches;
    }

    public void setClutches(String clutches) {
        this.clutches = clutches;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getOpeningDuelWinRate() {
        return openingDuelWinRate;
    }

    public void setOpeningDuelWinRate(String openingDuelWinRate) {
        this.openingDuelWinRate = openingDuelWinRate;
    }


    @Override
    public int compareTo(Valorant o) {
        return this.player.compareTo(o.player);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



}

