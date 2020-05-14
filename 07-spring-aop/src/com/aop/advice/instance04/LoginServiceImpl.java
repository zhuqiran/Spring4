package com.aop.advice.instance04;

public class LoginServiceImpl implements ILoginService {

    @Override
    public boolean login(String userName, String password) throws UserNameException, PasswordException {
        if(!"lisi".equals(userName)){
            throw new UserNameException("输入的用户名格式不合法!");
        }else if (!"111".equals(password)){
            throw new PasswordException("输入的密码格式不合法!");
        }/*else{
            throw new UserException("系统发生未知错误，请稍后再试！");
        }*/
        return true;
    }
}
