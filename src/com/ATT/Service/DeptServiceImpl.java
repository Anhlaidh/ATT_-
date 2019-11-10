package com.ATT.Service;

import com.ATT.Dao.DeptDaoImpl;
import com.ATT.Dao.IDeptDao;
import com.ATT.bean.DepartmentBean;
import common.util.DBUtil;

import javax.management.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class DeptServiceImpl implements IDeptService {

    public static LinkedList initList(String[] list_name) {
        LinkedList linkedList = new LinkedList();
        for (int i=0;i<list_name.length;i++){
            linkedList.add(initBean(list_name[i]));
        }

        return linkedList;
    }


    public int countTotal() {
        return 0;
    }


    public static Object initBean(String dept_name) {
        DepartmentBean departmentBean = new DepartmentBean();
        try {
            ResultSet query = DeptDaoImpl.searchDept(dept_name);
            while (query.next()){

                departmentBean.setDepartmentId(query.getString("DEPARTMENT_ID"));
                departmentBean.setDepartmentName(query.getString("DEPARTMENT_NAME"));
                departmentBean.setName(query.getString("MANAGER"));
                departmentBean.setTotalUser(query.getInt("TOTAL_USER")+"");
                departmentBean.setCreateTime(query.getString("CREATE_TIME"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentBean;
    }
}
