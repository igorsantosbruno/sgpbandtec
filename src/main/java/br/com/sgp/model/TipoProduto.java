package br.com.sgp.model;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "tipo_produto")
@Entity(name = "TipoProduto")
public class TipoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "descricao")
    private String description;
    
    public TipoProduto() {
    	
    	this.id = 0;
    	this.description = "";
    }

    public TipoProduto(String description) {
    	
        this.description = description;
    }

    public long getId() {
    	
        return this.id;
    }

    public void setId(long id) {
    	
        this.id = id;
    }

    public String getDescription() {
    	
        return this.description;
    }

    public void setDescription(String description) {
    	
        this.description = description;
    }
}
