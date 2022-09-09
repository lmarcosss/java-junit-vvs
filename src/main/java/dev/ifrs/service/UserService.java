package dev.ifrs.service;

import javax.inject.Singleton;

import dev.ifrs.entity.User;
import dev.ifrs.repository.IRepository;
import dev.ifrs.usecase.IUserUseCase;

@Singleton
public class UserService implements IUserUseCase {
    private IRepository repo;

    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    public User registerUser(User user) {
        if (!isPasswordValid(user.getPassword())) throw new IllegalArgumentException("Senha Invalida");

        return repo.persistUser(user);
    }
}
