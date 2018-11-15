package br.com.sgp.util;

import org.springframework.web.multipart.MultipartFile;

import br.com.sgp.model.query.ProdutoQuery;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.util.Date;
import java.util.Stack;
import java.util.Calendar;

public class ProdutoUtil {

    public String converterBase64(MultipartFile imagem) {

        String strImg = "";

        try {
            strImg = Base64.encodeBase64String(imagem.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "data:image/" + getExtensaoSemPontoImagem(imagem.getOriginalFilename()) + ";base64," + strImg;

    }
    
	public String getExtensaoSemPontoImagem(String imagem) {

		String extensao = "";
		int tamanhoExtensao = 0;
		Stack<String> pilhaExtensao = new Stack<>();
		for (int i = imagem.length() - 1; i >= 0; i--) {

			String caracter = "" + imagem.charAt(i);
			if (!caracter.equals(".")) {

				pilhaExtensao.push(caracter);
				tamanhoExtensao++;
			} else {

				break;
			}
		}
		for (int i = 0; i < tamanhoExtensao; i++) {

			extensao += pilhaExtensao.pop();
		}
		return extensao;
	}

    public String construirQueryBuscarPorTipo(String[] tipos) {

        ProdutoQuery produtoQuery = new ProdutoQuery();

        String query = produtoQuery.getBuscarPorTipo();

        query += "'" + tipos[0] + "'";

        for (int i = 1; i < tipos.length; i++) {

            query += " OR B.descricao =" + "'" + tipos[i] + "'" ;
        }

        return query;
    }
    
    public Date ajustarDataReservaProduto(Date dataLimite, int quantidadeDia) {
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(dataLimite);
    	calendar.add( Calendar.DAY_OF_MONTH , quantidadeDia );
    	dataLimite = calendar.getTime();
    	return dataLimite;
    }
}





