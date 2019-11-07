package com.ATT.Dao;

import com.ATT.bean.DepartmentBean;

import common.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDaoImpl implements IDeptDao {
    @Override

    public void addDept(DepartmentBean dept) throws SQLException {
        String sql = "INSERT into T_DEPARTMENT(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER,CREATE_TIME) values (?,?,?,sysdate)";
        Object[] param = {dept.getDepartmentId(),dept.getDepartmentName(),dept.getName()};
        DBUtil.executeUpdate(sql,param);

    }

    @Override
    public void delDept(DepartmentBean dept) throws SQLException {
        String sql = "delete from T_DEPARTMENT where DEPARTMENT_ID = ?";
        Object[] param = {dept.getDepartmentId()};
        DBUtil.executeUpdate(sql,param);


    }

    @Override
    public ResultSet searchDept(String key) throws SQLException {
        String sql = "select * from   T_DEPARTMENT where DEPARTMENT_NAME = ?";
        Object[] param = {key};
        ResultSet query = DBUtil.Query(sql, param);


        return query;
    }

    @Override
    public void updateDept(DepartmentBean dept) throws SQLException {
        String sql = "update T_DEPARTMENT set DEPARTMENT_NAME=? , DEPARTMENT_ID = ?,MANAGER=? where DEPARTMENT_ID=?";
        Object[] param = {dept.getDepartmentName(),dept.getDepartmentId(),dept.getName(),dept.getDepartmentId()};
        DBUtil.executeUpdate(sql,param);


    }
}
