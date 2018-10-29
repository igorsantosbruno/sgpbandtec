package br.com.sgp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "produto")
@Entity(name = "Produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
	
	@Column(name = "quantidade")
	private int quantity;
	
	@Column(name = "valor")
	private double price;
	
	@Column(name = "titulo")
	private String title;
	
	@Column(name = "background")
	private String background;
	
	@Column(name = "descricao")
	private String description;
	
	@Column(name = "id_tipo")
	private int idTipo;
	
	@Column(name = "id_tamanho")
	private int idTamanho;

	public Produto() {
		
		this.id = 0;
		this.quantity = 0;
		this.price = 0;
		this.title = "";
		this.background = "";
		this.description = "";
		this.idTipo = 0;
		this.idTamanho = 0;
	}

	public Produto(long id, int quantity, double price, String title, String background, String description, int idTipo,
			int idTamanho) {
		
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		this.background = background;
		this.description = description;
		this.idTipo = idTipo;
		this.idTamanho = idTamanho;
	}

	public long getId() {
		
		return this.id;
	}

	public void setId(long id) {
		
		this.id = id;
	}

	public int getQuantity() {
		
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}

	public double getPrice() {
		
		return this.price;
	}

	public void setPrice(double price) {
		
		this.price = price;
	}

	public String getTitle() {
		
		return this.title;
	}

	public void setTitle(String title) {
		
		this.title = title;
	}

	public String getBackground() {
		
		return this.background;
	}

	public void setBackground(String background) {
		
		this.background = background;
	}

	public String getDescription() {
		
		return this.description;
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public int getIdTipo() {
		
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		
		this.idTipo = idTipo;
	}

	public int getIdTamanho() {
		
		return this.idTamanho;
	}

	public void setIdTamanho(int idTamanho) {
		
		this.idTamanho = idTamanho;
	}	
}











