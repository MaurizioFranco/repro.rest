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
import centauri.academy.proxima.cerepro.entity.User;
import proxima.informatica.academy.seventh.service.UserService;

/**
 * Root resource (exposed at "user" path)
 * 
 * @author maurizio.franco@ymail.com
 */
@Path("user")
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntityInterface> getItems() {
		logger.info("getItems - START");
		
		List<EntityInterface> items = UserService.getInstance().getAll();
		
		return items;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public EntityInterface getItemById(@PathParam("id") Long id) {
		logger.info("getItem - START - id: " + id);
        EntityInterface item= UserService.getInstance().selectById(id);
		
		return item;
	}

	/**
	 * 
	 * This method provides an example of what an HTTP POST method could do.
	 * In this case, provides to log the object received,
	 * sets the id(like an persistence execution) and returns the complete 
	 * object with the id enhanced from database layer. 
	 * 
	 * try from command line with(linux): curl -i -d '{"username":"maurizio", "email":"m@f.it"}' -H "Content-Type: application/json" -X POST http://localhost:8080/demo/user
	 * try from command line with(windows): curl -i -d '{"username":"maurizio", "email":"m@f.it"}' -H "Content-Type: application/json" -X POST http://localhost:8080/demo/user
	 * @param user
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User insert(User item) {
		logger.info("insert - START - object to insert: " + item);
		User insertedItem = UserService.getInstance().insert(item);
		logger.info("insert - END - insertedItem: " + insertedItem);
		return insertedItem ;
	}
	
	/**
	 * 
	 * This method provides an example of what an HTTP PUT method could do.
	 * In this case, provides to log the object received,
	 * and returns the complete 
	 * object.
	 * It needs to do something on the database!!! 
	 * 
	 * try from command line with: curl -d '{"id":10, "username":"maurizio", "email":"m@f.it"}' -H "Content-Type: application/json" -X PUT http://localhost:8080/demo/user
	 * 
	 * @param user
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User update(User item) {
		logger.info("update - START - object to update: " + item);
		User updatedItem = UserService.getInstance().update(item);
		logger.info("update - END - updatedItem: " + updatedItem);
		return updatedItem ;
	}
	
//	/**
//	 * Provides to delete the object.
//	 * It should go on the persistence layer and remove the object by id received.
//	 * 
//	 * try from command line with: curl -X DELETE http://localhost:8080/demo/user/10
//	 * 
//	 * @param id, long id of the object to delete
//	 */
//	@DELETE
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	@Path("{id}/")
//	public boolean deleteUser(@PathParam("id") Long id) {
//		logger.info("deleteUser - START - id user to remove: " + id);
//		return true;
//	}
}
