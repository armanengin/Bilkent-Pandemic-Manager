package com.api.bpm.repository;

import com.api.bpm.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<User> findByName(String name);
    List<User> findByBilkentId(Long bilkentId);
    List<User> findByEmail(String email);
}
