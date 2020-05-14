package com.csust.transactional.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDao extends JdbcDaoSupport implements IStockDao {
    @Override
    public int update(String sname, int amount) {
        String sql = "update stock set count = count + ? where sname = ?";
        int update = this.getJdbcTemplate().update(sql, amount, sname);
        return update;
    }

    @Override
    public int insertStock(String sname, int amount) {
        String sql = "insert into stock(sname, count)values(?, ?)";
        int update = this.getJdbcTemplate().update(sql, sname, amount);
        return update;
    }
}
