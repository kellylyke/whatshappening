package com.kellylyke.service.com.kellylyke.service.user;

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

  /*      if (id == null) {
            id = "0";
        }
        try {
            if (id.equals("0")){
                users = userDao.getAll();
                logger.debug(users);

                return Response.status(200).entity(users.toString()).build();
            } else {

                User user = userDao.getById(Integer.parseInt(id));
                return Response.status(200).entity(user.toString()).build();

            }*/

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

}

