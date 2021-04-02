package com.rx.mapper;


import com.rx.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
@Mapper
public interface UserMapper {
    /**
     * 查询所有
     * @return 查询的用户结果集
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 添加用户
     * @param user 需要添加的用户
     */
    @Select("insert into user values (#{id},#{username},#{birthday},#{sex},#{address})")
    void addUser(User user);

    /**
     * 根据ID删除用户
     * @param id 用户的id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUserById(Integer id);

    /**
     * 更新用户数据
     * @param user 新数据
     */
    @Update("update user set username = #{username},birthday = #{birthday},sex = #{sex},address = #{address} where id = #{id}")
    void updateUser(User user);
}
