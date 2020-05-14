package com.csust.transactional.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDao extends JdbcDaoSupport implements IAccountDao {
    @Override
    public int insertAccount(String aname, double money) {
        String sql = "insert into account(aname, balance)values(?, ?)";
        int update = this.getJdbcTemplate().update(sql, aname, money);
        return update;
    }

    @Override
    public int update(String aname, double money) {
        String sql = "update account set balance = balance - ? where aname = ?";
        int update = this.getJdbcTemplate().update(sql, money, aname);
        return update;
    }
}
