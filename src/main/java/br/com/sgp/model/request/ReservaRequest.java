package br.com.sgp.model.request;

import java.io.Serializable;
import java.sql.Date;

public class ReservaRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int reserveId;
	private Date expiresAt;
	private String reservedBy;
	private String img;
	private double price;
	
	public ReservaRequest() {
		
		this.name = "";
		this.reserveId = 0;
		this.expiresAt = new Date(0);
		this.reservedBy = "";
		this.img = "";
		this.price = 0;
	}

	public ReservaRequest(String name, int reserveId, Date expiresAt, String reservedBy, String img, double price) {
		
		this.name = name;
		this.reserveId = reserveId;
		this.expiresAt = expiresAt;
		this.reservedBy = reservedBy;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getReservedBy() {
		return reservedBy;
	}

	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
}
