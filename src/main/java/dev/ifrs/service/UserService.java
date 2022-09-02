package dev.ifrs.service;

import javax.inject.Singleton;

import dev.ifrs.entity.User;
import dev.ifrs.usecase.IUser;

@Singleton
public class UserService implements IUser {
    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    public User registerUser(String name, String password) {
        if (!isPasswordValid(password)) throw new IllegalArgumentException("Senha Invalida");

        return new User(name, password);
    }
}
