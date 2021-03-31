package com.rx.service.impl;

import com.rx.mapper.AccountMapper;
import com.rx.domain.Account;
import com.rx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public void addAccount(Account account) {
        accountMapper.addAccount(account);
    }
}
