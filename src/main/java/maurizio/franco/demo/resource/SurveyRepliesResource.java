package maurizio.franco.demo.resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.entity.SurveysReplies;
import maurizio.franco.demo.bean.User;
import proxima.informatica.academy.seventh.service.RoleService;
import proxima.informatica.academy.seventh.service.SurveyRepliesService;

/**
 * 
 * @author Giammarco Lucchetti
 *
 */
@Path("surveyreplies")
public class SurveyRepliesResource {

	private static Logger logger = LoggerFactory.getLogger(SurveyRepliesResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntityInterface> getItems() {
		logger.info("getSurveyReplies - START");
		List<EntityInterface> items = SurveyRepliesService.getInstance().getAllSurveyReplies();
		return items;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public EntityInterface getItemById(@PathParam("id") long id) {
		logger.info("getSurveyRepliesById - START - id: " + id);
		EntityInterface item = SurveyRepliesService.getInstance().selectSurveyrepliesById(id);
		return item;
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EntityInterface insertSurveyReplies(SurveysReplies item) {
		logger.info("insertSurveyReplies - START - object to insert: " + item);
		SurveysReplies insertedItem = SurveyRepliesService.getInstance().insert(item);
		logger.info("insertSurveyReplies - END - object to insert: " + item);
		return insertedItem ;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EntityInterface updateSurveyReplies(SurveysReplies surveyReplies) {
		logger.info("updateSurveyReplies - START - object to update: " + surveyReplies);
		SurveyRepliesService.getInstance().updateSurveyReplies(surveyReplies);
		return surveyReplies ;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/")
	public boolean deleteSurveyReplies(@PathParam("id") Long id) {
		logger.info("deleteSurveyReplies - START - id user to remove: " + id);
		boolean result = SurveyRepliesService.getInstance().deleteSurveyRepliesById(id);
		return result;
	}

}
