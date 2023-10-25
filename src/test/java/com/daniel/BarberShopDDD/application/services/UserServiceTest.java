package com.daniel.BarberShopDDD.application.services;

import com.daniel.BarberShopDDD.domain.entities.AddressEntity;
import com.daniel.BarberShopDDD.domain.entities.UserEntity;
import com.daniel.BarberShopDDD.domain.exceptions.UserNotFoundException;
import com.daniel.BarberShopDDD.domain.repositories.AddressRepository;
import com.daniel.BarberShopDDD.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        // Realize qualquer configuração inicial necessária, como criar um usuário de teste no banco de dados.
    }

    @Test
    public void testCreateUser() {
        AddressEntity address = new AddressEntity(
                "Rua A",
                "212",
                "Bairro B",
                "City C",
                "DE",
                "13898-727",
                null,
                null
        );

        // Crie um usuário de teste
        UserEntity user = new UserEntity(
                "John Doe",
                LocalDate.of(1998,03,23),
                "john1998",
                "senha123",
                "124324123423",
                address
        );

        // Chame o método de criação de usuário
        UserEntity createdUser = userService.createUser(user);

        // Verifique se o usuário foi criado com sucesso
        assertNotNull(createdUser.getId());
        assertNotNull(createdUser.getAddress().getId());

        Optional<AddressEntity> addressFound = addressRepository.findById(createdUser.getAddress().getId());

//        Collection<UserEntity> allusers = userRepository.findAll();

        // Verifique se o usuário existe no banco de dados
        UserEntity retrievedUser = userRepository.findById(createdUser.getId()).orElse(null);
        assertNotNull(retrievedUser);
        assertEquals("John Doe", retrievedUser.getFullName());
    }

    @Test
    public void testFindUserById() {
        AddressEntity address = new AddressEntity(
                "Rua A",
                "212",
                "Bairro B",
                "City C",
                "DE",
                "13898-727",
                null,
                null
        );

        // Crie um usuário de teste
        UserEntity user = new UserEntity(
                "Jane Smith",
                LocalDate.of(1998,03,23),
                "john1998",
                "senha123",
                "423423423",
                address
        );

        // Salve o usuário no banco de dados
        UserEntity savedUser = userRepository.save(user);

        // Chame o método para encontrar o usuário pelo ID
        Long userId = savedUser.getId();
        UserEntity foundUser = userService.findUserById(userId);

        // Verifique se o usuário foi encontrado corretamente
        assertEquals(savedUser.getFullName(), foundUser.getFullName());
    }

    @Test
    public void testFindUserById_UserNotFound() {
        // Tente encontrar um usuário com um ID que não existe no banco de dados
        Long nonExistentUserId = 33L;

        // Verifique se o método lança a exceção UserNotFoundException
        assertThrows(UserNotFoundException.class, () -> userService.findUserById(nonExistentUserId));
    }
}