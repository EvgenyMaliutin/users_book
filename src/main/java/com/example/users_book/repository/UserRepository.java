package com.example.users_book.repository;

import com.example.users_book.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Репозиторий для работы с БД.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
