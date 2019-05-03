package com.kellylyke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/users")
public class UserService {
    GenericDao<User> userDao = new GenericDao<>(User.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    //@Path("/{param}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getUsers(/*@PathParam("param") @DefaultValue("0") String id*/) {
        List<User> users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

   try {
      users = userDao.getAll();
      logger.debug(users);

      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      String json = ow.writeValueAsString(users);

      return Response.status(200).entity(users).build();
  } catch (Exception e) {
        logger.error("Error getting all users" + e);
        return Response.status(500).entity(e).build();
  }

        //return Response.status(200).entity(output).build();
   }


    @GET
    @Path("/delete/{id}")
    @Consumes("text/plain")
    public void deleteUser(@PathParam("id") int id) {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user;
       // List<User> users = new ArrayList<>();
        try {
            user = userDao.getById(id);
            userDao.delete(user);
            logger.debug(user);
        } catch (Exception e) {
            logger.error("Error getting all users for delete " + e);
        }

//        for(User user : users) {
//            if(user.getId() == id) {
//                userDao.delete(user);
//            }
//        }
        //something should redirect here


        //return Response.status(200).entity(output).build();
    }

}

