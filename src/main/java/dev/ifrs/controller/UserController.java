package dev.ifrs.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import dev.ifrs.entity.User;
import dev.ifrs.usecase.IUserUseCase;
import dev.ifrs.view.RegisterUserView;

@Path("/user")
public class UserController {
    @Inject
    IUserUseCase userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/register")
    public void register(RegisterUserView user) {
        userService.registerUser(new User(user.name, user.password));
    }
}
