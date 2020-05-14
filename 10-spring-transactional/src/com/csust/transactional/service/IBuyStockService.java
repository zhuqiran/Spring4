package com.csust.transactional.service;

import com.csust.transactional.exception.BuyStockException;

public interface IBuyStockService {
    // 创建账户
    int createAccount(String aname, double money);

    // 创建股票仓库
    int createStock(String sname, int amount);

    // 购买股票
    boolean buyStock(String aname, double money, String sname, int amount) throws BuyStockException;
}
