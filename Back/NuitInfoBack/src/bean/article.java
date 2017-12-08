package bean;

public class article{
	private Integer id; 

	private String titre; 

	private String chapeau; 
	
	private String cheminAcces;
	
	public article(){
		
	}
	
	public article(Integer id){
		this.id = id;
	}
	
	public article(Integer id, String titre){
		this.id = id;
		this.titre = titre;
	}

	
	public article(Integer id, String titre, String chapeau){
		this.id = id;
		this.titre = titre;
		this.chapeau = chapeau;
	}
	
	public article(Integer id, String titre, String chapeau, String cheminAcces){
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

}
