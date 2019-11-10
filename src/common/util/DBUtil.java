package common.util;

import java.sql.*;

public class DBUtil {
    static Connection connection;
    static private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    static private final String USERNAME="scott";
    static private final String PWD="tiger";


    public static Connection Conncet(){

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME,PWD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return connection;


    }
    public static int executeUpdate(String sql,Object[] param) throws SQLException {
        Connection connection = Conncet();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i =0;i<param.length;i++){
            preparedStatement.setObject(i,param[i]);
        }
        int update = preparedStatement.executeUpdate();
        DBUtil.connection.close();
        return update;


    }
    public static ResultSet Query(String sql ,Object[] param) throws SQLException {
        Connection connection = Conncet();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i =0;i<param.length;i++){
                preparedStatement.setObject(i,param[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

    }


}
