package com.rx.mapper;


import com.rx.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountMapper")
public interface AccountMapper {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account (money,name) values (#{money},#{name})")
    void addAccount(Account account);
}
