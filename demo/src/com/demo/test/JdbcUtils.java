package com.demo.test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.TUser;

public class JdbcUtils {
	private static String URL = "jdbc:mysql://localhost:3306/demo";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String USERNAME = "sa";
	// 需要对密码进行加密处理
	private static String PASSWORD = "awfi";

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 私有实例化，防止用户创建工具类
	private JdbcUtils() {

	}

	public static void main(String[] args) throws SQLException {
		String sql = "select * from t_user ";
		// List<TUser> t = JdbcUtils.select(sql, TUser.class);

		TUser t = JdbcUtils.selectOne(sql, TUser.class);
		System.out.println(t.toString());
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

	// 增加类
	public static <T> int add(Class<T> clazz) throws IllegalAccessException, InstantiationException {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = JdbcUtils.getConnection();
			statement = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			String talbeName = m.getName();

		}
		return 1;
	}

	public static <T> int batchAdd(List<T> list) {

		return 1;
	}

	// 更新类
	public static <T> int update(Class<T> clazz) {

		return 1;
	}

	// 批量更新类
	public static <T> int batchUpdate(List<T> list) {

		return 1;
	}

	// 删除
	public static int delete(String sql) {

		return 1;
	}

	// 批量删除
	public static int batchDelete() {

		return 1;
	}

	public static <T> T selectOne(String sql, Class<T> clazz) {
		Connection conn = null;
		// Statement statement = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		T t = null;
		try {
			conn = JdbcUtils.getConnection();
			// statement = conn.createStatement();
			// rs = statement.executeQuery(sql);
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			ResultSetMetaData rsmd = null;
			Method[] methods = clazz.getMethods();
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
							// 根据表格数据类型,对数据进行格式转换
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
		// Statement statement = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T t = null;
		ArrayList<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtils.getConnection();
			// statement = conn.createStatement();
			// rs = statement.executeQuery(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = null;
			Method[] methods = clazz.getMethods();
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
							// 根据表格数据类型,对数据进行格式转换
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
