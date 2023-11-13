package com.abulibde.perfectbathroom.repository;

import com.abulibde.perfectbathroom.model.entity.UserEntity;
import com.abulibde.perfectbathroom.service.impl.UserServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

}
