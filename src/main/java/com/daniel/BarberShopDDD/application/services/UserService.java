package com.daniel.BarberShopDDD.application.services;

import com.daniel.BarberShopDDD.domain.entities.AddressEntity;
import com.daniel.BarberShopDDD.domain.entities.UserEntity;
import com.daniel.BarberShopDDD.domain.exceptions.UserNotFoundException;
import com.daniel.BarberShopDDD.domain.repositories.AddressRepository;
import com.daniel.BarberShopDDD.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        final UserEntity userCreated = userRepository.save(userEntity);
        return userRepository.findById(userCreated.getId()).orElseThrow();
    }

    public UserEntity findUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found for id: " + userId)
        );
        AddressEntity addr = addressRepository.findByUser(userEntity);
//        AddressEntity addressEntity = addressRepository.findById(1L).orElse(null);
//        userEntity.setAddressEntity(addressEntity);
        userEntity.setAddress(addr);
        return userEntity;
    }
}
