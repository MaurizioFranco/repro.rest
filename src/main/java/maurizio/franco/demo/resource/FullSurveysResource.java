package maurizio.franco.demo.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.FullSurveys;
import proxima.informatica.academy.seventh.service.FullSurveysService;
/**
 * 
 * @author Giacomo Della Luna
 *
 */
@Path("fullSurveysResource")
public class FullSurveysResource {

	private static Logger logger = LoggerFactory.getLogger(FullSurveysResource.class);	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public FullSurveys getItemById(@PathParam("id") Long id) {
		logger.info("getItem - START - id: " + id);
		FullSurveys fullSurveys = FullSurveysService.getInstance().selectFullSurveysBySurveysId(id);

		return fullSurveys;
	}
}
