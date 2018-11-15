package br.com.sgp.model.request;

import java.io.Serializable;
import java.sql.Date;

public class ReservaUsuarioRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private long reserveId;
	private double price;
	private Date expiresAt;
	private String img;
	
	public ReservaUsuarioRequest() {
		
		this.name = "";
		this.reserveId = 0;
		this.price = 0;
		this.expiresAt = new Date(0);
		this.img = "";
	}

	public ReservaUsuarioRequest(String name, long reserveId, double price, Date expiresAt, String img) {
	
		this.name = name;
		this.reserveId = reserveId;
		this.price = price;
		this.expiresAt = expiresAt;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getReserveId() {
		return reserveId;
	}

	public void setReserveId(long reserveId) {
		this.reserveId = reserveId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
