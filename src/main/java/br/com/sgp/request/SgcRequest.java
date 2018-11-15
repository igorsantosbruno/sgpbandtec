package br.com.sgp.request;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import com.google.gson.Gson;

import br.com.sgp.model.request.ConteudoRequest;

public class SgcRequest {
	
	private final String HOST = "https://sgcbandtec.herokuapp.com/sgc";
	private final String POST_CONTEUDO = "/post_conteudo";
	
	public void postSgcConteudo(int tipoConteudo) {
		
		Gson gson = new Gson();
		StringEntity params = null;
		try {
			params = new StringEntity(gson.toJson(new ConteudoRequest(tipoConteudo)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebServiceRequest webServiceRequest = new WebServiceRequest();
		webServiceRequest.requestPost(HOST + POST_CONTEUDO, params);
	}

}
