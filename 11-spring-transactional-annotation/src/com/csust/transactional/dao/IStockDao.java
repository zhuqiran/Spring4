package com.csust.transactional.dao;

public interface IStockDao {
    int update(String sname, int amount);

    int insertStock(String sname, int amount);
}
