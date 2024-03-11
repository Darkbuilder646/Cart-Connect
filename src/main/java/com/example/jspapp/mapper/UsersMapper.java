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
    List<Users> getAllUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users getById(Long id);

    @Select("SELECT * FROM users WHERE email = #{email}")
    Users getByEmail(String email);


}
