package com.example.study1.repository;

import com.example.study1.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// repository는 쿼리문 없이 CRUD 쓸 수 있게 해주는거
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
// User는 어떤 object에 대한 repository인지, Long은 key의 data-type

    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    Optional<User> findByAccountAndEmail(String account, String email);
}
