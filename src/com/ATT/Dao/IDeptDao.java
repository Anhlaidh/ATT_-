package com.ATT.Dao;

import com.ATT.bean.DepartmentBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IDeptDao {
    public void addDept(DepartmentBean dept)throws SQLException;
    public void delDept(DepartmentBean dept) throws SQLException;
    public ResultSet searchDept(String key) throws SQLException;
    public void  updateDept(DepartmentBean dept) throws SQLException;
}
