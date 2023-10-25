package com.daniel.BarberShopDDD.domain.repositories;

import com.daniel.BarberShopDDD.domain.entities.AddressEntity;
import com.daniel.BarberShopDDD.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    AddressEntity findByUser(UserEntity user);
}
