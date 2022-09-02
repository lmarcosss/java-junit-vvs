package dev.ifrs.usecase;

import dev.ifrs.entity.User;

public interface IUser {
    public User registerUser(String name, String password);
}
