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
	private int quantidade;
	
	@Column(name = "valor")
	private double valor;
	
	@Column(name = "titulo")
	private String titulo;
	
	public Produto() {
		
	}

	public Produto(long id, 
			int quantidade, 
			double valor, 
			String titulo) {

		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.titulo = titulo;
	}

	public long getId() {
		
		return this.id;
	}

	public void setId(long id) {
		
		this.id = id;
	}

	public int getQuantidade() {
		
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		
		this.quantidade = quantidade;
	}

	public double getValor() {
		
		return this.valor;
	}

	public void setValor(double valor) {
		
		this.valor = valor;
	}

	public String getTitulo() {
		
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		
		this.titulo = titulo;
	}
}











