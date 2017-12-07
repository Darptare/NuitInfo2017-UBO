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

	@Column(name = "titre")
	private String titre; 

	@Column(name = "chapeau")
	private String chapeau; 
	
	@Column(name = "cheminAcces")
	private String cheminAcces;
	
	public Article(){
		
	}
	
	public Article(Integer id){
		this.id = id;
	}
	
	public Article(Integer id, String titre){
		this.id = id;
		this.titre = titre;
	}

	
	public Article(Integer id, String titre, String chapeau){
		this.id = id;
		this.titre = titre;
		this.chapeau = chapeau;
	}
	
	public Article(Integer id, String titre, String chapeau, String cheminAcces){
		this.id = id;
		this.titre = titre;
		this.chapeau = chapeau;
		this.cheminAcces = cheminAcces;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getChapeau() {
		return chapeau;
	}

	public void setChapeau(String chapeau) {
		this.chapeau = chapeau;
	}

	public String getCheminAccess() {
		return cheminAcces;
	}

	public void setCheminAccess(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
