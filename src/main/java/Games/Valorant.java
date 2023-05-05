package Games;

public class Valorant implements Comparable<Valorant>, Cloneable {
    private String region;
    private String team;
    private String player;
    private int rnd;
    private double acs;
    private double kd;
    private double kast;
    private double adr;
    private double kpr;
    private double apr;
    private double fkpr;
    private double fdpr;
    private double hs;
    private double cl;
    private int clutches;
    private int kmax;
    private int k;
    private int d;
    private int a;
    private int fk;
    private int fd;
    private int fkfd;
    private double openingDuelWinRate;
    private double fkfdRatio;

    public Valorant() {
        this("Unknown", "Unknown", "Unknown",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
    }

    public Valorant(String region, String team, String player, int rnd, double acs, double kd, double kast,
                    double adr, double kpr, double apr, double fkpr, double fdpr, double hs, double cl,
                    int clutches, int kmax, int k, int d, int a, int fk, int fd, int fkfd,
                    double openingDuelWinRate, double fkfdRatio) {
        this.region = region;
        this.team   = team;
        this.player = player;
        this.rnd    = rnd;
        this.acs    = acs;
        this.kd     = kd;
        this.kast   = kast;
        this.adr    = adr;
        this.kpr    = kpr;
        this.apr    = apr;
        this.fkpr   = fkpr;
        this.fdpr   = fdpr;
        this.hs     = hs;
        this.cl     = cl;
        this.clutches = clutches;
        this.kmax   = kmax;
        this.k      = k;
        this.d      = d;
        this.a      = a;
        this.fk     = fk;
        this.fd     = fd;
        this.fkfd   = fkfd;
        this.openingDuelWinRate = openingDuelWinRate;
        this.fkfdRatio = fkfdRatio;
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

    public double getKd() {
        return kd;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getRnd() {
        return rnd;
    }

    public void setRnd(int rnd) {
        this.rnd = rnd;
    }

    public double getAcs() {
        return acs;
    }

    public void setAcs(float acs) {
        this.acs = acs;
    }

    public void setKd(float kd) {
        this.kd = kd;
    }

    public double getKast() {
        return kast;
    }

    public void setKast(float kast) {
        this.kast = kast;
    }

    public double getAdr() {
        return adr;
    }

    public void setAdr(float adr) {
        this.adr = adr;
    }

    public double getKpr() {
        return kpr;
    }

    public void setKpr(float kpr) {
        this.kpr = kpr;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(float apr) {
        this.apr = apr;
    }

    public double getFkpr() {
        return fkpr;
    }

    public void setFkpr(float fkpr) {
        this.fkpr = fkpr;
    }

    public double getFdpr() {
        return fdpr;
    }

    public void setFdpr(float fdpr) {
        this.fdpr = fdpr;
    }

    public double getHs() {
        return hs;
    }

    public void setHs(float hs) {
        this.hs = hs;
    }

    public double getCl() {
        return cl;
    }

    public void setCl(float cl) {
        this.cl = cl;
    }

    public int getClutches() {
        return clutches;
    }

    public void setClutches(int clutches) {
        this.clutches = clutches;
    }

    public int getKmax() {
        return kmax;
    }

    public void setKmax(int kmax) {
        this.kmax = kmax;
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

    public int getFk() {
        return fk;
    }

    public void setFk(int fk) {
        this.fk = fk;
    }

    public int getFd() {
        return fd;
    }

    public void setFd(int fd) {
        this.fd = fd;
    }

    public int getFkfd() {
        return fkfd;
    }

    public void setFkfd(int fkfd) {
        this.fkfd = fkfd;
    }

    public double getOpeningDuelWinRate() {
        return openingDuelWinRate;
    }

    public void setOpeningDuelWinRate(float openingDuelWinRate) {
        this.openingDuelWinRate = openingDuelWinRate;
    }

    public double getFkfdRatio() {
        return fkfdRatio;
    }

    public void setFkfdRatio(float fkfdRatio) {
        this.fkfdRatio = fkfdRatio;
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

