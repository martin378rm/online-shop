package org.acme.resource;


import org.acme.entity.User;
import org.acme.repository.UserRepository;
import org.acme.service.UserService;
import org.acme.service.UserServiceImpl;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserServiceImpl userService;

    @GET
    public Response getAllUser() {
       List<User> users = userService.showAllUser();
       return Response.ok(users).build();
    }

//    @POST
//    @Transactional
//    @Path("register")
//    public Response postUser(User body) throws NoSuchAlgorithmException, InvalidKeySpecException {
//       User
//    }

}
