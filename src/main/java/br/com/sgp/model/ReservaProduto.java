package br.com.sgp.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Table(name = "reserva_produto")
@Entity(name = "ReservaProduto")
public class ReservaProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "data_reserva")
    private Date reservedDate;

    @Column(name = "data_limite")
    private Date limitDate;

    @Column(name = "status_reserva")
    private int reservedStatus;

    @Column(name = "id_produto")
    private long productId;

    @Column(name = "id_usuario")
    private long userId;

    @Column(name = "quantidade")
    private int quantity;

    @Column(name = "quantidade_p")
    private int p;

    @Column(name = "quantidade_m")
    private int m;

    @Column(name = "quantidade_g")
    private int g;

    @Column(name = "quantidade_gg")
    private int gg;

    @Column(name = "quantidade_unico")
    private int isUnique;
    
    @Column(name = "preco_total")
    private double totalPrice;


    public ReservaProduto() {
    	
    	this.id = 0;
    	this.reservedDate = new Date(0);
    	this.limitDate = new Date(0);
    	this.reservedStatus = 0;
    	this.productId = 0;
    	this.userId = 0;
    	this.quantity = 0;
        this.p = 0;
        this.m = 0;
        this.g = 0;
        this.gg = 0;
        this.isUnique = 0;
        this.totalPrice = 0;
    }

    public ReservaProduto(Date reservedDate, Date limitDate, int reservedStatus,
                          long productId, long userId, int quantity, int p, int m, int g, int gg, int isUnique, double totalPrice) {
    	
        this.limitDate = limitDate;
        this.reservedDate = reservedDate;
        this.reservedStatus = reservedStatus;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.p = p;
        this.m = m;
        this.g = g;
        this.gg = gg;
        this.isUnique = isUnique;
        this.totalPrice = totalPrice;
    }

    public long getId() {
    	
        return this.id;
    }

    public void setId(long id) {
    	
        this.id = id;
    }

    public Date getReservedDate() {
    	
        return this.reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
    	
        this.reservedDate = reservedDate;
    }

    public Date getLimitDate() {
    	
        return this.limitDate;
    }

    public void setLimitDate(Date limitDate) {
    	
        this.limitDate = limitDate;
    }

    public int getReservedStatus() {
    	
        return this.reservedStatus;
    }

    public void setReservedStatus(int reservedStatus) {
    	
        this.reservedStatus = reservedStatus;
    }

    public long getProductId() {
    	
        return this.productId;
    }

    public void setProductId(long productId) {
    	
        this.productId = productId;
    }

    public long getUserId() {
    	
        return this.userId;
    }

    public void setUserId(long userId) {
    	
        this.userId = userId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
    	
        this.quantity = quantity;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getGg() {
        return gg;
    }

    public void setGg(int gg) {
        this.gg = gg;
    }

    public int getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(int isUnique) {
        this.isUnique = isUnique;
    }

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
