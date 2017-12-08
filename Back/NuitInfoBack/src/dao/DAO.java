package dao; 

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.article;
import bean.Question;
import bean.t_compte_cmp;

public class DAO { 

	EntityManagerFactory emf = null; 
	EntityManager em = null; 

	public void ouvrir() { 
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		try { 
			emf = Persistence.createEntityManagerFactory("PressToPlay"); 
			em = emf.createEntityManager();     
		} 
		catch (Exception e) { 
			System.out.println("Erreur DAO.ouvrir "+e.getMessage()); 
		} 

	} 

	public void fermer() { 
		try { 
			em.close(); 
			emf.close(); 
		} 
		catch (Exception e) { 
			System.out.println("Erreur DAO.fermer "+e.getMessage()); 
		} 
	} 
	
	

	public void enregistrerArticle(article art) { 
		em.persist(art); 

	} 

	@SuppressWarnings("unchecked")
	public List<article> listerArticles() { 
		System.out.println("entrée 'listerArticles'");
		List<article> lst = em.createQuery("select p from article p").getResultList(); 
		System.out.println("sortie 'listerArticles'");
		return lst; 
	}

	@SuppressWarnings("unchecked")
	public article getArticle(String id){
		List<article> art = em.createQuery("select a from Article a where id="+id).getResultList();
		if(art.isEmpty())
			return null;

		return art.get(0);
	}


	@SuppressWarnings("unchecked")
	public List<Question> listerQuestions() { 
		List<Question> lst = em.createQuery("select q from Quizz q").getResultList(); 
		return lst; 
	}
	
	@SuppressWarnings("unchecked")
	public Question getQuestion(String id){
		List<Question> quest = em.createQuery("select q from quizz q where id="+id).getResultList();
		if(quest.isEmpty())
			return null;

		return quest.get(0);
	}
	
	public void enregistrerQuestion(Question q) { 
		em.persist(q); 

	} 
	

	@SuppressWarnings("unchecked")
	public List<t_compte_cmp> listerUsers() { 
		List<t_compte_cmp> lst = em.createQuery("select t from t_compte_cmp t").getResultList(); 
		return lst; 
	}
	
	@SuppressWarnings("unchecked")
	public t_compte_cmp getUser(String cmp_name, String cmp_mdp){
		List<t_compte_cmp> users = em.createQuery("select t from t_compte_cmp t where cmp_name="+cmp_name+" and cmp_name="+cmp_mdp).getResultList();
		if(users.isEmpty())
			return null;

		return users.get(0);
	}
	
	public void enregistrerUser(t_compte_cmp t) { 
		em.persist(t); 

	} 

}
