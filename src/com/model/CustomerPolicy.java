package com.model;

public class CustomerPolicy {
	private long id;
	private long cupid;
	private long cid;
	private long pid;
	private long aid;
	private String nom;
	private String rela;
	private long pamt;
	private PolicyType ptype;

	public PolicyType getPtype() {
		return ptype;
	}

	public void setPtype(PolicyType ptype) {
		this.ptype = ptype;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCupid() {
		return cupid;
	}

	public void setCupid(long cupid) {
		this.cupid = cupid;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

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

	public long getPamt() {
		return pamt;
	}

	public void setPamt(long pamt) {
		this.pamt = pamt;
	}
}
