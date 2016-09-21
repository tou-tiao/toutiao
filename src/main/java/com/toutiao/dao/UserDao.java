package com.toutiao.dao;

import com.toutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao implements UserDaoImpl{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User getUser(final String email,final String passWord){

        String strSql = "select * from t_user "
                +" where email=? and pass_word=? ";
        final User user = new User();
        jdbcTemplate.query(strSql, new Object[]{ email ,passWord}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                    user.setUid(resultSet.getInt("uid"));
                    user.setEmail(email);
                    user.setPassWord(passWord);
            }
        });
        return user;
    }
}
