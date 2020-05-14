package com.csust.transactional.service;

import com.csust.transactional.dao.IAccountDao;
import com.csust.transactional.dao.IStockDao;
import com.csust.transactional.exception.BuyStockException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int createAccount(String aname, double money) {
        return accountDao.insertAccount(aname, money);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int createStock(String sname, int amount) {
        return stockDao.insertStock(sname, amount);
    }

    @Override
    // 第一个参数：指定事务的传播方式为required；第二个参数：指定事务的隔离级别为DB默认的隔离级别；第三个参数：表示发送该参数指定的异常类型时，进行回滚操作。
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackForClassName = "BuyStockException")
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
