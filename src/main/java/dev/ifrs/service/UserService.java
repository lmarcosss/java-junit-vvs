package dev.ifrs.service;

import javax.inject.Singleton;

import dev.ifrs.entity.User;
import dev.ifrs.repository.IRepository;
import dev.ifrs.repository.Repository;
import dev.ifrs.usecase.IUserUseCase;

@Singleton
public class UserService implements IUserUseCase {
    private IRepository repo = new Repository();

    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    public User registerUser(String name, String password) {
        if (!isPasswordValid(password)) throw new IllegalArgumentException("Senha Invalida");

        User user = new User(name, password);

        repo.persistUser(user);

        return 
    }
}
