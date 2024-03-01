package com.example.jspapp.mapper;

import com.example.jspapp.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Insert("INSERT INTO users (pseudo, email, password) VALUES (#{pseudo}, #{email}, #{password})")
    void save(Users user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(Long id);

    @Update("UPDATE users SET pseudo = #{pseudo}, email = #{email}, password = #{password}")
    void update(Users user);

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "pseudo", column = "pseudo"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password")
    })
    List<Users> getAllUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "pseudo", column = "pseudo"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password")
    })
    Users getById(Long id);

    @Select("SELECT * FROM users WHERE email = #{email}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "pseudo", column = "pseudo"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password")
    })
    Users getByEmail(String email);

}
