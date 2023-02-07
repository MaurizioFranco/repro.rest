package maurizio.franco.demo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Roles;
import maurizio.franco.demo.bean.User;
import proxima.informatica.academy.seventh.service.RoleService;

/**
 * Root resource (exposed at "user" path)
 * 
 * @author maurizio.franco@ymail.com
 */
@Path("roles")
public class RoleResource {

	private static Logger logger = LoggerFactory.getLogger(RoleResource.class);	

	/**
	 * Method handling HTTP GET request for retrieve bean list. The returned object
	 * will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/user
	 *
	 * @return List<User>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntityInterface> getItems() {
		logger.info("getItems - START");
		
		List<EntityInterface> items = RoleService.getInstance().getAllRoles();
		
		return items;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public EntityInterface getItemById(@PathParam("id") Long id) {
		logger.info("getItem - START - id: " + id);
        EntityInterface item= RoleService.getInstance().selectById(id);
		
		return item;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Roles insert(Roles item) {
		logger.info("insert - START - object to insert: " + item);
		Roles insertedItem = RoleService.getInstance().insert(item);
		logger.info("insert - END - insertedItem: " + insertedItem);
		return insertedItem ;
	}

	
}
