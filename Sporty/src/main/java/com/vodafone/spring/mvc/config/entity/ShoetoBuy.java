package com.vodafone.spring.mvc.config.entity;

public class ShoetoBuy {
	
	private String sid;
	private String nshoes;

	public ShoetoBuy() {
		// TODO Auto-generated constructor stub
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNshoes() {
		return nshoes;
	}

	public void setNshoes(String nshoes) {
		this.nshoes = nshoes;
	}

	@Override
	public String toString() {
		return "ShoetoBuy [sid=" + sid + ", nshoes=" + nshoes + "]";
	}

	
	
	
	
}
