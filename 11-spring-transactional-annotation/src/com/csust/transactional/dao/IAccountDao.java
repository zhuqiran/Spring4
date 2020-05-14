package com.csust.transactional.dao;

public interface IAccountDao{
    int insertAccount(String aname, double money);

    int update(String aname, double money);
}
