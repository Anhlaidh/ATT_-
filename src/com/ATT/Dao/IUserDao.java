package com.ATT.Dao;

import com.ATT.bean.UserInfo;

import java.util.LinkedList;

public interface IUserDao {


    public void addUser();
    public void delUser();
    public LinkedList<UserInfo>  searchUser();
    public void  updateUser();
}
