package Games;

public class Valorant implements Comparable<Valorant>, Cloneable {
    private String region;
    private String team;
    private String player;
    private int rnd;
    private float acs;
    private float kd;
    private float kast;
    private float adr;
    private float kpr;
    private float apr;
    private float fkpr;
    private float fdpr;
    private float hs;
    private float cl;
    private int clutches;
    private int kmax;
    private int k;
    private int d;
    private int a;
    private int fk;
    private int fd;
    private int fkfd;
    private float openingDuelWinRate;
    private float fkfdRatio;

    public Valorant() {
        this("Unknown", "Unknown", "Unknown",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
    }

    public Valorant(String region, String team, String player, int rnd, float acs, float kd, float kast,
                    float adr, float kpr, float apr, float fkpr, float fdpr, float hs, float cl,
                    int clutches, int kmax, int k, int d, int a, int fk, int fd, int fkfd,
                    float openingDuelWinRate, float fkfdRatio) {
        this.region = region;
        this.team = team;
        this.player = player;
        this.rnd = rnd;
        this.acs = acs;
        this.kd = kd;
        this.kast = kast;
        this.adr = adr;
        this.kpr = kpr;
        this.apr = apr;
        this.fkpr = fkpr;
        this.fdpr = fdpr;
        this.hs = hs;
        this.cl = cl;
        this.clutches = clutches;
        this.kmax = kmax;
        this.k = k;
        this.d = d;
        this.a = a;
        this.fk = fk;
        this.fd = fd;
        this.fkfd = fkfd;
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

    public float getKd() {
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

    public float getAcs() {
        return acs;
    }

    public void setAcs(float acs) {
        this.acs = acs;
    }

    public void setKd(float kd) {
        this.kd = kd;
    }

    public float getKast() {
        return kast;
    }

    public void setKast(float kast) {
        this.kast = kast;
    }

    public float getAdr() {
        return adr;
    }

    public void setAdr(float adr) {
        this.adr = adr;
    }

    public float getKpr() {
        return kpr;
    }

    public void setKpr(float kpr) {
        this.kpr = kpr;
    }

    public float getApr() {
        return apr;
    }

    public void setApr(float apr) {
        this.apr = apr;
    }

    public float getFkpr() {
        return fkpr;
    }

    public void setFkpr(float fkpr) {
        this.fkpr = fkpr;
    }

    public float getFdpr() {
        return fdpr;
    }

    public void setFdpr(float fdpr) {
        this.fdpr = fdpr;
    }

    public float getHs() {
        return hs;
    }

    public void setHs(float hs) {
        this.hs = hs;
    }

    public float getCl() {
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

    public float getOpeningDuelWinRate() {
        return openingDuelWinRate;
    }

    public void setOpeningDuelWinRate(float openingDuelWinRate) {
        this.openingDuelWinRate = openingDuelWinRate;
    }

    public float getFkfdRatio() {
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

