package dao; 

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Article;
import bean.Question;

public class DAO { 

	EntityManagerFactory emf = null; 
	EntityManager em = null; 

	public void ouvrir() { 
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		try { 
			emf = Persistence.createEntityManagerFactory("nuitInfo2017"); 
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
	
	

	public void enregistrerArticle(Article art) { 
		em.persist(art); 

	} 

	@SuppressWarnings("unchecked")
	public List<Article> listerArticles() { 
		List<Article> lst = em.createQuery("select a from Article a").getResultList(); 
		return lst; 
	}

	@SuppressWarnings("unchecked")
	public Article getArticle(String id){
		List<Article> art = em.createQuery("select a from Article a where id="+id).getResultList();
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

}
