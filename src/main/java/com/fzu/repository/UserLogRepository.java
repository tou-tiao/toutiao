package com.fzu.repository;

import com.fzu.pojo.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository  extends JpaRepository<UserLog, Long> {
    UserLog findById(Long userLogId);
}
