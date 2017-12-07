package bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity 
@Table(name = "Article") 
public class Article implements Serializable {
	
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 

	@Id 
	@Column(name = "id", nullable = false, insertable = false, updatable = false) 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id; 

	@Column(name = "nom")
	private String nom; 

	@Column(name = "prix")
	private Double prix; 
	
	@Column(name = "nb_Sold")
	private Integer nb_Sold;
	
	@Column(name = "stock")
	private Integer stock;
	
	public Article(){
		
	}
	
	public Article(Integer id){
		this.id = id;
	}
	
	public Article(Integer id, String name){
		this.id = id;
		this.nom = name;
	}

	
	public Article(Integer id, String name, Double prix){
		this.id = id;
		this.nom = name;
		this.prix = prix;
	}
	
	public Article(Integer id, String name, Double prix, Integer nb){
		this.id = id;
		this.nom = name;
		this.prix = prix;
		this.nb_Sold = nb;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getNb_Sold() {
		return nb_Sold;
	}

	public void setNb_Sold(Integer nb_Sold) {
		this.nb_Sold = nb_Sold;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
