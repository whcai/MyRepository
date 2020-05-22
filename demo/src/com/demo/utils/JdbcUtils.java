package com.demo.utils;

import com.demo.beans.TUser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : whc
 * @Project: demo
 * @Package com.study.test
 * @Description: TODO
 * @date Date : 2020年04月24日 9:14
 */
public class JdbcUtils {


    private static String URL = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "sa";
    //需要对密码进行加密处理
    private static String PASSWORD = "awfi";

    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //私有实例化，防止用户创建工具类
    private JdbcUtils() {
    }

    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Object> list = new ArrayList<Object>();
        TUser t = new TUser();
        t.setUsername("管理员4");
        t.setUserid("whc");
        TUser t2 = new TUser();
        t2.setUsername("管理员4");
        t2.setUserid("whc");
        list.add(t);
        list.add(t2);

        int i = JdbcUtils.batchUpdate("t_user", "userid;username", "id", list);
        System.out.println(i);
//       List<Object> list = new ArrayList<Object>();
//       TUser tUser = new TUser();
//       tUser.setUserid("wlj8");
//       tUser.setPassword("123");
//       tUser.setUsername("管理员");
//       tUser.setRoleid("1");
//       TUser t2 = new TUser();
//       t2.setUserid("wlj9");
//       t2.setPassword("123");
//       t2.setUsername("管理员");
//       t2.setRoleid("1");
//
//       list.add(tUser);
//       list.add(t2);
//       int i = JdbcUtils.batchAdd("t_user", "userid;username;password;roleid", list);
//        System.out.println(i);

//       Test t = new Test();
//       t.setId("11");
//       t.setName("dd");
//       int i = JdbcUtils.add("test", "id;name", t);
//       System.out.println(i);

//       List<String> list = new ArrayList<>();
//       for (int i = 3; i < 11; i++) {
//            String sql = "delete  from test where id="+i;
//            list.add(sql);
//       }
//       int result = JdbcUtils.batchDelete(list);
//       System.out.println(result);

    }

    private static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            throw new Error("数据库连接失败");
        }
        return conn;
    }

    //执行sql语句
    public static int execute(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            boolean flag = ps.execute();
            if (flag) {
                conn.commit();
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return -1;
    }


    //增加类
    public static <T> int add(String table, String columns, T clazz) throws IllegalAccessException, InstantiationException, SQLException {
        int result = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        StringBuffer sql = new StringBuffer("insert into ");
        String[] split = columns.split(";");
        sql.append(table).append("(");
        for (int i = 0; i < split.length; i++) {
            sql.append(split[i].trim());
            if (i != split.length - 1) {
                sql.append(",");
            }
        }
        sql.append(")").append(" values(");
        for (int i = 0; i < split.length; i++) {
            sql.append("?");
            if (i != split.length - 1) {
                sql.append(",");
            }
        }
        sql.append(")");
        System.out.println(sql.toString());
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            Method[] methods = clazz.getClass().getDeclaredMethods();
            for (int i = 0; i < split.length; i++) {
                String columnName = split[i];
                String fieldName = JdbcUtils.getFieldName(columnName);
                for (Method m : methods) {
                    String methodName = m.getName();
                    if (fieldName.equals(methodName.toUpperCase())) {
                        String object = (String) m.invoke(clazz, new Object[]{});
                        ps.setString(i + 1, object);
                        break;
                    } else {
                        continue;
                    }
                }
            }
            result = ps.executeUpdate();
            if (result > 0) {
                conn.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return result;
    }

    public static <T> int batchAdd(String table, String columns, List<T> list) throws IllegalAccessException, InstantiationException, SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String[] split = columns.split(";");
        StringBuffer sql = new StringBuffer("insert into ");
        sql.append(table);
        sql.append("(");
        for (int j = 0; j < split.length; j++) {
            sql.append(split[j].trim());
            if (j != split.length - 1) {
                sql.append(",");
            }
        }
        sql.append(") ");
        sql.append("values (");
        for (int j = 0; j < split.length; j++) {
            sql.append("?");
            if (j != split.length - 1) {
                sql.append(",");
            }
        }
        sql.append(")");
        System.out.println(sql.toString());
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < list.size(); i++) {
                T t = list.get(i);
                Method[] methods = t.getClass().getDeclaredMethods();
                for (int j = 0; j < split.length; j++) {
                    String fieldName = JdbcUtils.getFieldName(split[j]);
                    for (Method m : methods) {
                        String methodName = m.getName();
                        if (fieldName.equals(methodName.toUpperCase())) {
                            String fieldValue = (String) m.invoke(t, new Object[]{});
                            ps.setString(j + 1, fieldValue);
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                ps.addBatch();
            }
            int[] results = ps.executeBatch();

            // 根据批量执行结果，有一条不成功，即回滚事务
            for (int i = 0; i < results.length; i++) {
                if (results[i] == 1) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                conn.commit();
                return 1;
            } else {
                conn.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return -1;
    }

    //更新类
    public static <T> int update(String table, String columns, String serialied, T clazz) throws SQLException {
        int result = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        String[] column = columns.split(";");
        StringBuffer sql = new StringBuffer("update " + table);
        sql.append(" set ");
        for (int i = 0; i < column.length; i++) {
            sql.append(column[i]).append(" =?");
            if (i != column.length - 1) {
                sql.append(",");
            }
        }
        sql.append(" where ");
        sql.append(serialied);
        sql.append(" = ?");
        System.out.println(sql.toString());
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql.toString().trim());
            Method[] methods = clazz.getClass().getDeclaredMethods();
            String lastFieldName = JdbcUtils.getFieldName(serialied);
            for (int i = 0; i < column.length; i++) {
                String fieldName = JdbcUtils.getFieldName(column[i]);
                for (Method m : methods) {
                    String methodName = m.getName();
                    if (methodName.toUpperCase().equals(fieldName)) {
                        String fieldValue = (String) m.invoke(clazz, new Object[]{});
                        ps.setString(i + 1, fieldValue);
                        break;
                    } else {
                        continue;
                    }
                }

            }
            // 条件赋值
            for (Method m : methods) {
                String methodName = m.getName();
                if (methodName.toUpperCase().equals(lastFieldName)) {
                    String fieldValue = (String) m.invoke(clazz, new Object[]{});
                    ps.setString(column.length + 1, fieldValue);
                    break;
                }
            }
            result = ps.executeUpdate();
            if (result > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return result;
    }

    //批量更新类
    public static <T> int batchUpdate(String table, String columns, String serialied, List<T> list) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String[] column = columns.split(";");
        StringBuffer sql = new StringBuffer("update " + table);
        sql.append(" set ");
        for (int i = 0; i < column.length; i++) {
            sql.append(column[i]).append(" =?");
            if (i != column.length - 1) {
                sql.append(",");
            }
        }
        sql.append(" where ");
        sql.append(serialied);
        sql.append(" = ?");
        System.out.println(sql.toString());
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql.toString().trim());
            for (int i = 0; i < list.size(); i++) {
                T t = list.get(i);
                Method[] methods = t.getClass().getDeclaredMethods();
                String lastFieldName = JdbcUtils.getFieldName(serialied);
                for (int j = 0; j < column.length; j++) {
                    String fieldName = JdbcUtils.getFieldName(column[j]);
                    for (Method m : methods) {
                        String methodName = m.getName();
                        if (methodName.toUpperCase().equals(fieldName)) {
                            String fieldValue = (String) m.invoke(t, new Object[]{});
                            ps.setString(j + 1, fieldValue);
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                // 条件赋值
                for (Method m : methods) {
                    String methodName = m.getName();
                    if (methodName.toUpperCase().equals(lastFieldName)) {
                        String fieldValue = (String) m.invoke(t, new Object[]{});
                        ps.setString(column.length + 1, fieldValue);
                        break;
                    }
                }
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            //循环遍历每条语句执行结果，有一条语句执行不成功，即回滚数据
            for (int i : results) {
                if (i > 0) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                conn.commit();
                return 1;
            } else {
                conn.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return -1;
    }

    //删除
    public static int delete(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = -1;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
            if (result > 0) {
                conn.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return result;
    }

    //批量删除
    public static int batchDelete(List<String> sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = -1;
        boolean flag = false;
        try {
            conn = JdbcUtils.getConnection();
            for (String s : sql) {
                ps = conn.prepareStatement(s);
                result = ps.executeUpdate();
                if (result > 0) {
                    continue;
                } else {
                    flag = true;
                }

            }
            if (!flag) {
                conn.commit();
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JdbcUtils.close(conn, ps);
        }
        return -1;
    }

    public static <T> T selectOne(String sql, Class<T> clazz) {
        Connection conn = null;
//        Statement statement = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        T t = null;
        try {
            conn = JdbcUtils.getConnection();
//            statement = conn.createStatement();
//            rs = statement.executeQuery(sql);
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            ResultSetMetaData rsmd = null;
            Method[] methods = clazz.getDeclaredMethods();
            while (rs.next()) {
                t = clazz.newInstance();
                rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String tableName = rsmd.getColumnName(i);
                    String tableValue = rs.getString(tableName);
                    int columnType = rsmd.getColumnType(i);
                    for (Method m : methods) {
                        String methodName = m.getName();
                        String fieldName = JdbcUtils.setFieldName(tableName);
                        if (methodName.toUpperCase().equals(fieldName)) {
                            //根据表格数据类型,对数据进行格式转换
                            if (columnType == 4) {
                                m.invoke(t, Integer.parseInt(tableValue));
                            } else if (columnType == 92) {
                                String formatter = "HH:mm:ss";
                                SimpleDateFormat sdf = new SimpleDateFormat(formatter);
                                m.invoke(t, sdf.parse(tableValue));
                            } else {
                                m.invoke(t, tableValue);
                            }
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, statement, rs);
        }
        return t;
    }

    public static <T> List<T> select(String sql, Class<T> clazz) {
        Connection conn = null;
//        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T t = null;
        ArrayList<T> list = new ArrayList<T>();
        try {
            conn = JdbcUtils.getConnection();
//            statement = conn.createStatement();
//            rs = statement.executeQuery(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = null;
            Method[] methods = clazz.getDeclaredMethods();
            while (rs.next()) {
                t = clazz.newInstance();
                rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String tableName = rsmd.getColumnName(i);
                    String tableValue = rs.getString(tableName);
                    int columnType = rsmd.getColumnType(i);
                    for (Method m : methods) {
                        String methodName = m.getName();
                        String fieldName = JdbcUtils.setFieldName(tableName);
                        if (methodName.toUpperCase().equals(fieldName)) {
                            //根据表格数据类型,对数据进行格式转换
                            if (columnType == 4) {
                                m.invoke(t, Integer.parseInt(tableValue));
                            } else if (columnType == 92) {
                                String formatter = "HH:mm:ss";
                                SimpleDateFormat sdf = new SimpleDateFormat(formatter);
                                m.invoke(t, sdf.parse(tableValue));
                            } else {
                                m.invoke(t, tableValue);
                            }
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, ps, rs);
        }
        return list;
    }

    private static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(Connection conn, Statement statement) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(Connection conn, Statement statement, ResultSet resultSet) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String setFieldName(String field) {
        if (field == null) {
            return "";
        }
        if (field.length() == 0) {
            return "";
        }
        return "SET" + field.toUpperCase();
    }

    public static String getFieldName(String field) {
        if (field == null) {
            return "";
        }
        if (field.length() == 0) {
            return "";
        }
        return "GET" + field.toUpperCase();
    }

}