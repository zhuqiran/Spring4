package com.aop.advice.instance04;

public interface ILoginService {
    boolean login(String userName, String password) throws UserNameException, PasswordException;
}
