package com.fzu.repository;

import com.fzu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);
    User findByEmail(String email);

}
