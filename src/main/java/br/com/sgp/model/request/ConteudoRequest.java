package br.com.sgp.model.request;

import java.io.Serializable;

public class ConteudoRequest implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int tipoConteudo;
	
	public ConteudoRequest() {
		
		this.tipoConteudo = 0;
	}
	
	public ConteudoRequest(int tipoConteudo) {
		
		this.tipoConteudo = tipoConteudo;
	}

	public int getTipoConteudo() {
		return tipoConteudo;
	}

	public void setTipoConteudo(int tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

}
