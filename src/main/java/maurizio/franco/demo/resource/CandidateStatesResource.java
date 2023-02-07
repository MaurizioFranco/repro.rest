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
import centauri.academy.proxima.cerepro.entity.CandidateStates;
import proxima.informatica.academy.seventh.service.CandidateStatesService;


/**
 * 
 * @author AntoIannaccone
 *
 */
@Path("CandidateStates")
public class CandidateStatesResource {

	private static Logger logger = LoggerFactory.getLogger(CandidateStatesResource.class);

	

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
		logger.info("getCandidateStates - START");
		List<EntityInterface> CandidateStates = CandidateStatesService.getInstance().selectAll();
		logger.info("getCandidateStates - END");
		return CandidateStates;
	}
	
	@GET
	@Path("{id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public CandidateStates getItem(@PathParam("id")long id) {
		logger.info("getCandidate - START");
		logger.info("getCandidate - ID" + id);
		CandidateStates candidate = CandidateStatesService.getInstance().selectById(id);
		logger.info("getCandidate - END");
		return candidate;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CandidateStates insertItem(CandidateStates itemToInsert) {
		boolean bool = CandidateStatesService.getInstance().insert(itemToInsert);
		if(bool)
			return itemToInsert;
		return null;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CandidateStates updateItem(CandidateStates itemToUpdate) {
		boolean bool = CandidateStatesService.getInstance().update(itemToUpdate);
		if(bool)
			return itemToUpdate;
		return null;
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/")
	public boolean deleteItem(@PathParam("id") Long id) {
		logger.info("deleteUser - START - id user to remove: " + id);
		boolean bool = CandidateStatesService.getInstance().deleteById(id);
		return bool;
	}
}