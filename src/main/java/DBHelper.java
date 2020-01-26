package main.java;

/**
 * Created by Cao Lei on 24/3/17.
 */

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import java.sql.*;

public class DBHelper {

	public static void main(String args[]) {

		DBHelper dbHelper = new DBHelper(CommonShared.db_hostname, CommonShared.db_username, CommonShared.db_password);

	}

	private BasicDataSource source;

	public DBHelper(String hostname, String username, String password) {
		System.out.println("Creating DB " + hostname);
		try {
			source = new BasicDataSource();
			source.setDriverClassName("com.mysql.jdbc.Driver");
			String connection = "jdbc:mysql://" + hostname + ":3306/5han?autoReconnect=true";
			source.setUrl(connection);
			source.setPassword(password);
			source.setUsername(username);
			source.setTestOnBorrow(true);
			source.setInitialSize(100);
			source.setMaxActive(100);
			source.setMaxIdle(10);
			Connection con = source.getConnection();
			con.close();
			System.out.println("*********************");
			System.out.println("Finish Initialize DB!");
			System.out.println("*********************");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail to initialize DB! ");
		}
	}

	public void status() {
		System.out.println(" Max active - " + source.getMaxActive() + "active - " + source.getNumActive() + " idle - "
				+ source.getNumIdle());
	}

//    public User getUserByIdAndAgentId(int id) {
//        User user = new User();
//        String query;
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        query = "select * from auth_user where id=" + id;
//
//        System.out.println(query + " id:" + id);
//        try {
//            con = source.getConnection();
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery(query);
//            if (rs.next()) {
//                user.userId = rs.getInt("id");
//                user.status = rs.getInt("status");
//                user.email = rs.getString("email");
//                user.type = rs.getInt("type");
//            }
//            rs.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return user;
//    }
//
//    public User getUserById(int id) {
//        User user = new User();
//        String query;
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        query = "select * from auth_user where id=" + id;
//
//        System.out.println(query + " id:" + id);
//        try {
//            con = source.getConnection();
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery(query);
//            if (rs.next()) {
//                user.userId = rs.getInt("id");
//                user.status = rs.getInt("status");
//                user.email = rs.getString("email");
//                user.type = rs.getInt("type");
//            }
//            rs.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return user;
//    }

} // end
