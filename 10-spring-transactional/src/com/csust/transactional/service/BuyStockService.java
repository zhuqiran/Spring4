package com.csust.transactional.service;

import com.csust.transactional.dao.IAccountDao;
import com.csust.transactional.dao.IStockDao;
import com.csust.transactional.exception.BuyStockException;

public class BuyStockService implements IBuyStockService {

    // 注入两个Dao层对象
    private IAccountDao accountDao;
    private IStockDao stockDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setStockDao(IStockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public int createAccount(String aname, double money) {
        return accountDao.insertAccount(aname, money);
    }

    @Override
    public int createStock(String sname, int amount) {
        return stockDao.insertStock(sname, amount);
    }

    @Override
    public boolean buyStock(String aname, double money, String sname, int amount) throws BuyStockException {
        boolean flag = false;
        int count = accountDao.update(aname, money);
        if(1 == 1){
            // 抛出异常
            throw new BuyStockException("购买股票时出现异常！");
        }
        if(count > 0){
            int rs = stockDao.update(sname, amount);
            if (rs > 0)
                flag = true;
        }
        return flag;
    }
}
