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
    
    public ReservaProduto() {
    	
    	this.id = 0;
    	this.reservedDate = new Date(0);
    	this.limitDate = new Date(0);
    	this.reservedStatus = 0;
    	this.productId = 0;
    	this.userId = 0;
    	this.quantity = 0;
    }

    public ReservaProduto(Date reservedDate, Date limitDate, int reservedStatus, long productId, long userId, int quantity) {
    	
        this.reservedDate = reservedDate;
        this.limitDate = limitDate;
        this.reservedStatus = reservedStatus;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
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
}
