package jSonGestion;

import java.util.List;

import bean.Article;

public abstract class JSonGenerator {

	public static String listProduitToJSon(List<Article> produits){

		int i = 0;
		String generatedJSon = "{\"listProduits\":[\n";
		for (Article produit : produits) {
			generatedJSon += produitToJSon(produit);

			if(i != produits.size()-1){
				generatedJSon += ",\n";
			}else{
				generatedJSon += "\n";
			}
			i++;
		}
		generatedJSon += "]}";
		return generatedJSon;
	}
	
	public static String produitToJSon(Article produit){
		
		return "\n{\"id\":\""+produit.getId()+"\",\"nbSold\":\""+produit.getNb_Sold()+"\",\"stock\":\""+produit.getStock()+"\",\"prix\":\""+produit.getPrix()+"\"}";
	}
}
