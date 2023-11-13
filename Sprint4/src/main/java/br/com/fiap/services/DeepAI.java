package br.com.fiap.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Comparador de imagem, ele devolve um Json no qual indica em números o quanto a imagem 1 é parecida com a imagem 2, quanto mais próximo o valor for de 0, significa que as imagens tem maior similaridade.

public class DeepAI {
	 public static void main(String[] args) {
	        try {
	            String apiKey = "b7d605e0-4010-4ae7-831c-7de5eb0eae74"; 
	            String imageUrl1 = "";
	            String imageUrl2 = "";
	            
	            String apiUrl = "https://api.deepai.org/image-similarity";

	            URL url = new URL(apiUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("api-key", apiKey);
	            conn.setDoOutput(true);

	            String postData = "image1=" + imageUrl1 + "&image2=" + imageUrl2;

	            conn.getOutputStream().write(postData.getBytes("UTF-8"));

	            int responseCode = conn.getResponseCode();

	            if (responseCode == 200) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }

	                in.close();

	               
	                System.out.println("Resultado da comparação: " + response.toString());
	            } else {
	                System.out.println("Erro na solicitação HTTP. Código de resposta: " + responseCode);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
