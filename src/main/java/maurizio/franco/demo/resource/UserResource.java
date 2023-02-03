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

import maurizio.franco.demo.bean.User;

/**
 * Root resource (exposed at "user" path)
 */
@Path("user")
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);

	/**
	 * Method handling HTTP GET request for retrieve bean by id field. The returned
	 * object will be sent to the client as json.
	 *
	 * try from command line with: curl http://localhost:8080/demo/user/20
	 *
	 * @return User object as json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public User getObjectById(@PathParam("id") Long id) {
		logger.info("getObjectById - START - id: " + id);
		//TO DO: something from the persistence layer
		User testUser = new User(11l, "mau", "b@a.it");
		return testUser;
	}

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
	public List<User> getUsers() {
		logger.info("getUsers - START");
		//TO DO: something from the persistence layer
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			users.add(new User((long) i, "mau" + i, i + "@a.it"));
		}
		return users;
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
	public User insertUser(User user) {
		logger.info("insertUser - START - object to insert: " + user);
		//TO DO: something on the persistence layer
		user.setId(105l);
		return user ;
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
	public User updateUser(User user) {
		logger.info("updateUser - START - object to update: " + user);
		//TO DO: something on the persistence layer
		return user ;
	}
	
	/**
	 * Provides to delete the object.
	 * It should go on the persistence layer and remove the object by id received.
	 * 
	 * try from command line with: curl -X DELETE http://localhost:8080/demo/user/10
	 * 
	 * @param id, long id of the object to delete
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/")
	public boolean deleteUser(@PathParam("id") Long id) {
		logger.info("deleteUser - START - id user to remove: " + id);
		return true;
	}
}
