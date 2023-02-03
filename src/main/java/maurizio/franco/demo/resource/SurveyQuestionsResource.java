package maurizio.franco.demo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;
import proxima.informatica.academy.seventh.service.SurveyquestionsService;

/**
 * 
 * @author Giacomo Della Luna
 *
 */
@Path("surveyQuestions")
public class SurveyQuestionsResource {

	private static Logger logger = LoggerFactory.getLogger(SurveyQuestionsResource.class);

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntityInterface> getItems() {
		logger.info("SurveyQuestionsResource - getItems - START");
		List<EntityInterface> listEntity = SurveyquestionsService.getInstance().getAllSurveyquestions();
		return listEntity;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public SurveysQuestions getItem(@PathParam("id") int id) {
		logger.info("SurveyQuestionsResource - getItem - START - id: " + id);
		SurveysQuestions surveyQuestions = SurveyquestionsService.getInstance().selectById(id);
		return surveyQuestions;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SurveysQuestions insertItem(SurveysQuestions surveyQuestions) {
		logger.info("SurveyQuestionsResource - insertItem - START - object to insert: " + surveyQuestions);
		SurveyquestionsService.getInstance().insert(surveyQuestions);
		return surveyQuestions ;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SurveysQuestions updateItem(SurveysQuestions surveyQuestions) {
		logger.info("SurveyQuestionsResource - updateItem - START - object to update: " + surveyQuestions);
		SurveyquestionsService.getInstance().updateSurveyquestions(surveyQuestions);
		return surveyQuestions ;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/")
	public boolean deleteItem(@PathParam("id") int id) {
		logger.info("SurveyQuestionsResource - deleteItem - START - id user to remove: " + id);
		SurveyquestionsService.getInstance().deleteById(id);
		return true;
	}
}
