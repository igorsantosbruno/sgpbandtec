package br.com.sgp.util;

import br.com.sgp.query.model.ProdutoQuery;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;

public class ProdutoUtil {

    public String converterBase64(MultipartFile imagem) {

        String strImg = "";

        try {
            strImg = Base64.encodeBase64String(imagem.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strImg;

    }

    public String construirQueryBuscarPorTipo(String[] tipos) {

        ProdutoQuery produtoQuery = new ProdutoQuery();

        String query = produtoQuery.getBuscarPorTipo();

        query += "'" + tipos[0] + "'";

        for (int i = 1; i < tipos.length; i++) {

            query += " OR B.descricao =" + "'" + tipos[i] + "'" ;
        }

        System.out.println(query);

        return query;
    }

}
