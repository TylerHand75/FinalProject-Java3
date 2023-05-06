package Games;

import dataAccess.ValorantDAO_CSV;

import java.util.List;

public class Valorant implements Comparable<Valorant>, Cloneable {
    private String region;
    private String team;
    private String player;
    private int acs;
    private double kd;
    private double kast;
    private double hs;
    private int clutches;
    private int k;
    private int d;
    private int a;
    private double openingDuelWinRate;


    public Valorant() {
        this("Unknown", "Unknown", "Unknown",0,0,0,0,0,0,0,0,0);
    }

    public Valorant(String region,String team,String player, int acs, double kd, double kast, double hs, int clutches, int k,int d,int a, double openingDuelWinRate) {
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

    public double getKd() {
        return kd;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }


    public int getAcs() {
        return acs;
    }

    public void setAcs(int acs) {
        this.acs = acs;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getKast() {
        return kast;
    }

    public void setKast(double kast) {
        this.kast = kast;
    }

    public double getHs() {
        return hs;
    }

    public void setHs(double hs) {
        this.hs = hs;
    }

    public int getClutches() {
        return clutches;
    }

    public void setClutches(int clutches) {
        this.clutches = clutches;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getOpeningDuelWinRate() {
        return openingDuelWinRate;
    }

    public void setOpeningDuelWinRate(double openingDuelWinRate) {
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

