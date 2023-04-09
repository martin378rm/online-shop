package org.acme.resource;


import io.vertx.core.json.JsonObject;
import org.acme.entity.User;
import org.acme.repository.UserRepository;
import org.acme.service.UserService;
import org.acme.service.UserServiceImpl;
import org.acme.util.HashingPasswordGenerator;

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

    @Inject
    HashingPasswordGenerator hash;

    @GET
    public Response getAllUser() {
       List<User> users = userService.showAllUser();
       return Response.ok(users).build();
    }

    @POST
    @Transactional
    @Path("register")
    public Response postUser(User body) throws NoSuchAlgorithmException, InvalidKeySpecException {

        if (userService.foundUser(body)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else {
            userService.createUser(body);
            return Response.created(URI.create("user/"+body.getUsername())).build();
        }

    }

    @POST
    @Path("login")
    public Response login(User body) throws NoSuchAlgorithmException, InvalidKeySpecException {
        JsonObject obj = new JsonObject();

        if (userService.foundUser(body)){
            return Response.ok(obj.put("message","berhasil login")).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }

}
