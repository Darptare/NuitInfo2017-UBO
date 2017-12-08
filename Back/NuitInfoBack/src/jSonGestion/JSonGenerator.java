package jSonGestion;

import java.util.List;

import bean.article;
import bean.Question;
import bean.t_compte_cmp;

public abstract class JSonGenerator {

	public static String listArticleToJSon(List<article> articles){

		int i = 0;
		String generatedJSon = "{\"listArticles\":[\n";
		for (article art : articles) {
			generatedJSon += articleToJSon(art);

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
	
	public static String articleToJSon(article articles){
		
		return "\n{\"id\":\""+articles.getId()+"\",\"titre\":\""+articles.getTitre()+"\",\"chapeau\":\""+articles.getChapeau()+"\"}";
	}

	public static String listQuestionToJSon(List<Question> questions){

		int i = 0;
		String generatedJSon = "{\"listQuestions\":[\n";
		for (Question quest : questions) {
			generatedJSon += questionToJSon(quest);

			if(i != questions.size()-1){
				generatedJSon += ",\n";
			}else{
				generatedJSon += "\n";
			}
			i++;
		}
		generatedJSon += "]}";
		return generatedJSon;
	}
	
	public static String questionToJSon(Question question){
		
		return "\n{\"id\":\""+question.getId()+"\",\"img\":\""+question.getImg()+"\",\"prop1\":\""+question.getQuestion()+"\",\"prop1\":\""+question.getProp1()+"\",\"prop2\":\""+question.getProp2()+"\",\"prop3\":\""+question.getProp3()+"\",\"reponse\":\""+question.getReponse()+"\"}";
	}


	public static String listUsersToJSon(List<t_compte_cmp> users){
	
		int i = 0;
		String generatedJSon = "{\"listQuestions\":[\n";
		for (t_compte_cmp user : users) {
			generatedJSon += userToJSon(user);
	
			if(i != users.size()-1){
				generatedJSon += ",\n";
			}else{
				generatedJSon += "\n";
			}
			i++;
		}
		generatedJSon += "]}";
		return generatedJSon;
	}
	
	public static String userToJSon(t_compte_cmp user){
		
		return "\n{\"id\":\""+user.getCmp_name()+"\"}";
	}
}
