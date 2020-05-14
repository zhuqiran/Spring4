package com.csust.transactional.exception;

/**
 * 自定义异常，当购买股票发生错误时，抛出此异常
 */
public class BuyStockException extends Exception {
    public BuyStockException() {
    }

    public BuyStockException(String message) {
        super(message);
    }
}
