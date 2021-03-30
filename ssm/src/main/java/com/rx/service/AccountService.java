package com.rx.service;

import com.rx.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    void addAccount(Account account);
}
