package com.fzu.repository;

import com.fzu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findById(Long userId);
    public User findByEmail(String email);
    public User findByNickName(String nickName);
    public User findByEmailAndPassword(String email, String password);
    public User findByEmailAndNickName(String email, String password);
}
