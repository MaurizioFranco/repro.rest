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

import centauri.academy.proxima.cerepro.entity.CandidateStates;
import proxima.informatica.academy.seventh.service.CandidateStatesService;


/**
 * Root resource (exposed at "CandidateStates" path)
 */

/*
 * @author MarcoFabretti
 * 
 */
@Path("candidateState")
public class CandidateStatesResource {

	private static Logger logger = LoggerFactory.getLogger(CandidateStatesResource.class);

	/**
	 * Method handling HTTP GET request for retrieve bean by id field. The returned
	 * object will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/CandidateStates/20
	 *
	 * @return CandidateStates object as json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public CandidateStates getObjectById(@PathParam("id") Long id) {
		logger.info("getObjectById - START - id: " + id);
		CandidateStates testCandidateStates = new CandidateStates((long)10,(long)1, 4, "rgsgsr","rsgr","#ffffff");
		return testCandidateStates;
	}
	/**
	 * Method handling HTTP GET request for retrieve bean list. The returned object
	 * will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/CandidateStates
	 *
	 * @return List<CandidateStates>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidateStates> getCandidateStates() {
		logger.info("getCandidateStatess - START");
		//TO DO: something from the persistence layer
		List<CandidateStates> candidateStates = new ArrayList<CandidateStates>();
		for (int i = 0; i < 10; i++) {
			candidateStates.add(new CandidateStates((long) i, (long) i, i, "@a.it" , "afef" , "#ffff"));
		}
		return candidateStates;
	}

	/**
	 * 
	 * This method provides an example of what an HTTP POST method could do.
	 * In this case, provides to log the object received,
	 * sets the id(like an persistence execution) and returns the complete 
	 * object with the id enhanced from database layer. 
	 * 
	 * try from command line with(linux): curl -i -d '{"CandidateStatesname":"maurizio", "email":"m@f.it"}' -H "Content-Type: application/json" -X POST http://localhost:8080/demo/CandidateStates
	 * try from command line with(windows): curl -i -d '{"CandidateStatesname":"maurizio", "email":"m@f.it"}' -H "Content-Type: application/json" -X POST http://localhost:8080/demo/CandidateStates
	 * @param CandidateStates
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CandidateStates insertCandidateStates(CandidateStates candidateStates) {
		logger.info("insertCandidateStates - START - object to insert: " + candidateStates);
		Boolean result = CandidateStatesService.getInstance().insert(candidateStates);
		logger.info("insertCandidateStates - End - insert result: " + result);
		return null;
	}

	/**
	 * 
	 * This method provides an example of what an HTTP PUT method could do.
	 * In this case, provides to log the object received,
	 * and returns the complete 
	 * object.
	 * It needs to do something on the database!!! 
	 * 
	 * try from command line with: curl -d '{"id":10, "CandidateStatesname":"maurizio", "email":"m@f.it"}' -H "Content-Type: application/json" -X PUT http://localhost:8080/demo/CandidateStates
	 * 
	 * @param CandidateStates
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CandidateStates updateCandidateStates(CandidateStates candidateStates) {
		logger.info("updateCandidateStates - START - object to update: " + candidateStates);
		Boolean result = CandidateStatesService.getInstance().update(candidateStates);
		logger.info("insertCandidateStates - End - update result: " + result);
		
		return candidateStates;
	}
	
	/**
	 * Provides to delete the object.
	 * It should go on the persistence layer and remove the object by id received.
	 * 
	 * try from command line with: curl -X DELETE http://localhost:8080/demo/CandidateStates/10
	 * 
	 * @param id, long id of the object to delete
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/")
	public boolean deleteCandidateStates(@PathParam("id") Long id) {
		logger.info("deleteCandidateStates - START - id candidateStates to remove: " + id);
		Boolean result = CandidateStatesService.getInstance().deleteById(id);
		logger.info("insertCandidateStates - End - delete result: " + result);
		return result;
	}
}