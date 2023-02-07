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
import centauri.academy.proxima.cerepro.entity.Questions;
import proxima.informatica.academy.seventh.service.QuestionsService;


/**
 * @author DaimCod - daim.kazmi00@gmail.com
 * Root resource (exposed at "user" path)
 */
@Path("question")
public class QuestionResource {

	private static Logger logger = LoggerFactory.getLogger(QuestionResource.class);

	

	/**
	 * Method handling HTTP GET request for retrieve bean list. The returned object
	 * will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/user
	 *
	 * @return List<EntityInterface>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntityInterface> getItems() {
		logger.info("getUsers - START");
		List<EntityInterface> Questions = QuestionsService.getIstance().selectAll();
		logger.info("getQuestions - END");
		return Questions;
	}
	
	@GET
	@Path("{id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Questions getItem(@PathParam("id")long id) {
		logger.info("getRole - START");
		logger.info("getRole - ID" + id);
		Questions role = QuestionsService.getIstance().selectById(id);
		logger.info("getRole - END");
		return role;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Questions insertItem(Questions itemToInsert) {
		logger.info("insert - START - object to insert: " + itemToInsert);
		Questions question = QuestionsService.getIstance().insert(itemToInsert);
		logger.info("insert - END: " + question);
		return question;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Questions updateItem(Questions itemToUpdate) {
		Questions r = null;
		r = QuestionsService.getIstance().updateQuestion(itemToUpdate);
		return r;
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public boolean deleteItem(@PathParam("id") Long id) {
		logger.info("deleteUser - START - id user to remove: " + id);
		boolean r = QuestionsService.getIstance().deleteById(id);
		return r;
	}
}
