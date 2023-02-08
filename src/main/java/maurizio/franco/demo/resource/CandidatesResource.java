package maurizio.franco.demo.resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import centauri.academy.proxima.cerepro.entity.Candidates;
import centauri.academy.proxima.cerepro.entity.Candidates;
import proxima.informatica.academy.seventh.service.CandidatesService;
import proxima.informatica.academy.seventh.service.RoleService;
import proxima.informatica.academy.seventh.service.CandidatesService;


/**
 * 
 * @author AntoIannaccone
 *
 */
@Path("candidates")
public class CandidatesResource {

	private static Logger logger = LoggerFactory.getLogger(CandidatesResource.class);

	

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
		logger.info("getCandidates - START");
		List<EntityInterface> Candidates = CandidatesService.getInstance().getAllCandidates();
		logger.info("getCandidates - END");
		return Candidates;
	}
	
	@GET
	@Path("{id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Candidates getItem(@PathParam("id")long id) {
		logger.info("getCandidate - START");
		logger.info("getCandidate - ID" + id);
		Candidates candidate = CandidatesService.getInstance().selectById(id);
		logger.info("getCandidate - END");
		return candidate;
	}
	
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Candidates insertItem(Candidates itemToInsert) {
//		boolean bool = CandidatesService.getInstance().insertCandidates(itemToInsert);
//		if(bool)
//			return itemToInsert;
//		return null;
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Candidates insert(Candidates item) {
		logger.info("insert - START - object to insert: " + item);
		item.setCandidacy_date_time(Timestamp.valueOf(LocalDateTime.now()));
		Candidates insertedItem = CandidatesService.getInstance().insert(item);
		logger.info("insert - END - insertedItem: " + insertedItem);
		return insertedItem ;
	}
	
	
//	@PUT
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Candidates updateItem(Candidates itemToUpdate) {
//		boolean bool = CandidatesService.getInstance().updateCandidates(itemToUpdate);
//		if(bool)
//			return itemToUpdate;
//		return null;
//	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Candidates updateItem(Candidates candidates) {
		logger.info("CandidatesResource - updateItem - START - object to update: " + candidates);
		candidates.setCandidacy_date_time(Timestamp.valueOf(LocalDateTime.now()));
		CandidatesService.getInstance().update(candidates);
		return candidates ;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public boolean delete(@PathParam("id") Long id) {
		logger.info("delete - START - object id to delete: " + id);
		boolean responseValue = CandidatesService.getInstance().deleteById(id);
		logger.info("delete - END - responseValue: " + responseValue);
		return responseValue ;
	}
}