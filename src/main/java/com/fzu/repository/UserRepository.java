package com.fzu.repository;

import com.fzu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
//    User findByNickName(String nickName);

    @Override
    <S extends User> S save(S entity);
}
