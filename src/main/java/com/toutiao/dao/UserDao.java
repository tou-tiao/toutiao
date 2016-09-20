package com.toutiao.dao;

import com.toutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int  volidLogin(final String email,final String userPass){

        String strSql = "select * from t_user "
                +" where email= ? and pass_word= ? ";
        final User user = new User();
        jdbcTemplate.query(strSql, new Object[]{ email ,userPass}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUid(resultSet.getInt("uid"));
                user.setEmail(email);
            }
        });
        if(user.getUid() >0){
            return user.getUid();
        }else{
            return -1;
        }
    }

}
