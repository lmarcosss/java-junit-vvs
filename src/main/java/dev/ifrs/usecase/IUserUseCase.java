package dev.ifrs.usecase;

import dev.ifrs.entity.User;

public interface IUserUseCase {
    public User registerUser(String name, String password);
}
