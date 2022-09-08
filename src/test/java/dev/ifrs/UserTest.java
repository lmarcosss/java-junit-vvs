package dev.ifrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ifrs.entity.User;
import dev.ifrs.repository.IRepository;
import dev.ifrs.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @InjectMocks
    UserService uc;

    @Mock
    IRepository repo;

    @BeforeEach
    void beforeEach() {
        uc = new UserService();
    }

    @Test
    void registerSuccess() {
        String name = "name";
        String password = "password";

        User user = uc.registerUser(name, password);

        assertNotNull(user);
        assertEquals(user.getName(), name);
        assertEquals(user.getPassword(), password);
    }

    @Test
    void registerFail() {
        String name = "name";
        String password = "pass";

        IllegalArgumentException thrown = assertThrows(
           IllegalArgumentException.class,
           () -> uc.registerUser(name, password),
           "Deveria estourar IllegalArgumentException para senha invalida"
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Senha Invalida"));
    }
}
