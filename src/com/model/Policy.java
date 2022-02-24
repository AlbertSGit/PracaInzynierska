package com.model;

public class Policy {
    private long id;
    private long pid;
    private String cupid;
    private String pname;
    private String pterm;
    private double pamt;
    private double pfamt;
    private double pint;
    private double pbper;
    private double prat;
    private String aid;
    private String nom;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRela() {
        return rela;
    }

    public void setRela(String rela) {
        this.rela = rela;
    }

    private String rela;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public PolicyType getPoliceType() {
        return policeType;
    }

    public void setPoliceType(PolicyType policeType) {
        this.policeType = policeType;
    }

    private PolicyType policeType;


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    private String cid;

    public String getCupid() {
        return cupid;
    }

    public void setCupid(String cupid) {
        this.cupid = cupid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPterm() {
        return pterm;
    }

    public void setPterm(String pterm) {
        this.pterm = pterm;
    }

    public double getPamt() {
        return pamt;
    }

    public void setPamt(double pamt) {
        this.pamt = pamt;
    }

    public double getPfamt() {
        return pfamt;
    }

    public void setPfamt(double pfamt) {
        this.pfamt = pfamt;
    }

    public double getPint() {
        return pint;
    }

    public void setPint(double pint) {
        this.pint = pint;
    }

    public double getPbper() {
        return pbper;
    }

    public void setPbper(double pbper) {
        this.pbper = pbper;
    }

    public double getPrat() {
        return prat;
    }

    public void setPrat(double prat) {
        this.prat = prat;
    }

    @Override
    public String toString() {
        return getPname();
    }
}
