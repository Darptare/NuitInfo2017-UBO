package jSonGestion;

import java.util.List;

import bean.Article;

public abstract class JSonGenerator {

	public static String listProduitToJSon(List<Article> articles){

		int i = 0;
		String generatedJSon = "{\"listProduits\":[\n";
		for (Article produit : articles) {
			generatedJSon += produitToJSon(produit);

			if(i != articles.size()-1){
				generatedJSon += ",\n";
			}else{
				generatedJSon += "\n";
			}
			i++;
		}
		generatedJSon += "]}";
		return generatedJSon;
	}
	
	public static String produitToJSon(Article articles){
		
		return "\n{\"id\":\""+articles.getId()+"\",\"titre\":\""+articles.getTitre()+"\",\"chapeau\":\""+articles.getChapeau()+"\",\"chemin\":\""+articles.getCheminAccess()+"\"}";
	}
}
