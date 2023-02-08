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
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;
import proxima.informatica.academy.seventh.service.CandidateStatesService;
import proxima.informatica.academy.seventh.service.CandidatesService;
import proxima.informatica.academy.seventh.service.SurveyquestionsService;


/**
 * Root resource (exposed at "CandidateStates" path)
 */

/*
 * @author MarcoFabretti
 * 
 */
@Path("candidatestate")
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
	public EntityInterface getObjectById(@PathParam("id") Long id) {
		logger.info("getObjectById - START - id: " + id);
		return CandidateStatesService.getInstance().selectById(id);
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
	public List<EntityInterface> getItems() {
		logger.info("getCandidateStates - START");
		List<EntityInterface> CandidateStates = CandidateStatesService.getInstance().selectAll();
		logger.info("getCandidates - END");
		return CandidateStates;
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
	public CandidateStates insert(CandidateStates candidateStates) {
		logger.info("insertCandidateStates - START - object to insert: " + candidateStates);
		CandidateStates result = CandidateStatesService.getInstance().insert(candidateStates);
		logger.info("insertCandidateStates - End - insert result: " + result);
		return result;
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
	public CandidateStates updateItem(CandidateStates candidateStates) {
		logger.info("CandidateStatesResource - updateItem - START - object to update: " + candidateStates);
		CandidateStatesService.getInstance().update(candidateStates);
		return candidateStates ;
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