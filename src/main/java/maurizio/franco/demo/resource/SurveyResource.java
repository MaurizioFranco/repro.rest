package maurizio.franco.demo.resource;


import java.util.ArrayList;
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
import centauri.academy.proxima.cerepro.entity.Surveys;
import proxima.informatica.academy.seventh.service.SurveyService;

/**
 * 
 * @author matteo.peruzza@gmail.com
 *
 */

@Path("survey")
public class SurveyResource {
	
	private static Logger logger = LoggerFactory.getLogger(SurveyResource.class);
	
	/**
	 * Method handling HTTP GET request for retrieve bean by id field. The returned
	 * object will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/survey/...
	 *
	 * @return User object as json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Surveys getObjectById(@PathParam("id") Long id) {
		logger.info("getObjectById - START - id: " + id);
		Surveys survey = SurveyService.getInstance().selectById(id);
		logger.info("getObjectById - END");
		return survey;
	}
	
	/**
	 * Method handling HTTP GET request for retrieve bean list. The returned object
	 * will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/survey
	 *
	 * @return List<Surveys>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Surveys> getSurveys() {
		logger.info("getSurveys - START");
		List<EntityInterface> items = SurveyService.getInstance().getAllSurveys();
		List<Surveys> surveys = new ArrayList<Surveys>();
		for (int i = 0; i < items.size(); i++) {
			surveys.add((Surveys)items.get(i));
		}
		logger.info("getSurveys - END" + surveys.size());
		return surveys;
	}

	/**
	 * Method handling HTTP GET request for insert bean. The returned object
	 * will be sent to the client as json.
	 *
	 *  try from command line with(windows): POST http://localhost:8080/demo/survey?{"label":"...", "time":"...", "description":"..."}
	 *
	 * @return Surveys
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Surveys insertSurvey(Surveys survey) {
		logger.info("insertSurvey - START - object to insert: " + survey);
		SurveyService.getInstance().insert(survey);
		logger.info("insertSurvey - END");
		return survey;
	}
	
	/**
	 * Method handling HTTP GET request for updating bean. The returned object
	 * will be sent to the client as json.
	 *
	 * try from command line with: PUT http://localhost:8080/demo/survey?{"id":"...", "label":"...", "time":"...", "description":"..."}
	 *
	 * @return Surveys
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Surveys updateSurvey(Surveys survey) {
		logger.info("updateSurvey - START - object to update: " + survey);
		Surveys updatedSurvey = null;
		if (SurveyService.getInstance().updateSurvey(survey)) {
			updatedSurvey = SurveyService.getInstance().selectById(survey.getId());
		}
		logger.info("updateSurvey - END");
		return updatedSurvey;
	}
	
	/**
	 * Provides to delete the object.
	 * It should go on the persistence layer and remove the object by id received.
	 * 
	 * try from command line with: DELETE http://localhost:8080/demo/survey/...
	 * 
	 * @param id, long id of the object to delete
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/")
	public Surveys deleteUser(@PathParam("id") Long id) {
		logger.info("deleteSurvey - START - id survey to remove: " + id);
		Surveys survey = SurveyService.getInstance().selectById(id);
		SurveyService.getInstance().deleteById(id);
		logger.info("deleteSurvey - END");
		return survey;		
	}
	
}
