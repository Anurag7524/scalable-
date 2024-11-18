package com.example.user.repository;

import com.example.user.entity.Userd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userd, Long> {
    Userd findByUserId(Long userId);
}
