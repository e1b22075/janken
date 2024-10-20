package oit.is.z2354.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import oit.is.z2354.kaizi.janken.model.User;

@Mapper
public interface UserMapper {
  @Select("SELECT name FROM users")
  ArrayList<User> selectAllByUserName();

  @Select("SELECT * FROM users Where id = #{id}")
  User selectAll(Integer id);

  @Select("SELECT id FROM users Where name = #{name}")
  int selectname(String name);

}
